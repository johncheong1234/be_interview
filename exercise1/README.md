```markdown
# Java 21 Exercises

This repository contains solutions for three Java 21 exercises focusing on:
1. Advanced Stream Operations & var
2. Records & Pattern Matching
3. Concurrency & CompletableFuture

## Compilation and Run Commands

### For all exercises:

1. **Compile all programs**:
```bash
javac --enable-preview --release 21 ProductStreamDemo.java && \
javac --enable-preview --release 21 PaymentProcessor.java && \
javac --enable-preview --release 21 UserDataFetcher.java
```

2. **Run programs individually**:

- **Stream Operations**:
```bash
java --enable-preview ProductStreamDemo
```

- **Records & Pattern Matching**:
```bash
java --enable-preview PaymentProcessor
```

- **CompletableFuture**:
```bash
java --enable-preview UserDataFetcher
```

3. **Run all programs sequentially**:
```bash
java --enable-preview ProductStreamDemo && \
java --enable-preview PaymentProcessor && \
java --enable-preview UserDataFetcher
```

## Notes:
- The `--enable-preview` flag is required for Java 21 preview features
- `--release 21` ensures compatibility with Java 21 features
- For the CompletableFuture example, run multiple times to see different outcomes due to random failure simulation
```