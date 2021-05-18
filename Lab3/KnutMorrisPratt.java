//package com.company;

public class KnutMorrisPratt {
    public static int Search(String str, String sub, int f){
        if (f == 1){
            str = str.toLowerCase();
            sub = sub.toLowerCase();
        }
        char[] needle = sub.toCharArray();
        char[] hay = str.toCharArray();
        int[] pi = new int[sub.length()];
        int j,i;
        i = 1; j = 0; pi[0] = 0;
        while (i < needle.length){
            if (needle[j] != needle[i]){
                if (j == 0){
                    pi[i] = 0;
                    i++;
                } else {
                    j = pi[j-1];
                }
            } else {
                pi[i] = j+1;
                i++; j++;
            }
        }
        i = 0; j = 0;
        while (i < hay.length){
            if (hay[i] == needle[j]){
                i++; j++;
                if (j == pi.length){
                    return (i-j);
                }
            } else {
                if (j == 0){
                    i++;
                    if (i == hay.length){
                        return -1;
                    }
                } else {
                    j = pi[j-1];
                }
            }
        }
        return -1;
    }
}
