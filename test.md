





## Preguntas: 


### AWS:

Notas:

- **EC2:** Virtual server where `you manage the server` operating system and application.
- **Lambda:** Serverless compute service that runs code in response to events. `AWS manages the infrastructure`


1. AWS Storage:
   - S3 →  Object Storage  
     Para:
       ```
       archivos
       imágenes
       backups
       documentos
       logs
       objetos
       ```
     
   - EBS →  Elastic Block Store
     Para:
       ```
       Se utiliza principalmente para albergar el sistema operativo de servidores
      virtuales, bases de datos transaccionales, entornos de pruebas/producción y
      aplicaciones empresariales que requieren almacenamiento persistente con baja latencia.
       ```  
   - EFS →  Elastic Block Store
     Para:
       ```
       AWS EFS (Elastic File System) es el servicio de almacenamiento de
      archivos administrado y sin servidor (serverless) que utiliza el protocolo 
     estándar NFSv4 (Network File System).
       ```  


2.  AWS Databases
    ``` 
    RDS  -> Base de datos relacional administrada.
    
    DynamoDB -> NoSQL Key-Value Document
    
    Aurora  ->  es un motor de base de datos relacional (compatible con MySQL y PostgreSQL) diseñado para la nube por AWS, que ofrece 
                el rendimiento y la disponibilidad de las bases de datos empresariales comerciales a una décima parte de su costo.
    ```

3. 📨 AWS Messaging: 

    ```
    SQS
     Producer
        ↓
       SQS
        ↓
     Consumer
   
    SNS
       Publisher
           ↓
          SNS
         ↙ ↓ ↘
        S1 S2 S3
   
    EventBridge
    
    SQS → Queue
    SNS → Publish/Subscribe
    ```   

4. 

### SQL: 

1. Which JOIN returns all rows from the left table and matching rows from the right table?  
**R:** RLEFT JOIN  
Ejemplo: SELECT columna, FUNCION_AGREGADA(columna) FROM tabla  WHERE condicion_filas GROUP BY columna HAVING condicion_grupos;


2. Which SQL clause is used to filter rows before grouping?  
   R: `WHERE`  
   Ejemplo:  `SELECT * FROM employees WHERE salary > 5000`


3. Which keyword is used to eliminate duplicate rows from a query result?  
   R: `DISTINCT`   
   Ejemplo: `SELECT DISTINCT country FROM customers`


4. Which JOIN returns all rows from the left table and matching rows from the right table?
   R: `LEFT JOIN`  
   Ejemplo:
   
   ```
   SELECT c.name, o.id
   FROM customers c
   LEFT JOIN orders o
   ON c.id = o.customer_id;
   ```
