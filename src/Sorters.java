public class Sorters {
    public static void selectionSort(int[] array, Metrics metrics, boolean showSteps) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                metrics.comparisons++;

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    public static void insertionSort(int[] array, Metrics metrics, boolean showSteps) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0) {
                metrics.comparisons++;

                if (array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;
        }
    }
    public static void mergeSort(int[] array, Metrics metrics, boolean showSteps) {
        if (array.length <= 1) {
            return;
        }

        mergeSort(array, 0, array.length - 1, metrics);
    }

    private static void mergeSort(
            int[] array,
            int left,
            int right,
            Metrics metrics) {

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(array, left, middle, metrics);
        mergeSort(array, middle + 1, right, metrics);

        merge(array, left, middle, right, metrics);
    }

    private static void merge(
            int[] array,
            int left,
            int middle,
            int right,
            Metrics metrics) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            metrics.comparisons++;

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void quickSort(int[] array, Metrics metrics, boolean showSteps) {
        if (array.length <= 1) {
            return;
        }

        quickSort(array, 0, array.length - 1, metrics);
    }

    private static void quickSort(
            int[] array,
            int low,
            int high,
            Metrics metrics) {

        if (low < high) {
            int pivotIndex = partition(array, low, high, metrics);

            quickSort(array, low, pivotIndex - 1, metrics);
            quickSort(array, pivotIndex + 1, high, metrics);
        }
    }

    private static int partition(
            int[] array,
            int low,
            int high,
            Metrics metrics) {

        // Last element is used as pivot
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            metrics.comparisons++;

            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }
}