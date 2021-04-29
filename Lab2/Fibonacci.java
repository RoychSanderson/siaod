//package com.company;

public class Fibonacci {

    public static int Search(int[] a, int key){
        int index;
        int tmp,z2,z1;
        z1 = 0; z2 = 1;
        while(z2<a.length+1){
            tmp = z1;
            z1 = z2;
            z2 = tmp+z1;
        }
        int m = z2 - (a.length+1);
        index = z1 - m;
        int p = z2-z1;//выяснение начальных индексов
        int q = z1-p;
        int k1 = a[index];
        while (k1 != key){
            if (index < 0){
                if (p == 1){
                    System.out.println("Поиск неудачен");
                    index = -1;
                    break;
                } else {
                    index = index + q;
                    p = p - q;
                    q = q - p;
                }
            }
            if (index > a.length){
                if (q == 0){
                    System.out.println("Поиск неудачен");
                    index = -1;
                    break;
                } else {
                    index -= q;
                    tmp = p;
                    p = q;
                    q = tmp - q;
                }
            }
            k1 = a[index];
            if (k1 == key){
                break;
            }
            if (k1 < key){
                if (p == 1){
                    System.out.println("Поиск неудачен");
                    index = -1;
                    break;
                } else {
                    index = index + q;
                    p = p - q;
                    q = q - p;
                }
            }
            if (k1 > key){
                if (q == 0){
                    System.out.println("Поиск неудачен");
                    index = -1;
                    break;
                } else {
                    index -= q;
                    tmp = p;
                    p = q;
                    q = tmp - q;
                }
            }
        }
        return index;
    }
    public static int[] Add(int[] a, int key){
        while (Fibonacci.Search(a, key) == -1){
            key += 1;
        }
        int index = Fibonacci.Search(a, key);
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
        int index = Fibonacci.Search(a, key);
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
