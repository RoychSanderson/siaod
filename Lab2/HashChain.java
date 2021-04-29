//package com.company;

import java.util.ArrayList;

public class HashChain {
    public static int Search(int[] a, int key){
        class HashObj{//вспомогательный класс
            private final int pKey;
            private final int pValue;
            private final int Value;
            private final int Key;
            public HashObj(int currentpKey, int currentKey, int currentpValue, int currentValue){
                pKey = currentpKey;
                Key = currentKey;
                Value = currentValue;
                pValue = currentpValue;
            }
            public int getpKey(){
                return pKey;
            }
            public int getpValue(){
                return pValue;
            }
            public int getValue(){
                return Value;
            }
            public int getKey(){
                return Key;
            }
        }
        ArrayList<ArrayList<HashObj>> spisok = new ArrayList<ArrayList<HashObj>>();
        int h = (a.length / 10);
        int[] hasha = new int[a.length];
        for (int i = 0; i<a.length; i++){//создаем хешированный массив
            hasha[i] = a[i] / h;
        }
        int i = 0;
        while (i < hasha.length){//создаем цепочки
            int raz = a[i] / h;
            int pKey = 0;
            ArrayList<HashObj> chain = new ArrayList<HashObj>();
            while (raz == hasha[i]){
                HashObj obj = new HashObj(pKey,i,hasha[i],a[i]);
                chain.add(obj);
                i += 1;
                pKey += 1;
                if (i >= hasha.length){
                    break;
                }
            }
            spisok.add(chain);
        }
        int hKey = key / h;
        for (int j = 0; j<spisok.size(); j++){//собственное, сам поиск
            HashObj tmpObj = spisok.get(j).get(0);
            if (tmpObj.getpKey() == hKey){//ищем подходящую цепочку
                for (int u = 0; u < spisok.get(j).size(); u++){
                    if (spisok.get(j).get(u).getValue() == key){//если значение - то, то возвращаем его
                        return spisok.get(j).get(u).getKey();
                    }
                }
            }
        }
        return -1;
    }
    public static int[] Add(int[] a, int key){
        while (HashChain.Search(a, key) == -1){
            key += 1;
        }
        int index = HashChain.Search(a, key);
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
        int index = HashChain.Search(a, key);
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
