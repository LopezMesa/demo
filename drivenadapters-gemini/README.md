# Gemini driven adapter

This module is an outbound adapter for Gemini, not a persistence repository. It implements the framework-independent `TextGenerationGateway` port declared in `model`.

Its dependency direction is:

```text
drivenadapters-gemini -> model
application -> drivenadapters-gemini, usecase
usecase -> model
```

Configure the adapter with the `GEMINI_API_KEY` environment variable. No API key is stored in the project.
