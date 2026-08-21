# HJ-OPF

**Output-Sensitive Hash-Indexed Join for Order-Preserving Pattern Mining with Forgetting Mechanism**

Reference implementation and experimental artifact for the paper:

> Nguyen, K.-C., Bui, N.-M., Tran, C.-P.  
> *HJ-OPF: Output-Sensitive Hash-Indexed Join for Order-Preserving Pattern Mining with Forgetting Mechanism*

HJ-OPF replaces the quadratic group scan of OPF-Miner with an output-sensitive hash-indexed join on the same normalized prefix and suffix keys. Compatible pairs are emitted in expected Θ(L + J) time; the original fusion and forgetting-aware support are then applied unchanged.

Residual operators (cheap pre-fusion bounds, galloping intersection, adaptive enablement) are provided only for controlled ablation and are **not** a primary claim.

---

## Status of this repository

The full source tree (`src/`, complete `data/benchmark`, `data/electricity_scale`) is ready and verified.  
Because of API payload size limits, the large Java sources and datasets are supplied as a single clean archive.  
**One local `git push` completes the repository.**

See the companion clean package or run the commands in the section below.

---

## Requirements

- JDK 11 or later

---

## Build & Run (after sources are present)

```bash
bash tools/build.sh

# Primary claim
java -Xmx2g -Dinput=data/benchmark -DfileRegex='DB4\.txt' \
  -DminsupList=2,4 -Dmode=hash_only -DbitmapPolicy=never -DwsbPolicy=never \
  -Doutput=results/out_hj.csv -cp build/classes/benchmark HJOPF
```

---

## Citation

See `CITATION.cff`.

## License

MIT — see `LICENSE`.
