import java.util.Arrays;
import java.util.Random;

public class SortingExperiment {
    static long compCount = 0;

    public static void main(String[] args) {
        int[] sizes = {20, 50, 100, 500};
        Random rand = new Random(42); 

        System.out.printf("%-15s | %-10s | %-18s | %-18s%n", "Algorithm", "Input Size", "Number Comparisons", "Execution Time (ns)");
        System.out.println("-------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] original = rand.ints(size, 1, 10000).toArray();
            runBenchmarks(original, size);
        }

        System.out.println("\n--- Almost-Sorted 100-Element Array Test ---");
        int[] original100 = rand.ints(100, 1, 10000).toArray();
        Arrays.sort(original100);
        for (int i = 0; i < 10; i += 2) {
            int temp = original100[i];
            original100[i] = original100[i + 1];
            original100[i + 1] = temp;
        }
        runBenchmarks(original100, 100);
    }

    private static void runBenchmarks(int[] original, int size) {

        int[] arr1 = original.clone();
        compCount = 0;
        long start = System.nanoTime();
        selectionSort(arr1);
        long time = System.nanoTime() - start;
        System.out.printf("%-15s | %-10d | %-18d | %-18d%n", "Selection Sort", size, compCount, time);


        int[] arr2 = original.clone();
        compCount = 0;
        start = System.nanoTime();
        insertionSort(arr2);
        time = System.nanoTime() - start;
        System.out.printf("%-15s | %-10d | %-18d | %-18d%n", "Insertion Sort", size, compCount, time);


        int[] arr3 = original.clone();
        compCount = 0;
        start = System.nanoTime();
        mergeSort(arr3, 0, arr3.length - 1);
        time = System.nanoTime() - start;
        System.out.printf("%-15s | %-10d | %-18d | %-18d%n", "Merge Sort", size, compCount, time);


        int[] arr4 = original.clone();
        compCount = 0;
        start = System.nanoTime();
        quickSort(arr4, 0, arr4.length - 1);
        time = System.nanoTime() - start;
        System.out.printf("%-15s | %-10d | %-18d | %-18d%n", "Quick Sort", size, compCount, time);
    }


    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                compCount++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int t = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = t;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                compCount++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] L = Arrays.copyOfRange(arr, l, m + 1);
        int[] R = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length) {
            compCount++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            compCount++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}
