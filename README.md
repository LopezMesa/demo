# Demo API

Servicio Spring Boot de ejemplo estructurado con Clean Architecture y Ports & Adapters. Es un proyecto Gradle multi-módulo: las dependencias de compilación protegen al dominio de HTTP, Spring y la infraestructura.

## Arquitectura

```text
                ┌───────────────┐
                │   REST API    │
                │ Entry Point   │
                └───────┬───────┘
                        ↓
                ┌───────────────┐
                │   Use Cases   │
                └───────┬───────┘
                        ↓
                ┌───────────────┐
                │    Domain     │
                └───────┬───────┘
                        ↑
              ┌─────────┴─────────┐
              │ Future driven adapters │
              │ PostgreSQL / RabbitMQ  │
              └────────────────────────┘
```

## Módulos y restricciones

```text
application ──────────> entrypoints-rest ──> usecase ──> model
      │                         │                 │
      └─────────────────────────┴─────────────────┘
            Composition root / Spring Boot

drivenadapters-* ────────────────────────────────────> model
```

- `model`: reglas y tipos de negocio. Su `build.gradle` no declara dependencias de producción, por lo que no puede importar Spring, HTTP o infraestructura.
- `usecase`: orquesta la aplicación y depende únicamente de `model`. Puede probarse instanciándolo directamente y no contiene anotaciones Spring.
- `entrypoints-rest`: contratos HTTP, Jakarta Validation, controllers y manejo seguro de errores. Puede depender de los casos de uso y el modelo, nunca al revés.
- `application`: único módulo Spring Boot. Es el *composition root*: registra los casos de uso como beans y reúne los módulos ejecutables.
- `drivenadapters-*`: no se creó aún porque no hay integración externa. Cuando exista una, dependerá de `model` para implementar un puerto ubicado en `model.gateway`; `model` no dependerá del adapter.

La dirección de dependencias queda impuesta por Gradle: intentar importar una clase de `entrypoints-rest` desde `model` o `usecase` falla durante compilación porque esos módulos no están en su classpath.

## Requisitos

- Java 21
- Spring Boot 4.0.7
- Gradle Wrapper incluido

## Ejecutar

En Windows:

```powershell
.\gradlew.bat :application:bootRun
```

Crear un saludo:

```powershell
Invoke-RestMethod -Method Post -Uri http://localhost:8080/api/v1/greetings `
  -ContentType 'application/json' -Body '{"name":"Andrea"}'
```

## Pruebas

```powershell
.\gradlew.bat clean test
```

Las pruebas cubren el caso de uso sin levantar Spring y el contrato REST con `MockMvc`.

## Decisiones arquitectónicas

- No se añadieron JPA, PostgreSQL, RabbitMQ o AWS porque no existe aún un requisito funcional que los use.
- El caso de uso se registra en `application` y no con `@Service`; así `usecase` no depende de Spring.
- No se creó un puerto sin consumidor; al incorporar una dependencia externa, el puerto se ubicará en `model.gateway` y su implementación en un módulo `drivenadapters-*`.
- La validación de entrada es responsabilidad REST; la normalización y regla de no-vacío se preservan en el valor de dominio.
