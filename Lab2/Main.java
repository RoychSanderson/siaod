//package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int RAZMER = 100;
        int[] array = new int[RAZMER];
        Tree tree = new Tree();
        for (int i = 0; i<RAZMER; i++){
              array[i] = (int) (Math.random() * 101);
              tree.Insert(array[i]);
        }
        Arrays.sort(array);
        long m = System.currentTimeMillis();
        System.out.print(Bi.Search(array, 7, 0, array.length) + " index - ");
        long mex = System.currentTimeMillis();
        System.out.println("Binary search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        Node node = tree.Search(7);
        if (node != null){
            node.printNode();
        } else {
            System.out.println("Выбранный узел имеет значение : -1 ");
        }
        mex = System.currentTimeMillis();
        System.out.println("Binary tree search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.print(Fibonacci.Search(array, 7) + " index - ");
        mex = System.currentTimeMillis();
        System.out.println("Fibonacci search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.print(Inter.Search(array, 7) + " index - ");
        mex = System.currentTimeMillis();
        System.out.println("Interpolation search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.print(Hash.Search(array, 7) + " index - ");
        mex = System.currentTimeMillis();
        System.out.println("Hashcode search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.print(HashChain.Search(array, 7) + " index - ");
        mex = System.currentTimeMillis();
        System.out.println("HashChain search time "+ (mex - m) +"ms");
        m = System.currentTimeMillis();
        System.out.print(HashPR.Search(array, 7) + " index - ");
        mex = System.currentTimeMillis();
        System.out.println("HashPseudoRandom search time "+ (mex - m) +"ms");
        Chess.Place();

    }
}
