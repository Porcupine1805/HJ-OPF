# Reproducibility

1. Build with `bash tools/build.sh` (or `tools/build.ps1`).
2. Use identical JVM flags and heap for all configurations.
3. Discard JIT warmup runs; report median of measured runs.
4. For correctness, enable `-Dcanonical=<dir>` and verify that pattern-support dumps of OPF-Miner and HJ-OPF are identical.

Primary configuration used in the paper:

```
-Dmode=hash_only -DbitmapPolicy=never -DwsbPolicy=never
```
