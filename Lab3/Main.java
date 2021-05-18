//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Строка");
        String string = in.nextLine();//AbcabeabcabcaDdabcabEabcabcabyUidabcabeabcabcabd
        System.out.println("Подстрока");
        String sub = in.nextLine();//yui или AbcabeabcabcaDdabcabEabcabcabyUidabcabeabcabcabd
        System.out.println("Учитывать ли регистр? (Да - 0, Нет - 1)");
        int reg = in.nextInt();
        long m = System.currentTimeMillis();
        int index = string.lastIndexOf(sub);
        long mex = System.currentTimeMillis();
        System.out.println("Встроенный - Индекс начала подстроки - " + index + ", найдено за " + (mex - m) + " мс");
        m = System.currentTimeMillis();
        index = KnutMorrisPratt.Search(string, sub, reg);
        mex = System.currentTimeMillis();
        System.out.println("КМП - Индекс начала подстроки - " + index + ", найдено за " + (mex - m) + " мс");
        m = System.currentTimeMillis();
        index = BouerMurHorspul.Search(string, sub, reg);
        mex = System.currentTimeMillis();
        System.out.println("БМХ - Индекс начала подстроки - " + index + ", найдено за " + (mex - m) + " мс");
        //
        //Пятнашки
        //
        System.out.println("Пятнашки");
        int[][] start = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,15,14,0}
        };
        Board initial = new Board(start);
        Solver solver = new Solver(initial);
        for (Board board : solver.solution())
            System.out.print(board.getLasting() + " ");
    }
}
