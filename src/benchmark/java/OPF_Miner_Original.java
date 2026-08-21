import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Original OPF-Miner (algorithm preserved).
 * Adds timing metrics and CSV output for fair comparison with HJ-OPF.
 */
public final class OPF_Miner_Original {

    private static final String INPUT_DIR = System.getProperty("input", "data/benchmark");
    private static final String OUTPUT_SUMMARY_FILE = System.getProperty("output", "results/OPF_summary.csv");
    private static final String LOG_FILE = System.getProperty("log", "results/OPF.log");
    private static final String CANONICAL_DIR = System.getProperty("canonical", "");
    private static final double[] MIN_SUP_ARRAY = {2.0, 4.0, 6.0, 8.0, 10.0, 12.0};
    private static final String FILE_REGEX = System.getProperty("fileRegex", ".*\\.txt");

    public static final class MetricsTracker {
        public static long startTimeNano = 0, endTimeNano = 0;
        public static double maxMemoryMB = 0.0;
        public static long candidatePatternsCount = 0, patternFusionsCount = 0;
        public static long supportCalculationsCount = 0, frequentPatternsCount = 0;
        public static long pairChecksCount = 0;

        public static void reset() {
            candidatePatternsCount = patternFusionsCount = supportCalculationsCount = frequentPatternsCount = 0;
            pairChecksCount = 0;
            maxMemoryMB = 0.0;
            endTimeNano = 0;
            startTimeNano = System.nanoTime();
        }

        public static void stopTimer() { endTimeNano = System.nanoTime(); }

        public static void checkMemory() {
            double used = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576.0;
            if (used > maxMemoryMB) maxMemoryMB = used;
        }

        public static double getExecutionTimeSeconds() {
            return (endTimeNano - startTimeNano) / 1_000_000_000.0;
        }
    }

    // NOTE: Full original implementation is large. This is a stub marker.
    // The complete file is in the release zip; will be replaced with full content.
    public static void main(String[] args) throws IOException {
        System.err.println("Please use the full OPF_Miner_Original.java from the clean source package.");
        System.exit(1);
    }
}
