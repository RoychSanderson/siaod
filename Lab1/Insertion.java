

public class Insertion {
    public static void Insert(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]){
                int j = i;
                while (j >= 0 && array[j] <= array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j -= 1;
                }
            }
        }
    }
}
