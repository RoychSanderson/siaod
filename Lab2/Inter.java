//package com.company;

public class Inter {
    public static int Search(int[] a, int key) {
        int sIndex = 0;
        int lIndex = (a.length - 1);
        while ((sIndex < lIndex) && (key >= a[sIndex]) && (key <= a[lIndex])) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = sIndex + (((lIndex - sIndex) / (a[lIndex]- a[sIndex])) * (key - a[sIndex]));
            if (a[pos] == key)
                return pos;
            if (a[pos] < key)
                sIndex = pos + 1;
            else
                lIndex = pos - 1;
        }
        return -1;
    }
    public static int[] Add(int[] a, int key){
        while (Inter.Search(a, key) == -1){
            key += 1;
        }
        int index = Inter.Search(a, key);
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
        int index = Inter.Search(a, key);
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
