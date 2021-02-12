

public class QuickSort {
    public static void quickSort(int[] array, int min, int max) {
        if (array.length == 0)
            return;
        if (min >= max)
            return;
        int middle = min + (max - min) / 2;
        int opora = array[middle];
        int i = min, j = max;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (min < j)
            quickSort(array, min, j);
        if (max > i)
            quickSort(array, i, max);
    }
}
