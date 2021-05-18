//package com.company;

public class BouerMurHorspul {
    public static int Search(String str, String sub, int f){
        if (f == 1){
            str = str.toLowerCase();
            sub = sub.toLowerCase();
        }
        char[] needle = sub.toCharArray();
        char[] hay = str.toCharArray();
        int[] d = new int[sub.length()];
        int i,j;

        int last = needle.length-1;
        i = needle.length-2;
        int tmpi;
        while (i >= 0){
            tmpi = sub.lastIndexOf(needle[i], last-1);
            if (tmpi == i){
                d[i] = last - i;
            } else {
                d[i] = d[tmpi];
            }
            i--;
        }
        tmpi = sub.lastIndexOf(needle[last], last-1);
        if (sub.indexOf(needle[last]) == last){
            d[last] = needle.length;
        } else {
            d[last] = d[tmpi];
        }
        //for (int y = 0; y<d.length; y++){
        //    System.out.print(d[y] + " ");
        //}
        i = d.length-1; j = needle.length-1;
        while (i < hay.length){
            if (hay[i] == needle[j]){
                if (j == 0){
                    return i;
                }
                i--; j--;
            } else {
                int ti = sub.lastIndexOf(hay[i]);
                j = needle.length-1;
                if (ti == -1){
                    i += needle.length;
                } else {
                    i += d[ti];
                }
            }
        }
        return -1;
    }
}