5. Which SQL clause is used to filter groups after GROUP BY?  
   R: `HAVING`  
   Ejemplo:
   ```
   SELECT department, COUNT(*)
   FROM employees
   GROUP BY department
   HAVING COUNT(*) > 10;
   ```
   
 ### 6. Treminologia SQL: 
   
 
   - **SELECT**: Selecciona datos de una base de datos.
   - **FROM**: Especifica la tabla o tablas de las que se obtienen los datos.
   - **WHERE**: Filtra registros basándose en una condición específica.
   - **GROUP BY**: Agrupa filas que tienen los mismos valores en resúmenes (se usa con agregación).
   - **HAVING**: Filtra grupos después de aplicar `GROUP BY` (similar a `WHERE` pero para agregados).
                                                                                                       

   - **ORDER BY**: Ordena el conjunto de resultados en orden  ascendente (`ASC`) o descendente (`DESC`).  
     Ejm: "SELECT name FROM EMPLOYEE WHERE salary > 7000 ORDER BY salary DESC;"
                                                                                     

   - **JOIN**: Combina filas de dos o más tablas basándose en una columna relacionada.
   - **INNER JOIN**: Devuelve registros que tienen valores coincidentes en ambas tablas.
   - **LEFT JOIN**: Devuelve todos los registros de la tabla izquierda y los coincidentes de la derecha.
   - **RIGHT JOIN**: Devuelve todos los registros de la tabla derecha y los coincidentes de la izquierda.
   - **FULL JOIN**: Devuelve todos los registros cuando hay una coincidencia en cualquiera de las tablas.
   - **UNION**: Combina el resultado de dos o más consultas `SELECT` (elimina duplicados).
   - **DISTINCT**: Selecciona solo valores diferentes (únicos).
   - **INSERT INTO**: Inserta nuevos registros en una tabla.
   - **UPDATE**: Modifica registros existentes en una tabla.
   - **DELETE**: Elimina registros de una tabla.
   - **CREATE**: Crea una nueva tabla, vista o base de datos.
   - **ALTER**: Modifica la estructura de una tabla existente (añadir, eliminar o modificar columnas).
   - **DROP**: Elimina una tabla, vista o base de datos por completo.
   - **TRUNCATE**: Elimina todos los registros de una tabla (reinicia la estructura sin eliminar la tabla).
   - **PRIMARY KEY**: Restricción que identifica de manera única cada registro en una tabla (único y no nulo).
   - **FOREIGN KEY**: Restricción que vincula columnas entre tablas para mantener la integridad referencial.
   - **INDEX**: Crea un índice para acelerar las búsquedas en una tabla.
   - **VALUES**: Se usa junto con `INSERT INTO` para especificar los datos a insertar.
   - **SET**: Se usa junto con `UPDATE` para especificar qué columnas modificar y sus nuevos valores.
   - **AS**: Se usa para asignar un alias (nombre temporal) a una columna o tabla.
   - **BETWEEN**: Filtra resultados dentro de un rango (incluye los extremos).
   - **LIKE**: Busca un patrón específico en una columna (usando comodines `%` y `_`).
   - **IN**: Comprueba si un valor coincide con cualquier valor dentro de una lista especificada.
   - **EXISTS**: Comprueba si existe al menos un registro en una subconsulta.
   - **CASE**: Crea lógica condicional dentro de una consulta (similar a un `if-else`).
   - **NULL**: Representa un valor desconocido o ausente (se usa con `IS NULL` o `IS NOT NULL`).
   - **AND / OR / NOT**: Operadores lógicos para combinar o negar condiciones en `WHERE` o `HAVING`.
  
   
7. Ejemplos:  
   - Obtener la lista de departamentos sin repetir  
     `SELECT DISTINCT departamento FROM empleados;`
   

   - Empleados con salario mayor a 3000  
     `SELECT * FROM empleados WHERE salario > 3000;`

   
   - Calcular el salario promedio por departamento  
   `SELECT departamento, AVG(salario) AS salario_promedio FROM empleados GROUP BY departamento;`


   - Departamentos con salario promedio superior a 3000  
     `SELECT departamento, AVG(salario) AS salario_promedio FROM empleados GROUP BY departamento HAVING AVG(salario) > 3000;`

   
   - Ordenar empleados del salario más alto al más bajo  
     `SELECT nombre, salario FROM empleados ORDER BY salario DESC;`


   - Obtener los 3 empleados con mayor salario  
     `SELECT nombre, salario FROM empleados ORDER BY salario DESC LIMIT 3;`


   - Obtener empleados y el nombre de su proyecto (asumiendo tabla 'proyectos')
     `SELECT e.nombre, p.nombre_proyecto FROM empleados e INNER JOIN proyectos p ON e.id = p.empleado_id;`



    
   - Combinar nombres de empleados activos y ex-empleados  
     `SELECT nombre FROM empleados UNION SELECT nombre FROM ex_empleados;`

8. ### Estructura y Orden de Ejecución Estándar
   El orden en el que se escriben las cláusulas en SQL es:
    ```
    SELECT
    FROM
    JOIN
    WHERE
    GROUP BY
    HAVING
    ORDER BY
    LIMIT
    ```

### **Algorithms:**

1. What is the time complexity of the following algorithm?   
   ```
   for (int i = 0; i < n; i++){ 
   System.out.println(i); 
   }
   ``` 
   R:  `O(n) El loop se ejecuta: n veces`


