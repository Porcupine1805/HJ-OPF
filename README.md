# HJ-OPF

**Output-Sensitive Hash-Indexed Join for Order-Preserving Pattern Mining with Forgetting Mechanism**

Reference implementation and experimental artifact for the paper:

> Nguyen, K.-C., Bui, N.-M., Tran, C.-P.  
> *HJ-OPF: Output-Sensitive Hash-Indexed Join for Order-Preserving Pattern Mining with Forgetting Mechanism*

HJ-OPF replaces the quadratic group scan of OPF-Miner with an output-sensitive hash-indexed join on the same normalized prefix and suffix keys. Compatible pairs are emitted in expected Θ(L + J) time; the original fusion and forgetting-aware support are then applied unchanged. Semantic equivalence follows from the completeness of GP-Fusion together with soundness and completeness of the join.

Residual operators (cheap pre-fusion bounds, galloping intersection, adaptive enablement) are provided only for controlled ablation. Relative to pure HJ-OPF they change the matrix mean by only a few percent and are **not** a primary claim.

---

## Requirements

- JDK 11 or later

---

## Build

```bash
# Linux / macOS
bash tools/build.sh

# Windows (PowerShell)
powershell -NoProfile -ExecutionPolicy Bypass -File tools/build.ps1
```

Or manually:

```bash
mkdir -p build/classes/benchmark
javac -encoding UTF-8 -d build/classes/benchmark \
  src/benchmark/java/OPF_Miner_Original.java \
  src/benchmark/java/HJOPF.java
```

---

## Run

### OPF-Miner baseline

```bash
java -Xmx2g \
  -Dinput=data/benchmark \
  -DfileRegex='DB4\\.txt' \
  -DminsupList=2,4 \
  -Doutput=results/out_opf.csv \
  -cp build/classes/benchmark OPF_Miner_Original
```

### HJ-OPF (primary claim)

```bash
java -Xmx2g \
  -Dinput=data/benchmark \
  -DfileRegex='DB4\\.txt' \
  -DminsupList=2,4 \
  -Dmode=hash_only \
  -DbitmapPolicy=never \
  -DwsbPolicy=never \
  -Doutput=results/out_hj.csv \
  -cp build/classes/benchmark HJOPF
```

Default mode is already `hash_only`. The flags above make the configuration explicit.

### Residual ablation (not a primary claim)

```bash
java -Xmx2g \
  -Dinput=data/benchmark \
  -DfileRegex='DB4\\.txt' \
  -DminsupList=2,4 \
  -Dmode=adaptive \
  -DbitmapPolicy=never \
  -DwsbPolicy=cost \
  -Doutput=results/out_residual.csv \
  -cp build/classes/benchmark HJOPF
```

---

## Repository layout

```text
src/benchmark/java/
  OPF_Miner_Original.java   # baseline OPF-Miner
  HJOPF.java                # HJ-OPF implementation
data/benchmark/             # DB1 … DB8 (financial suite)
data/electricity_scale/     # ELEC_01 / ELEC_05 / ELEC_10 used in the paper
data/manifests/             # provenance and checksums
tools/                      # build scripts
docs/                       # reproducibility notes
```

---

## Correctness

Add `-Dcanonical=results/canonical_run` and compare pattern-support dumps across baseline and HJ-OPF. Outputs must be identical.

---

## Citation

See `CITATION.cff`.

## License

See `LICENSE`.
