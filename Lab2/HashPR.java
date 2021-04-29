//package com.company;

public class HashPR {
    public static int Search(int[] a, int key){
        int ra, rb, rc;
        ra = 2;
        rb = (int) (Math.random() * 11);
        rc = (int) (Math.random() * 11);
        int nkey = ((key / ra)+rb)*rc;
        int[] hasha = new int[a.length];
        for (int i = 0; i<a.length; i++){
            hasha[i] = a[i] / ra;
            hasha[i] += rb;
            hasha[i] *= rc;//хэшируем массив
        }
        for (int i = 0; i<a.length; i++){
            if (hasha[i] == nkey){//ищем по хэшированному ключу
                if (a[i] == key){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int[] Add(int[] a, int key){
        while (HashPR.Search(a, key) == -1){
            key += 1;
        }
        int index = HashPR.Search(a, key);
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
        int index = HashPR.Search(a, key);
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