2. What is the time complexity of the following algorithm?  
   
    ```
    for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
        System.out.println(i + j);
         }
    } 
   ``` 
    R: `O(n²)`  n × n = n²

### REST URI

1. Which HTTP method should normally be used to retrieve "recuperar" a resource?  
   R: `GET`


2. Which HTTP status code indicates that a resource was successfully created?  
   R: `201`

   
3. Which HTTP method is generally considered idempotent?  
   R: `GET`

   
4. Mejres practicas REST  URI
   
   ```
   - Usa sustantivos en lugar de verbos para representar recursos (ej. `/users` en lugar de `/getUsers`).
   - Usa plural para los nombres de los recursos (ej. `/users/{id}`).
   - Usa guiones medios (`-`) para separar palabras en la ruta (kebab-case) (ej. `/user-profiles`).
   - Usa solo minúsculas en las URI.
   - Anida recursos para expresar relaciones jerárquicas (ej. `/users/{userId}/orders`).
   - Evita extensiones de archivo (como `.json`, `.xml`); usa la cabecera `Accept` para la negociación de contenido.
   - Usa parámetros de consulta (query params) para filtrar, ordenar o paginar (ej. `/users?page=2&limit=10`).
   - Evita incluir nombres de acciones o verbos CRUD en la ruta (ej. no uses `/createUser` o `/deleteUser`).
   - Mantén las URI cortas, legibles y auto-descriptivas.
   - Utiliza nombres de recursos específicos y estandarizados, evitando abreviaturas confusas.
   - Mantén una profundidad de anidación limitada (idealmente 2 o 3 niveles como máximo).
   ```

5. Mejores practicas REST FULL
   
   ```
   - Utiliza los métodos HTTP correctamente (
     GET para consultar,
     POST para crear, 
     PUT para reemplazar, 
     PATCH para actualizar parcialmente,
     DELETE para eliminar).
   
   - Usa códigos de estado HTTP de forma semántica (
     200 OK, 
     201 Created, 
     204 No Content,
     400 Bad Request,
     401 Unauthorized, 
     403 Forbidden,  
     404 Not Found,
     409 Conflict, 
     500 Internal Server Error, etc.
     502 Bad Gateway
     503 Service Unavailable
     504 Gateway Timeout  
   ).
   
   - Mantén la API sin estado (stateless), cada petición debe contener toda la información necesaria (ej. autenticación en cada request).
   - Versiona la API (ej. `/api/v1/usuarios` o mediante cabeceras como `Accept-Version`).
   - Implementa HATEOAS (hipermedia como motor del estado de la aplicación) cuando sea posible, incluyendo enlaces a acciones relacionadas en las respuestas.
   - Usa JSON como formato por defecto y negocia el contenido mediante la cabecera `Accept`.
   - Estandariza el formato de los errores en las respuestas (ej. un objeto con `timestamp`, `status`, `error`, `message` y `path`).
   - Asegura la idempotencia en los métodos seguros (GET, PUT y DELETE deben poder repetirse sin efectos secundarios adicionales).
   - Utiliza cabeceras de caché (Cache-Control, ETag, Last-Modified) para mejorar el rendimiento.
   - Documenta la API de forma exhaustiva (ej. usando OpenAPI / Swagger).
   ```


### JAVA:

1. Which collection does not allow duplicate elements?  
   R: `HashSet`  
   Ejemplo: ``Set<String> names = new HashSet<>();``


2. Which method must be overridden when overriding equals() in a Java class?  
   R: `hashCode()`  
   Ejemplo: 

    equals() → hashCode()  
   **Esto es especialmente importante con:** 

   ```
   HashMap
   HashSet
   HashTable
   ```

