import java.util.Arrays;
import java.util.Random;
public class SortingExperiment {
    private static final int[] INPUT_SIZES = { 20, 50, 100, 500 };
    private static final String[] ALGORITHMS =
            { "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort" };
    private static final long SEED = 2026L;

    private static int[] generateArray(int size, Random rng) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rng.nextInt(999) + 1;
        }
        return a;
    }

    private static Metrics runOne(String algorithm, int[] original) {
        int[] data = Arrays.copyOf(original, original.length);
        Metrics m = new Metrics();

        long start, end;
        switch (algorithm) {
            case "Selection Sort":
                start = System.nanoTime();
                Sorters.selectionSort(data, m, false);
                end = System.nanoTime();
                break;
            case "Insertion Sort":
                start = System.nanoTime();
                Sorters.insertionSort(data, m, false);
                end = System.nanoTime();
                break;
            case "Merge Sort":
                start = System.nanoTime();
                Sorters.mergeSort(data, m, false);
                end = System.nanoTime();
                break;
            case "Quick Sort":
                start = System.nanoTime();
                Sorters.quickSort(data, m, false);
                end = System.nanoTime();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
        m.timeNanos = end - start;
        return m;
    }

    public static void main(String[] args) {
        Random rng = new Random(SEED);
        int[] hundredElementArray = null;

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-16s | %-10s | %-22s | %s%n",
                "Algorithm", "Input Size", "Number of Comparisons", "Execution Time (ns)");
        System.out.println("----------------------------------------------------------------");

        for (int size : INPUT_SIZES) {
            int[] original = generateArray(size, rng);
            if (size == 100) {
                hundredElementArray = Arrays.copyOf(original, original.length);
            }

            for (String alg : ALGORITHMS) {
                Metrics m = runOne(alg, original);
                System.out.printf("%-16s | %-10d | %-22d | %,d%n",
                        alg, size, m.comparisons, m.timeNanos);
            }
            System.out.println("----------------------------------------------------------------");
        }

        runAlmostSortedTest(hundredElementArray);
    }

    private static void runAlmostSortedTest(int[] hundredElementArray) {
        if (hundredElementArray == null) {
            System.out.println("100-element array was not generated.");
            return;
        }

        System.out.println("\n================================================================");
        System.out.println("  ADDITIONAL TEST - ALMOST-SORTED ARRAY (100 elements)");
        System.out.println("================================================================");

        int[] almostSorted = Arrays.copyOf(hundredElementArray, hundredElementArray.length);
        Sorters.mergeSort(almostSorted, new Metrics(), false);

        int[] positions = {10, 25, 40, 60, 80};
        System.out.print("  Swapped neighbouring pairs at indexes: ");
        for (int p : positions) {
            int temp = almostSorted[p];
            almostSorted[p] = almostSorted[p + 1];
            almostSorted[p + 1] = temp;
            System.out.print("(" + p + "," + (p + 1) + ") ");
        }
        System.out.println("\n  The array is now 'almost sorted' - only 5 small local disorders.\n");

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-16s | %-10s | %-22s | %s%n",
                "Algorithm", "Input Size", "Number of Comparisons", "Execution Time (ns)");
        System.out.println("----------------------------------------------------------------");

        for (String alg : ALGORITHMS) {
            Metrics m = runOne(alg, almostSorted);
            System.out.printf("%-16s | %-10s | %-22d | %,d%n",
                    alg, "100 (a-s)", m.comparisons, m.timeNanos);
        }
        System.out.println("----------------------------------------------------------------");
    }
}

