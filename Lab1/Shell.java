
public class Shell {
    public static void ShellSort(int[] array){
        int max = array.length - 1;
        int v,raz;
        int step = array.length / 2;
        while (step > 0){
            for (int i = step; i<max; i++){
                v = i;
                raz = v - step;
                while (raz >=  0 && array[raz] > array[v]){
                    int tmp = array[raz];
                    array[raz] = array[v];
                    array[v] = tmp;
                    v = raz;
                    raz = v - step;
                }
            }
            step /= 2;
        }
    }
}