3. ¿Cuáles son las afirmaciones verdaderas sobre un record de Java?
   
    ```
    - Un `record` es una clase final (no se puede heredar de ella).
    - Todos sus campos son `private` y `final` (inmutabilidad).
    - Proporciona automáticamente un constructor canónico.
    - Genera automáticamente los métodos `equals()`, `hashCode()` y `toString()`.
    - Proporciona métodos de acceso para cada campo con el mismo nombre del componente (ej. `nombre()`).
    - Puede declararse como clase de nivel superior, clase miembro (anidada) o clase local.
    - Puede tener un constructor compacto.
    - Puede implementar interfaces.
    - Su clase base es `java.lang.Record`.
    - Está diseñado como un transportador transparente de datos.
   ```
   
4.  Estructuras de datos:
    
     ## Arrays (Arreglos)
     - Tamaño **fijo e inmutable** al momento de la creación (no se puede redimensionar dinámicamente).
     - Memoria **contigua**, lo que permite acceso aleatorio en **O(1)**.
     - Inserción y eliminación en posición intermedia son **O(n)** debido al desplazamiento de elementos.
     - Son **covariantes** en Java (ej. `String[]` es subtipo de `Object[]`), lo que permite `ArrayStoreException` en tiempo de ejecución si se asigna un tipo incorrecto.
     - Los arrays multidimensionales son en realidad **arrays de arrays** (jagged arrays), no matrices rectangulares obligatorias.
     - Usar la clase utilitaria `java.util.Arrays` para operaciones comunes: `sort()`, `toString()`, `copyOf()`, `asList()`.
     - No sobrescriben `toString()` por defecto; se debe usar `Arrays.toString()` o `Arrays.deepToString()` para imprimir.
     
     ## HashMap
     - **No es thread-safe** (para entornos concurrentes usar `ConcurrentHashMap` o `Collections.synchronizedMap()`).
     - Permite **una clave `null`** y **múltiples valores `null`**.
     - El **orden de iteración no está garantizado** (si se necesita orden de inserción, usar `LinkedHashMap`; si se necesita orden natural de claves, usar `TreeMap`).
     - Depende críticamente de la correcta implementación de los métodos `hashCode()` y `equals()` en los objetos usados como clave. Si se sobrescribe uno, se debe sobrescribir el otro.
     - Factor de carga por defecto: **0.75** (equilibrio entre memoria y rendimiento). La capacidad inicial debe ajustarse si se esperan muchos elementos para evitar rehashing costoso.
     - En Java 8+, si muchas claves tienen el mismo hash (colisiones), la estructura de la cubeta se convierte de lista enlazada a **árbol rojo-negro** (cuando umbral >= 8) para mantener el rendimiento en **O(log n)** en el peor caso.
     
     ## Stack (Pila)
     - Es una clase **legacy** (heredada de `Vector`), por lo que sus métodos están **sincronizados** (`synchronized`), añadiendo overhead innecesario en entornos no concurrentes.
     - Sigue el principio **LIFO** (Último en entrar, primero en salir).
     - Métodos principales: `push()`, `pop()`, `peek()`, `empty()`, `search()` (devuelve posición 1-based desde el tope).
     - **Recomendación moderna**: Usar `Deque` con `ArrayDeque` en su lugar (`Deque<Integer> stack = new ArrayDeque<>();`), ya que es más rápido y no está sincronizado.
     
     ## Queue (Cola)
     - Es una **interfaz**, no una clase. Implementaciones comunes: `LinkedList`, `PriorityQueue`, `ArrayDeque`.
     - Generalmente sigue el principio **FIFO** (Primero en entrar, primero en salir), excepto `PriorityQueue` que ordena por prioridad natural o `Comparator`.
     - Ofrece **dos familias de métodos**:
       - *Lanzan excepción*: `add()`, `remove()`, `element()`.
       - *Retornan valor especial* (`null` o `false`): `offer()`, `poll()`, `peek()`.
       - **Buena práctica**: Usar la segunda familia (`offer/poll/peek`) para evitar excepciones en flujos normales.
     - `PriorityQueue` **no permite** elementos `null`.
     - El iterador de `PriorityQueue` **no garantiza** el orden de prioridad; solo `poll()` extrae en orden.
     
     ## Deque (Double Ended Queue - Cola de doble extremo)
     - Es una **interfaz** que permite inserción y eliminación por ambos extremos.
     - Implementaciones principales: `ArrayDeque` (recomendada, basada en array dinámico) y `LinkedList`.
     - **Sustituye a `Stack`** para LIFO y a `Queue` para FIFO de forma más eficiente.
     - Tiene métodos simétricos para ambos extremos:
       - Extremo inicial: `addFirst()` / `offerFirst()`, `removeFirst()` / `pollFirst()`, `getFirst()` / `peekFirst()`.
       - Extremo final: `addLast()` / `offerLast()`, `removeLast()` / `pollLast()`, `getLast()` / `peekLast()`.
     - `ArrayDeque` **no permite elementos `null`** y no es thread-safe.
     - `ArrayDeque` crece automáticamente; es más rápido que `LinkedList` para apilamientos y colas, y consume menos memoria por elemento.
     
     ## Big O (Notación O)
     - Describe la **complejidad asintótica** en el peor caso (aunque suele mencionarse el caso promedio o amortizado).
     - Se **ignoran constantes y términos de menor orden** (ej. O(2n) = O(n)).
     - En Java, tener en cuenta las diferencias de implementación:
       - `ArrayList`: acceso O(1), inserción/eliminación final O(1) amortizado, intermedia O(n).
       - `LinkedList`: acceso O(n), inserción/eliminación en cabecera O(1).
       - `HashMap`: caso promedio O(1); peor caso O(log n) desde Java 8 (por árboles) u O(n) antes.
       - `TreeMap`: operaciones O(log n) asegurado.
     - Muy importante para elegir la estructura adecuada según la operación más frecuente.
     
     ## Sorting (Ordenamiento)
     - Para **objetos** (`Arrays.sort()` y `Collections.sort()`), Java usa **TimSort** (híbrido de Merge Sort e Insertion Sort). Es un algoritmo **estable** y garantiza O(n log n) en todos los casos, aunque consume O(n) espacio extra.
     - Para **tipos primitivos** (`int[]`, `double[]`, etc.), Java usa **Dual-Pivot Quicksort**. Es **inestable** (no preserva el orden de elementos iguales) pero tiene O(n log n) en promedio.
     - Los métodos de ordenamiento trabajan **in-place** (modifican el arreglo o colección original).
     - Para objetos, se puede usar el orden natural mediante `Comparable` o definir un orden personalizado con `Comparator`.
     - `Arrays.parallelSort()` aprovecha múltiples hilos para mejorar el rendimiento en grandes volúmenes de datos.
     
     ## Searching (Búsqueda)
     - **Búsqueda binaria**: Usar `Arrays.binarySearch()` para arreglos y `Collections.binarySearch()` para listas.
       - **Requisito obligatorio**: La estructura debe estar **previamente ordenada**. Si no lo está, el resultado es indefinido.
       - Si el elemento se encuentra, devuelve el índice. Si **no se encuentra**, devuelve `(-(punto_de_inserción) - 1)` (donde punto_de_inserción es el índice donde iría para mantener el orden).
     - **Búsqueda lineal**: Se implementa manualmente con un bucle `for`. No requiere orden previo pero tiene complejidad **O(n)**.
     - Para `HashMap` o `HashSet`, la búsqueda (por clave) es **O(1)** promedio, evitando la búsqueda secuencial.
     - Al usar `binarySearch` con un `Comparator`, asegurarse de usar el mismo `Comparator` que se usó para ordenar la lista.
                                             
    
  ## 5. Variado: 

