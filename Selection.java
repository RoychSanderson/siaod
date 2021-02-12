

public class Selection {
    public static void Select(int[] array){
        for (int min = 0; min < array.length; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[least] > array[j]) {
                    least = j;
                }
            }
            int tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
        }
    }
}
