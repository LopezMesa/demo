# Repository module

This module contains outbound persistence adapters. It may depend on `model` to implement domain ports, but the domain and use-case modules must never depend on it.

Add database-specific dependencies and adapter implementations here when a persistence requirement and its corresponding domain port exist.

## Structure

```text
src/main/java/com/example/demo/repository/
├── adapter/out/persistence/  # Implementations of domain persistence ports
├── entity/                   # Persistence entities
├── mapper/                   # Domain-to-persistence mappings
└── persistence/               # Technology-specific repository interfaces

src/test/java/com/example/demo/repository/
└── adapter/out/persistence/  # Persistence adapter integration tests
```
