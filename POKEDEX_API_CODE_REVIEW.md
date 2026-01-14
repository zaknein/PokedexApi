# 📋 Revisión de Código

**Proyecto:** PokedexApi (Spring Boot REST API)  
**Fecha:** 9 Enero 2026  

---

Posibles estados:
- ❌ PENDIENTE
- ✅ RESUELTO

Al solucionar cada comentario, cambiar el estado.

---

### **Error de Generación de ID en PokemonRepositoryImpl**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L37)

```java
private int futurePokeId = 1;
```

**Problema:** El contador de IDs se reinicia a 1 cada vez que la aplicación se reinicia. Si hay Pokemon existentes cargados desde el JSON, se producirán colisiones de IDs y sobrescritura de datos.

**Fix:** Inicializar `futurePokeId` basándose en el ID máximo existente en el mapa.

---

### **Validación Redundante de Null en Varias Ubicaciones**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L60)

```java
if(poke.isEmpty() || poke == null){
```

**Problema:** Una lista recién creada con `new ArrayList()` nunca puede ser null. El orden de la comprobación también está mal (debería verificar null primero si fuera posible).

**Fix:** Eliminar `|| poke == null` y mantener solo `if(poke.isEmpty())`

---

### **Duplicación de Lógica en enterCapturedPoke**
✅  PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/CapturedPokeRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/CapturedPokeRepositoryImpl.java#L34-L62)

```java
if (capturedPokeMap.get(userId) != null) {
    List<CapturePokemon> userPokes = capturedPokeMap.get(userId);
    int capturedId = userPokes.size();
    capturedId++;
    // ... código duplicado
} else {
    List<CapturePokemon> userPokes = new ArrayList<>();
    int capturedId = userPokes.size();
    capturedId++;
    // ... mismo código duplicado
}
```

**Problema:** El código dentro de ambas ramas del if-else es prácticamente idéntico, violando el principio DRY (Don't Repeat Yourself).

**Fix:** Extraer la lista al inicio usando `getOrDefault()` y eliminar duplicación.

---

### **Retorno Redundante en Métodos de Búsqueda**
✅  PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L72-L78)

```java
Pokemon poke = pokemonMap.get(id);
if(poke == null){
    throw new NoPokeFoundException(...);
}else{
    return pokemonMap.get(id); // ¿Por qué llamar .get() otra vez?
}
```

**Problema:** Se obtiene el Pokemon en una variable `poke` pero luego se vuelve a llamar a `get(id)` en lugar de retornar la variable.

**Fix:** Retornar directamente `poke` en lugar de llamar a `get(id)` nuevamente.

---

### **Falta de @ResponseStatus en Endpoints POST**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java#L45)

```java
@PostMapping("/pokemon")
public Pokemon createPokemon(@RequestBody PokemonCreater pokemonCreater) {
```

**Problema:** Las peticiones POST deberían retornar `201 Created`, no `200 OK`.

**Fix:** Agregar `@ResponseStatus(HttpStatus.CREATED)` al método.

---

### **Falta de @ResponseStatus en Endpoints DELETE**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java#L56)

```java
@DeleteMapping("/pokemon/{id}")
public void deletePokemon(@PathVariable int id) {
```

**Problema:** Las peticiones DELETE deberían retornar `204 No Content`, no `200 OK`.

**Fix:** Agregar `@ResponseStatus(HttpStatus.NO_CONTENT)` al método.

---

### **Lógica de Negocio en la Capa de Repositorio**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L59-L65)

```java
public List<Pokemon> getThemAll(){
    List<Pokemon> poke = new ArrayList(pokemonMap.values());
    if(poke.isEmpty() || poke == null){
        throw new NoPokeFoundException("There is no pokemon to list");
    }
    // ...
}
```

**Problema:** El repositorio está lanzando excepciones de negocio. Los repositorios deberían solo manejar acceso a datos; la validación de negocio pertenece a la capa de servicio.

**Fix:** Mover la validación de lista vacía a la capa de servicio.

---

### **NoUserFoundException no está en GlobalExceptionHandler**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/exceptions/GlobalExceptionHandler.java](src/main/java/com/zaknein/PokedexApi/exceptions/GlobalExceptionHandler.java)