## Collections (Framework de Colecciones)
- Interfaces raíz: `Collection` (para `List`, `Set`, `Queue`) y `Map` (no extiende `Collection`).
- **List**: Ordenada, permite duplicados, acceso por índice. Implementaciones: `ArrayList` (acceso O(1), inserción/eliminación intermedia O(n)), `LinkedList` (acceso O(n), inserción/eliminación en extremos O(1)).
- **Set**: No permite duplicados. `HashSet` (sin orden, O(1)), `LinkedHashSet` (orden de inserción), `TreeSet` (orden natural o por `Comparator`, O(log n)). Depende críticamente de `equals`/`hashCode` (para `HashSet`) o de `Comparable`/`Comparator` (para `TreeSet`).
- **Map**: Almacena pares clave-valor. `HashMap` (O(1) promedio), `LinkedHashMap` (orden de inserción), `TreeMap` (orden natural, O(log n)). Las claves en `HashMap` requieren correcta implementación de `equals`/`hashCode`.
- **Iteración**: Usar `Iterator` o bucle `for-each`. Si se modifica la colección durante la iteración (salvo usando `Iterator.remove()`), se lanza `ConcurrentModificationException`.
- **Sincronización**: La mayoría de las implementaciones **no son thread-safe**. Usar `Collections.synchronizedXXX()`, `ConcurrentHashMap`, `CopyOnWriteArrayList` o `BlockingQueue` para entornos concurrentes.
- **Permitir `null`**: `ArrayList` y `HashMap` permiten `null`; `TreeMap`/`TreeSet` no permiten claves `null` (aunque sí valores); `HashSet` permite un solo `null`.
- **Elección de implementación**: Elegir según la operación más frecuente (acceso aleatorio vs inserciones/eliminaciones frecuentes vs necesidad de orden).

