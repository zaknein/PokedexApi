package com.zaknein.PokedexApi.repository;

import org.springframework.stereotype.Service;
import com.zaknein.PokedexApi.exceptions.NoPokeFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zaknein.PokedexApi.domain.CapturePokemon;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class CapturedPokeRepositoryImpl implements CapturedPokeRepository {

    private static final File pokeFile = new File("capturePokemon.json");
    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private Map<Integer, List<CapturePokemon>> capturedPokeMap = new HashMap<>();

    public CapturedPokeRepositoryImpl() throws IOException {
        if (pokeFile.exists()) {
            
            capturedPokeMap = mapper.readValue(pokeFile, new TypeReference<Map<Integer, List<CapturePokemon>>>() {});

        } else {
            capturedPokeMap = new HashMap<>();
        }
    }

    @Override
    public CapturePokemon enterCapturedPoke(int userId, CapturePokemon capturePokemon) {

        CapturePokemon newCaptured = null;
        if (capturedPokeMap.get(userId) != null) {
            List<CapturePokemon> userPokes = capturedPokeMap.get(userId);
            int capturedId = userPokes.size();
            capturedId++;
            newCaptured = new CapturePokemon(capturedId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
                    capturePokemon.getLevel(), capturePokemon.getCapturedAt());

            userPokes.add(newCaptured);

            capturedPokeMap.put(userId, userPokes);

        } else {
            List<CapturePokemon> userPokes = new ArrayList<>();
            int capturedId = userPokes.size();
            capturedId++;
            newCaptured = new CapturePokemon(capturedId, capturePokemon.getPokemonId(), capturePokemon.getNickname(),
                    capturePokemon.getLevel(), capturePokemon.getCapturedAt());

            userPokes.add(newCaptured);

            capturedPokeMap.put(userId, userPokes);

        }
        sync();
        return newCaptured;
    }

    @Override
    public List<CapturePokemon> getAllOfYourPoke(int userId) {
        List<CapturePokemon> allPokeList = capturedPokeMap.get(userId);
        return allPokeList;
    }

    @Override
    public void freePokeById(int userId, Integer capturedId) {

        List<CapturePokemon> selectToFreeList = capturedPokeMap.get(userId);

        if (selectToFreeList != null) {
            Iterator<CapturePokemon> iterator = selectToFreeList.iterator();
            while (iterator.hasNext()) {
                CapturePokemon poke = iterator.next();

                if (poke.getCapturedId() == capturedId) {
                    iterator.remove();
                }
            }
        } else {
            throw new NoPokeFoundException("There is no pokemon with the id " + capturedId + " try again");
        }
        sync();

    }

    @Override
    public boolean isCaptured(int id) {
        
        for (List<CapturePokemon> listaDePokes : capturedPokeMap.values()) {
            for (CapturePokemon CapturePokemon : listaDePokes) {
                if (CapturePokemon.getPokemonId() == id) {
                    return true;
                }
            }
        }
        return false;

    }

    public void sync() {
        try {
            mapper.writeValue(pokeFile, capturedPokeMap);
        } catch (IOException e) {
            System.out.println("No existe archivo");
            e.printStackTrace();
        }
    }

}
