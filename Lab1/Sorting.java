

import java.util.Arrays;

public class Sorting {
    public static int[][] quicksort(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            QuickSort.quickSort(xstr, 0, x.length-1);
            System.arraycopy(xstr, 0, x[str], 0, xstr.length);
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
    public static int[][] inner(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            Arrays.sort(xstr);
            System.arraycopy(xstr, 0, x[str], 0, xstr.length);
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
    public static int[][] shell(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            Shell.ShellSort(xstr);
            System.arraycopy(xstr, 0, x[str], 0, xstr.length);
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
    public static int[][] select(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            Selection.Select(xstr);
            System.arraycopy(xstr, 0, x[str], 0, xstr.length);
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
    public static int[][] insert(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            Insertion.Insert(xstr);
            System.arraycopy(xstr, 0, x[str], 0, xstr.length);
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
    public static int[][] exchange(int[][] x){
        if (x.length == 0){
            System.out.println("Matrix is missed");
            return null;
        }
        int[] xstr = new int[x[0].length];
        long m = System.currentTimeMillis();
        for (int str = 0; str<x.length; str++) {
            System.arraycopy(x[str], 0, xstr, 0, x[str].length);
            Exchange.Exchanging(xstr);
            for (int i = 0; i< xstr.length; i++){
                x[str][i] = xstr[i];
            }
        }
        long mex = System.currentTimeMillis();
        System.out.println((mex - m)+"ms");
        return x;
    }
}