## equals / hashCode
- **Contrato fundamental**: Si dos objetos son iguales según `equals()`, deben tener el mismo `hashCode()`. El inverso no es obligatorio (colisiones permitidas).
- **Sobrescritura obligatoria**: Siempre sobrescribir ambos métodos si se van a usar objetos como claves en `HashMap`/`HashSet` o en cualquier estructura basada en hash.
- **Propiedades de `equals`**: Debe ser **reflexivo** (x.equals(x) true), **simétrico** (x.equals(y) ↔ y.equals(x)), **transitivo**, **consistente** (si no cambian campos, siempre devuelve lo mismo) y **no-null** (x.equals(null) debe ser false).
- **Propiedades de `hashCode`**: Debe ser **consistente** (mismo valor si el objeto no cambia). Si dos objetos son iguales, el `hashCode` debe ser igual.
- **Implementación segura**: Usar `Objects.equals()` y `Objects.hash()` para simplificar y evitar errores comunes.
- **Peligro con mutabilidad**: Si los campos usados en `equals`/`hashCode` cambian después de insertar el objeto en un `HashSet` o usarlo como clave en `HashMap`, el objeto se "pierde" (no se encuentra ni se elimina correctamente). **Usar objetos inmutables como claves**.
- **Generación automática**: IDEs y `record` generan implementaciones correctas automáticamente.

## OOP (Programación Orientada a Objetos)
- **Principios fundamentales**: Encapsulamiento (ocultar estado interno), Herencia (reutilización con `extends`), Polimorfismo (sobrecarga y sobrescritura), Abstracción (clases abstractas e interfaces).
- **Modificadores de acceso**: `private` (solo clase), `default` (package-private, sin modificador), `protected` (paquete + subclases), `public` (todos).
- **Herencia múltiple**: No permitida en clases (solo herencia simple). En interfaces sí es permitida (Java 8+ con métodos `default` y `static`).
- **Composición vs Herencia**: Preferir **composición** sobre herencia para evitar problemas de fragilidad y acoplamiento (diseño más flexible).
- **Modificador `final`**: En clase impide herencia; en método impide sobrescritura; en variable la hace constante.
- **Principio de Sustitución de Liskov (LSP)**: Los subtipos deben poder sustituir a sus tipos base sin alterar el comportamiento esperado del programa.
- **Generics**: Aportan polimorfismo paramétrico y seguridad en tipos (evitan casts y errores en tiempo de ejecución).
- **Interfaces funcionales**: Interfaces con un solo método abstracto (ej. `Runnable`, `Comparator`, `Consumer`) — base para lambdas y Streams.

