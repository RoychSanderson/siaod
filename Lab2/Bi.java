//package com.company;

public class Bi {
    public static int Search(int[] a, int key, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;//индекс среднего элемента
            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
    public static int[] Add(int[] a, int key){
        while (Bi.Search(a, key, 0, a.length) == -1){
           key += 1;
        }
        int index = Bi.Search(a, key, 0, a.length);
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
        int index = Bi.Search(a, key, 0, a.length);
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
