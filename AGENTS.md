# AGENTS.md

## Project

Backend service implemented with:

- Java 21
- Spring Boot 4.0.7
- Gradle

## Mandatory Development Principles

All code MUST follow:

- Clean Code
- Clean Architecture
- SOLID
- Separation of Concerns
- High Cohesion
- Low Coupling
- Dependency Inversion
- Testability

## Java

Use Java 21 features when they provide a clear benefit:

- Records
- Sealed Classes
- Pattern Matching
- Record Patterns
- Switch Expressions
- Virtual Threads when appropriate

Do NOT use APIs or language features newer than Java 21.

## Spring Boot

The project MUST remain compatible with Spring Boot 4.0.7.

Use:

- Constructor injection
- `@RestController`
- `@Service`
- `@Repository`
- `@RestControllerAdvice`
- Jakarta Validation
- `@ConfigurationProperties`

Prefer modern Spring Boot 4 / Spring Framework 7 APIs.

## Architecture

Follow Clean Architecture.

Dependency direction:

Infrastructure → Application → Domain

The Domain MUST NOT depend on:

- Spring
- JPA/Hibernate
- REST
- AWS
- RabbitMQ
- Infrastructure implementations

Business logic must remain independent from frameworks and infrastructure.

## SOLID

Apply SOLID principles whenever they provide real value.

Do NOT introduce abstractions, interfaces, factories, or design patterns without a concrete reason.

Prefer simple solutions over unnecessary architectural complexity.

## Testing

Every business rule MUST be testable.

Prefer:

- Unit tests for business logic
- Integration tests for infrastructure
- API tests for REST contracts

Use the Given / When / Then structure.

## Error Handling

Use centralized exception handling with:

@RestControllerAdvice
@ExceptionHandler

Never expose:

- Stack traces
- Database errors
- SQL statements
- Credentials
- Internal infrastructure details

## Security

NEVER hardcode:

- Passwords
- API keys
- Tokens
- AWS credentials
- Database credentials

Never commit secrets to Git.

## Code Changes

Before modifying code:

1. Understand the existing architecture.
2. Inspect existing conventions.
3. Reuse existing abstractions when appropriate.
4. Avoid unnecessary refactoring.
5. Preserve existing behavior unless explicitly requested.
6. Run relevant tests after changes.

## Implementation Rule

When implementing a feature:

1. Understand the requirement.
2. Inspect the existing code.
3. Propose the design when necessary.
4. Implement the simplest clean solution.
5. Add or update tests.
6. Run tests.
7. Report any remaining issues.

## Quality Gate

Before considering a task complete, verify:

- Code compiles.
- Tests pass.
- Architecture is respected.
- SOLID principles are respected.
- No unnecessary dependencies were introduced.
- No secrets were added.
- Java 21 compatibility is maintained.
- Spring Boot 4.0.7 compatibility is maintained.

## Golden Rule

Do not optimize for the shortest implementation.

Optimize for:

1. Correctness
2. Security
3. Maintainability
4. Testability
5. Reliability
6. Simplicity
7. Performance