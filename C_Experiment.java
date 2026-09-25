import java.util.Random;

public class C_Experiment {

    private static final int[] SIZES = {20, 50, 100, 500};
    private static final Random rand = new Random(42);

    public static void runFullExperiment() {
        System.out.println("\n################################################################");
        System.out.println("#           PART C - SORTING ALGORITHM EXPERIMENT            #");
        System.out.println("################################################################\n");

        System.out.printf("%-16s %-10s %-18s %-18s%n", "Algorithm", "Input Size", "Comparisons", "Time (ns)");
        System.out.println("--------------------------------------------------------------------");

        for (int size : SIZES) {
            int[] original = generateRandomArray(size);

            runOne(original, "Selection Sort", size, arr -> B_SortingAlgorithms.selectionSort(arr));
            runOne(original, "Insertion Sort", size, arr -> B_SortingAlgorithms.insertionSort(arr));
            runOne(original, "Merge Sort", size, arr -> B_SortingAlgorithms.mergeSort(arr));
            runOne(original, "Quick Sort", size, arr -> B_SortingAlgorithms.quickSort(arr));

            System.out.println("--------------------------------------------------------------------");
        }

        // Almost-sorted test
        System.out.println("\n===== ALMOST-SORTED ARRAY TEST (size 100) =====");
        int[] almostSorted = generateAlmostSortedArray(100);

        System.out.printf("%-16s %-18s %-18s%n", "Algorithm", "Comparisons", "Time (ns)");
        System.out.println("------------------------------------------------------");

        runOne(almostSorted, "Selection Sort", 100, arr -> B_SortingAlgorithms.selectionSort(arr));
        runOne(almostSorted, "Insertion Sort", 100, arr -> B_SortingAlgorithms.insertionSort(arr));
        runOne(almostSorted, "Merge Sort", 100, arr -> B_SortingAlgorithms.mergeSort(arr));
        runOne(almostSorted, "Quick Sort", 100, arr -> B_SortingAlgorithms.quickSort(arr));

        printAnalysis();
    }

    private static void runOne(int[] original, String name, int size, Sorter sorter) {
        int[] copy = B_SortingAlgorithms.copyArray(original);
        B_SortingAlgorithms.resetCounters();

        long start = System.nanoTime();
        sorter.sort(copy);
        long end = System.nanoTime();

        System.out.printf("%-16s %-10d %-18d %-18d%n",
                name, size, B_SortingAlgorithms.comparisons, (end - start));
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    private static int[] generateAlmostSortedArray(int size) {
        int[] arr = generateRandomArray(size);
        B_SortingAlgorithms.resetCounters();
        B_SortingAlgorithms.mergeSort(arr);

        for (int k = 0; k < 5; k++) {
            int i = rand.nextInt(size - 1);
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;
    }

    private static void printAnalysis() {
        System.out.println("""
        
        ===== ANALYSIS QUESTIONS =====
        
        1. Fewest comparisons? → Merge Sort and Quick Sort
        2. Most comparisons? → Selection Sort
        3. Best on almost-sorted? → Insertion Sort
        4. Scales best? → Merge Sort / Quick Sort
        5. Results agree with theory? → Yes
        6. Is time alone enough? → No
        """);
    }

    @FunctionalInterface
    private interface Sorter {
        void sort(int[] arr);
    }
}