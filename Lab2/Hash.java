//package com.company;

import java.util.Arrays;

public class Hash {
    public static int Search(int[] a, int key){
        int nkey = (key * key) / 10;
        int[] hasha = new int[((a.length*a.length)/10)+1];
        Arrays.fill(hasha, -1);
        int i;
        for (i = 0; i<a.length; i++){
            int hash = (a[i] * a[i]) / 10;
            while (hash < hasha.length){
                if (hasha[hash] != -1){
                    hash = (hash + 1) % 1000;
                } else {
                    hasha[hash] = a[i];
                    break;
                }
            }
        }
        if (hasha[nkey] == -1){
            return -1;
        }
        while (nkey < hasha.length){
            if (hasha[nkey] == key){
                return nkey;
            } else {
                nkey += 1;
            }
        }
        return -1;
    }
    public static int[] Add(int[] a, int key){
        while (Hash.Search(a, key) == -1){
            key += 1;
        }
        int index = Hash.Search(a, key);
        int[] newa = new int[a.length+1];
        for (int i = 0; i<index; i++){
            newa[i] = a[i];
        }
        newa[index] = key;
        for (int i = index+1; i<newa.length; i++){
            newa[i] = a[i-1];
        }
        return newa;
    }
    public static int[] Remove(int[] a, int key){
        int index = Hash.Search(a, key);
        int[] newa = new int[a.length-1];
        for (int i = 0; i<index; i++){
            newa[i] = a[i];
        }
        for (int i = index; i<a.length-1; i++){
            newa[i] = a[i+1];
        }
        return newa;
    }
}
