import java.util.Random;

public class SortingAlgorithms {
    public static class SortMetrics {
        public long comparisons = 0;
        public long executionTimeNs = 0;
    }

    public static SortMetrics selectionSort(int[] arr) {
        SortMetrics metrics = new SortMetrics();
        long startTime = System.nanoTime();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                metrics.comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        metrics.executionTimeNs = System.nanoTime() - startTime;
        return metrics;
    }

    public static SortMetrics insertionSort(int[] arr) {
        SortMetrics metrics = new SortMetrics();
        long startTime = System.nanoTime();
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                metrics.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }

        metrics.executionTimeNs = System.nanoTime() - startTime;
        return metrics;
    }

    public static SortMetrics mergeSort(int[] arr) {
        SortMetrics metrics = new SortMetrics();
        long startTime = System.nanoTime();
        mergeSortRecursive(arr, 0, arr.length - 1, metrics);
        metrics.executionTimeNs = System.nanoTime() - startTime;
        return metrics;
    }

    private static void mergeSortRecursive(int[] arr, int left, int right, SortMetrics metrics) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRecursive(arr, left, mid, metrics);
            mergeSortRecursive(arr, mid + 1, right, metrics);
            merge(arr, left, mid, right, metrics);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, SortMetrics metrics) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            metrics.comparisons++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static SortMetrics quickSort(int[] arr) {
        SortMetrics metrics = new SortMetrics();
        long startTime = System.nanoTime();
        quickSortRecursive(arr, 0, arr.length - 1, metrics);
        metrics.executionTimeNs = System.nanoTime() - startTime;
        return metrics;
    }

    private static void quickSortRecursive(int[] arr, int low, int high, SortMetrics metrics) {
        if (low < high) {
            int pi = partition(arr, low, high, metrics);
            quickSortRecursive(arr, low, pi - 1, metrics);
            quickSortRecursive(arr, pi + 1, high, metrics);
        }
    }

    private static int partition(int[] arr, int low, int high, SortMetrics metrics) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            metrics.comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void runExperiment() {
        int[] sizes = {20, 50, 100, 500};
        Random rand = new Random(42);

        System.out.println("\n==========================================================================");
        System.out.println("                       PART C: ALGORITHM EXPERIMENT                       ");
        System.out.println("==========================================================================");
        System.out.printf("%-16s | %-10s | %-18s | %-20s\n", "Algorithm", "Input Size", "Comparisons", "Execution Time (ns)");
        System.out.println("--------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) original[i] = rand.nextInt(1000);

            SortMetrics m1 = selectionSort(original.clone());
            System.out.printf("%-16s | %-10d | %-18d | %-20d\n", "Selection Sort", size, m1.comparisons, m1.executionTimeNs);

            SortMetrics m2 = insertionSort(original.clone());
            System.out.printf("%-16s | %-10d | %-18d | %-20d\n", "Insertion Sort", size, m2.comparisons, m2.executionTimeNs);

            SortMetrics m3 = mergeSort(original.clone());
            System.out.printf("%-16s | %-10d | %-18d | %-20d\n", "Merge Sort", size, m3.comparisons, m3.executionTimeNs);

            SortMetrics m4 = quickSort(original.clone());
            System.out.printf("%-16s | %-10d | %-18d | %-20d\n", "Quick Sort", size, m4.comparisons, m4.executionTimeNs);
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