```java
// Falta manejador para NoUserFoundException
```

**Problema:** La excepción `NoUserFoundException` se usa en el código pero no tiene un manejador en el `GlobalExceptionHandler`.

**Fix:** Agregar manejador para `NoUserFoundException`.

---

### **Nombre de Variable No Sigue Convenciones Java**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/UserCaptredPokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/UserCaptredPokemonController.java#L23)

```java
private CapturedPokeService CapPoke;
```

**Problema:** Las variables en Java deben comenzar con minúscula según las convenciones de nomenclatura (camelCase).

**Fix:** Renombrar a `capturedPokeService`.

---

### **Errores Tipográficos en el Código**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/UserCaptredPokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/UserCaptredPokemonController.java)

```java
public class UserCaptredPokemonController {
    // "Captred" debería ser "Captured"
}
```

**Problema:** Múltiples errores tipográficos: "Captred" en lugar de "Captured", "Creater" en lugar de "Creator".

**Fix:** Corregir todos los errores de ortografía en nombres de clases, archivos y variables.

---

### **Uso de ArrayList en Lugar de List (Interfaz)**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/domain/Pokemon.java](src/main/java/com/zaknein/PokedexApi/domain/Pokemon.java#L14)

```java
ArrayList<String> types;
```

**Problema:** Se está programando contra una implementación específica en lugar de la interfaz. Esto reduce la flexibilidad.

**Fix:** Cambiar a `List<String> types`

---

### **Modificadores de Acceso Inconsistentes**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/domain/Pokemon.java](src/main/java/com/zaknein/PokedexApi/domain/Pokemon.java#L7-L14)

```java
int id;
String name;
String species;
// ... todos sin modificador de acceso
```

**Problema:** Todos los campos están con acceso a nivel de paquete (sin modificador) en lugar de `private`.

**Fix:** Agregar modificador `private` a todos los campos.

---

### **Mensajes de Error en Español en Código en Inglés**
✅ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L113)

```java
System.out.println("No existe archivo");
```

**Problema:** Mensajes en español mezclados con código en inglés. Falta de consistencia.

**Fix:** Usar mensajes en inglés.

---

### **Uso de System.out.println en Lugar de Logger**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L113-L114)

```java
System.out.println("No existe archivo");
e.printStackTrace();
```

**Problema:** Se usa `System.out.println()` y `printStackTrace()` en lugar de un logger apropiado.

**Fix:** Usar un loger como SLF4J con Logback (ya incluido en Spring Boot).

**Sugerencia:** Estudiar qué es un logger y qué son los logs.

---

### **Falta de Validación de Entrada**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java#L45)

```java
@PostMapping("/pokemon")
public Pokemon createPokemon(@RequestBody PokemonCreater pokemonCreater) {
```

**Problema:** No hay validación de entrada en los request bodies. No se usa `@Valid` ni anotaciones de validación.

**Fix:** Agregar `@Valid` y usar Bean Validation annotations (`@NotNull`, `@NotBlank`, `@Positive`, etc.)

---

### **Clase de Test Vacía**
❌ PENDIENTE

**Ubicación:** [src/test/java/com/zaknein/PokedexApi/PokedexApiApplicationTests.java](src/test/java/com/zaknein/PokedexApi/PokedexApiApplicationTests.java)