## Streams (API de Streams)
- Introducidos en **Java 8** para procesamiento funcional de secuencias de datos (no modifican la fuente original).
- **Operaciones Intermedias**: Son **lazy** (no se ejecutan hasta que se invoca una operación terminal). Ej: `filter`, `map`, `flatMap`, `sorted`, `distinct`, `limit`, `skip`.
- **Operaciones Terminales**: Son **eager** (ejecutan la pipeline). Ej: `forEach`, `collect`, `reduce`, `count`, `anyMatch/allMatch/noneMatch`, `findFirst/findAny`.
- **Inmutabilidad de la fuente**: Las operaciones no modifican la colección original; devuelven un nuevo resultado o un nuevo `Stream`.
- **Un solo uso**: Un `Stream` no se puede reutilizar después de aplicar una operación terminal; intentarlo lanza `IllegalStateException`.
- **Streams en paralelo**: Usar `parallelStream()` para ejecución paralela. **Precaución**: No es adecuado para todas las situaciones (overhead, concurrencia, orden no garantizado). Se debe asegurar que las operaciones sean sin estado y no interfieran.
- **Recogedores (`Collectors`)**: Herramientas para convertir el resultado en colecciones: `toList()`, `toSet()`, `toMap()`, `groupingBy()`, `partitioningBy()`, `joining()`.
- **Streams primitivos**: `IntStream`, `LongStream`, `DoubleStream` evitan autoboxing y son más eficientes.
- **Uso de `Optional`**: Muchas operaciones terminales devuelven `Optional` para evitar `NullPointerException`.

## Records
- Introducidos en **Java 14** (preview) y finalizados en **Java 16**. Son clases finales e inmutables diseñadas para transportar datos de forma transparente.
- **Componentes declarados** en la cabecera se convierten en campos `private final`.
- Generan automáticamente: **constructor canónico**, **`equals()`**, **`hashCode()`** y **`toString()`**.
- **Métodos de acceso**: Se generan con el **mismo nombre del componente** (sin prefijo `get`), ej. `nombre()`.
- **Constructor compacto**: Permite validación o normalización de parámetros sin repetir la lista de componentes.
- **No puede extender otras clases** (hereda implícitamente de `java.lang.Record`).
- Puede **implementar interfaces**.
- Puede declarar **métodos estáticos, de instancia y campos estáticos**, pero **no campos de instancia adicionales** (todos los campos de instancia se declaran en la cabecera).
- Es **implícitamente `final`**, por lo que no se puede heredar de un `record`.
- No permiten `abstract`. Son ideales para DTOs, Value Objects y claves en mapas (por su inmutabilidad).

## Exceptions (Manejo de Excepciones)
- **Jerarquía**: `Throwable` → `Exception` (checked) y `RuntimeException` (unchecked) → `Error` (problemas graves fuera del control de la aplicación).
- **Checked Exceptions**: Deben ser capturadas (`try-catch`) o declaradas en el método con `throws`. Ej: `IOException`, `SQLException`. Obligan al programador a manejar el error.
- **Unchecked Exceptions (`RuntimeException`)**: No es obligatorio capturarlas ni declararlas. Ej: `NullPointerException`, `IllegalArgumentException`, `IndexOutOfBoundsException`. Representan errores de programación.
- **Buenas prácticas**:
    - Capturar excepciones **específicas**, no `Exception` genérica.
    - Usar **`try-with-resources`** para recursos que implementan `AutoCloseable` (cierre automático).
    - Lanzar excepciones con **mensajes descriptivos** y útiles.
    - Crear **excepciones personalizadas** cuando aporten valor semántico al dominio.
- **No usar excepciones para el control de flujo normal**: Son costosas en rendimiento (creación de stack trace).
- **`finally`**: Útil para limpieza (cerrar recursos), aunque `try-with-resources` es preferible.
- **Encadenamiento**: Usar constructores con `Throwable cause` para preservar la causa original. También `addSuppressed` para excepciones suprimidas.
- **Logging**: Registrar excepciones en el nivel apropiado (`ERROR`, `WARN`) en las capas adecuadas, evitando registrar la misma excepción múltiples veces.


## CODIGO:

```
public static void fizzBuzz(int n) {
    for (int i = 1; i <= n; i++) {

        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (i % 3 == 0) {
            System.out.println("Fizz");
        } else if (i % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }
}
```

