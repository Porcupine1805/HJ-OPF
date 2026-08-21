# Results

Timing CSVs from local runs are written here and are gitignored.

Canonical `(pattern, support)` dumps used in the paper:

| Path | What |
|------|------|
| `canonical/DB4_minsup_2/` | Five variants, byte-identical, 4836 patterns |
| `canonical/DB5_minsup_2/` | OPF-Miner vs HJ-OPF, byte-identical, 68695 patterns |

To regenerate a dump:

```text
java -Dcanonical=results/canonical_run ... -cp build/classes/benchmark OPF_Miner_Original
java -Dcanonical=results/canonical_run -Dmode=hash_only ... -cp build/classes/benchmark HJOPF
```
