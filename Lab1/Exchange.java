

public class Exchange {
    public static void Exchanging(int[] array){
        int flag = 1;
        if (flag == 1){
            flag = 0;
            for (int i = 0; i<array.length-1; i++){
                if (array[i] > array[i+1]){
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    flag = 1;
                }
            }
        }
    }
}
