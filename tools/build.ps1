param([switch]$Clean)
$ErrorActionPreference = "Stop"
$RepoRoot = (Resolve-Path (Join-Path $PSScriptRoot "..")).Path
$Out = Join-Path $RepoRoot "build/classes/benchmark"
if ($Clean -and (Test-Path $Out)) { Remove-Item $Out -Recurse -Force }
New-Item -ItemType Directory -Force -Path $Out | Out-Null
$Sources = @(
  (Join-Path $RepoRoot "src/benchmark/java/OPF_Miner_Original.java"),
  (Join-Path $RepoRoot "src/benchmark/java/HJOPF.java")
)
& javac -encoding UTF-8 -d $Out $Sources
if ($LASTEXITCODE -ne 0) { throw "Compilation failed" }
Write-Host "Build complete: $Out"