```java
@SpringBootTest
class PokedexApiApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

**Problema:** Solo existe un test de contexto, sin tests unitarios ni de integración reales.

**Fix:** Agregar tests para servicios, controladores, casos de borde, etc; o en su defecto borrar este test vacío.

---

### **Asignación Ineficiente de ID**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/CapturedPokeRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/CapturedPokeRepositoryImpl.java#L39-L40)

```java
int capturedId = userPokes.size();
capturedId++;
```

**Problema:** Código innecesariamente verboso.

**Fix:** Simplificar a `int capturedId = userPokes.size() + 1;`

---

### **Paths de Archivo Hardcodeados**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L25)

```java
private static final File pokeFile = new File("pokedex.json");
```

**Problema:** Los paths de archivos están hardcodeados en lugar de usar propiedades de configuración.

**Fix:** Usar `@Value` o `@ConfigurationProperties` con `application.properties`.

---

### **IOException en Constructor**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/service/PokemonService.java](src/main/java/com/zaknein/PokedexApi/service/PokemonService.java#L20)

```java
public PokemonService(...) throws IOException {
```

**Problema:** Los constructores de servicios declaran `throws IOException` en lugar de manejarlo apropiadamente.

**Fix:** Capturar y envolver en RuntimeException o usar `@PostConstruct`.

---

### **Anotación @Service en Clase de Repositorio**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L21)

```java
@Service
public class PokemonRepositoryImpl implements PokemonRepository {
```

**Problema:** Se usa `@Service` en una clase que actúa como repositorio. Debería usar `@Repository`.

**Fix:** Cambiar `@Service` por `@Repository` para semántica correcta.

---

### **Campo message Redundante en Excepciones**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/exceptions/NoPokeFoundException.java](src/main/java/com/zaknein/PokedexApi/exceptions/NoPokeFoundException.java#L5-L12)

```java
private String message;

public NoPokeFoundException(String msg){
    super(msg);
    this.message = msg;
}

public String getMessage() {
    return message;
}
```

**Problema:** `RuntimeException` ya tiene un campo `message` y método `getMessage()`. Duplicar esto es redundante.

**Fix:** Eliminar el campo `message` y el getter, usar solo `super(msg)`.

---

### **Lógica de Validación Duplicada**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/service/PokemonService.java](src/main/java/com/zaknein/PokedexApi/service/PokemonService.java#L32-L42)

```java
public List<Pokemon> getThemAll() {
    List<Pokemon> poke = pokemonRepository.getThemAll();
    if (poke.isEmpty() || poke == null) {
        throw new NoPokeFoundException("There is no pokemon to list");
    }
    return poke;
}
```

**Problema:** La validación de lista vacía se hace tanto en el servicio como en el repositorio.

**Fix:** Eliminar la validación del repositorio y mantenerla solo en el servicio.

---

### **Validación de Usuario Incorrecta**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/service/CapturedPokeService.java](src/main/java/com/zaknein/PokedexApi/service/CapturedPokeService.java#L45-L48)

```java
public List<CapturePokemon> getAllOfYourPoke(int userId) {
    List<CapturePokemon> allPokeList = capturedPokeRepository.getAllOfYourPoke(userId);
    if(allPokeList.isEmpty()){
        throw new NoUserFoundException("There is no user with the id " +userId+ " try again");
    }
```

**Problema:** Se lanza `NoUserFoundException` cuando la lista está vacía, pero una lista vacía no significa que el usuario no exista, solo que no ha capturado Pokemon.

**Fix:** No lanzar excepción, retornar lista vacía. O validar existencia de usuario por otro medio.

---

## Arreglos sugeridos o complejos


### **Configuración CORS Insegura**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java](src/main/java/com/zaknein/PokedexApi/controller/PokemonController.java#L18)

```java
@CrossOrigin
```

**Problema:** `@CrossOrigin` sin restricciones permite cualquier origen, lo cual es inseguro para producción.

**Fix:** Configurar CORS apropiadamente con orígenes específicos.

**Sugerencia:** Estudiar CORS.

---


### **Problemas de Concurrencia (Thread-Safety)**
❌ PENDIENTE

**Ubicación:** [src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java](src/main/java/com/zaknein/PokedexApi/repository/PokemonRepositoryImpl.java#L28)

```java
private Map<Integer,Pokemon> pokemonMap = new HashMap<>();
```

**Problema:** Los mapas en memoria no son thread-safe. Múltiples peticiones concurrentes podrían causar corrupción de datos.

**Fix:** Usar `ConcurrentHashMap` o agregar sincronización apropiada.

**Sugerencia:** Estudiar que son los problemas de concurrencia en Java y qué significa el término "thread-safe".

---


### **No se Usa Lombok a Pesar de Tenerlo en Dependencias**
❌ PENDIENTE

**Ubicación:** [pom.xml](pom.xml)

**Problema:** El proyecto incluye Lombok en `pom.xml` pero esta libreria no esta utilizada en el código.

**Fix:** Eliminar dependencia del `pom.xml` o usar anotaciones de Lombok como `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`.

---