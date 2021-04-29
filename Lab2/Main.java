//package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int RAZMER = 1000;
        int[] array = new int[RAZMER];
        Tree tree = new Tree();
        for (int i = 0; i<RAZMER; i++){
              array[i] = (int) (Math.random() * 101);
              tree.Insert(array[i]);
        }
        Arrays.sort(array);
        long m = System.currentTimeMillis();
        System.out.println(Bi.Search(array, 7, 0, array.length) + " index");
        long mex = System.currentTimeMillis();
        System.out.println("Binary search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        Node node = tree.Search(7);
        System.out.println(node.toString());
        mex = System.currentTimeMillis();
        System.out.println("Binary tree search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.println(Fibonacci.Search(array, 7) + " index");
        mex = System.currentTimeMillis();
        System.out.println("Fibonacci search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.println(Inter.Search(array, 7) + " index");
        mex = System.currentTimeMillis();
        System.out.println("Interpolation search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.println(Hash.Search(array, 7) + " index");
        mex = System.currentTimeMillis();
        System.out.println("Hashcode search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.println(HashChain.Search(array, 7) + " index");
        mex = System.currentTimeMillis();
        System.out.println("HashChain search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.println(HashPR.Search(array, 7) + " index");
        mex = System.currentTimeMillis();
        System.out.println("HashPseudoRandom search time "+ (mex - m) +"ms");
       // Board pusk = new Board();
        //pusk.Place('D',1);
        Chess.Place();

    }
}
