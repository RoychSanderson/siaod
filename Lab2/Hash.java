//package com.company;

public class Hash {
    public static int Search(int[] a, int key){
        int nkey = (a.length / 3);
        nkey = key / nkey;
        int[] hasha = new int[a.length];
        for (int i = 0; i<a.length; i++){
            hasha[i] = a[i] / (a.length/3);//хэшируем массив
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
