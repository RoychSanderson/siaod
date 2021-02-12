

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int RAZMER = 1000;
        int[][] x = new int[RAZMER][RAZMER];
        int [][] y;
        for (int i = 0; i<RAZMER; i++){
            for (int j = 0; j<RAZMER; j++){
                x[i][j] = (int) (Math.random()*101);
            }
        }
        System.out.println("Time for inner sort");
        y = Sorting.inner(x);
        System.out.println("Time for quicksort");
        y = Sorting.quicksort(x);
        //System.out.println(Arrays.deepToString(y));
        System.out.println("Time for Shell sort");
        y = Sorting.shell(x);
        System.out.println("Time for select sort");
        y = Sorting.select(x);
        System.out.println("Time for insertion sort");
        y = Sorting.insert(x);
        System.out.println("Time for exchanging sort");
        y = Sorting.exchange(x);

    }

}

