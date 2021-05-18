//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //27.02
        Sobranie();
        Rules();
        Cap();
        //Problems
        Perimetr(new int[] {3,2,3,6});
        Max(new int[] {3,30,34,5,9});
        int[][] start = {
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}
        };
        Sort(start, start[0].length, start.length);

        //Strings
        Victory("abc","qrt");
        Polindrom("cbbdpobbbbbr");
        Contaction("abcabcabc");

    }
    public static void Sobranie(){
        Scanner in = new Scanner(System.in);
        //First Task
        int n = in.nextInt();//количество событий
        String[] queue = new String[1000];//очередь партий, которые вынесли на голосование закон
        int j = 0;
        String active = null;
        boolean flag = true;
        for (int i = 0; i < n+1;i++){
            String[] tmp = in.nextLine().split(" ");//считываем и обрабатываем событие
            if (tmp[0].length() == 3){// если add, то двигаем очередь
                if (active != null){
                    queue[j] = active;
                    j++;
                }
                active = tmp[1];
            }
            if (tmp[0].length() == 4){//если vote, то проверяем активный проект
                if (active.equals(tmp[1])){
                    if (j > 0){
                        j--;
                    }
                    active = queue[j];
                    queue[j] = null;
                } else {
                    flag = false;
                }
            }
        }
        System.out.println("");
        if ((active != null) || (n % 2 != 0) || (queue[0] != null))
            flag = false;
        if (flag){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void Rules(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 3; i <= n; i++){
            int ost = n/i;
            if ((n/i)-ost == 0){
                System.out.println(i);
                break;
            }
        }
    }
    public static void Cap(){
        Scanner in = new Scanner(System.in);
        int del = -1;
        int des = in.nextInt();
        for (int i = 2; i<des; i++){//находим кратное число
            int ost = des/i;
            if ((des-(ost*i)) == 0){
                del = i;
                break;
            }
        }
        if (del == -1){// если число простое, то решение невозмозжно
            System.out.println(del);
        } else {
            System.out.println("2");
            System.out.println(Perevod(del) + " = " + del);
        }
    }
    public static int Perevod(int x){
        final int SYSTEM = 2;
        StringBuilder y = new StringBuilder();
        while (x/SYSTEM > 0){
            int tmp = x/SYSTEM;
            y.append(x - (SYSTEM * tmp));
            x = tmp;
        }
        y.append(x);
        y = y.reverse();
        x = Integer.parseInt(String.valueOf(y));
        return x;
    }
    public static void Perimetr(int[] A){
        Arrays.sort(A);
        boolean flag = true;
        System.out.println(A[0]);
         for (int i = A.length-1; i >=2; i--){
            int[] triangle = new int[] {A[i],A[i-1],A[i-2]};
            if ((PloshadTri(triangle) > 0)&&(triangle[0] < (triangle[1]+triangle[2]))){
                System.out.println(triangle[0]+triangle[1]+triangle[2]);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(0);
        }
    }
    public static double PloshadTri(int[] x){
        double polu = ((x[0]+x[1]+x[2])/2);
        double sqrt = Math.sqrt(polu+(polu-x[0])+(polu-x[1])+(polu-x[2]));
        return sqrt;
    }
    public static void Max(int[] x){
        String[] sx = new String[x.length];
        Map<Integer, String> spisok = new HashMap<>();
        Arrays.sort(x);
        int maxlength = Integer.toString(x[x.length-1]).length();
        for (int i = 0; i<x.length; i++){
            sx[i] = Integer.toString(x[i]);
            StringBuilder tmp = new StringBuilder(sx[i]);
            while (tmp.length()<maxlength){
                tmp.append(tmp.substring(tmp.length() - 1));
            }
            x[i] = Integer.parseInt(String.valueOf(tmp));
            spisok.put(x[i], sx[i]);
        }
        Arrays.sort(x);
        for (int i = x.length-1; i>=0; i--){
            System.out.print(spisok.get(x[i]));
        }
    }
    public static void Sort(int[][] x, int n, int m){//m - строка, n - столбец
        int[] tmp = new int[n+m+1];
        Arrays.fill(tmp, 101);
        int str; int stl;
        for (int u = 0; u<m; u++){
            str = u;
            stl = 0;
            while ((stl<n)&&(str<m)){
                tmp[stl] = x[str][stl];
                stl += 1;
                str += 1;
            }
            Arrays.sort(tmp);
            stl -= 1;
            str -= 1;
            while ((stl>=0)&&(str>=0)){
                x[str][stl] = tmp[stl];
                stl -= 1;
                str -= 1;
            }
            Arrays.fill(tmp, 101);
        }
        for (int u = 1; u<n; u++){
            stl = u;
            str = 0;
            while ((stl<n)&&(str<m)){
                tmp[str] = x[str][stl];
                stl += 1;
                str += 1;
            }
            Arrays.sort(tmp);
            stl -= 1;
            str -= 1;
            while ((stl>=0)&&(str>=0)){
                x[str][stl] = tmp[str];
                stl -= 1;
                str -= 1;
            }
            Arrays.fill(tmp, 101);
        }
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void Victory(String s1, String s2){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int flag = 0;
        boolean f = true;
        int j = 0;
        int[] s1c = new int[s1.length()];
        int[] s2c = new int[s2.length()];
        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        for (int i = 0; i< s1s.length; i++){
            s1c[i] = alphabet.indexOf(s1s[i]);
            s2c[i] = alphabet.indexOf(s2s[i]);
        }
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        while (j<s1c.length){
            if (s1c[j]<s2c[j]){
                flag = 1;
                break;
            }
            j++;
        }
        j = 0;
        if (flag == 1) {
            flag = 0;
            while (j < s1c.length) {
                if (s2c[j] < s1c[j]) {
                    flag = 1;
                    break;
                }
                j++;
            }
        }
        if (flag == 1)
            f = false;
        System.out.println(f);
    }
    public static void Polindrom(String s){
        String sub;
        List<String> var = new ArrayList<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i<s.length(); i++){
            if (i != s.lastIndexOf(sc[i])){
                sub = s.substring(i, s.lastIndexOf(sc[i])+1);
                String tsub = new StringBuilder(sub).reverse().toString();
                if (sub.equals(tsub) && (sub.length() != 1)){
                    var.add(sub);
                }
            }
        }
        int max = 0;
        int index = -1;
        for (int u = 0; u< var.size(); u++){
            if (max < var.get(u).length()){
                max = var.get(u).length();
                index = u;
            }
        }
        if (index == -1){
            System.out.println("None");
        } else {
            System.out.println(var.get(index));
        }
    }
    public static void Contaction(String s){
        String sub1;
        String  sub2;
        int c = 0;
        List<String> var = new ArrayList<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i<s.length(); i++){
            for (int g = i+1; g< s.length(); g++) {
                if ((sc[i] == sc[g]) && (g+g-i < s.length())){
                    sub1 = s.substring(i,g);
                    sub2 = s.substring(g,2*g-i);
                    if (sub1.equals(sub2)){
                        var.add(sub1);
                        c += 1;
                    }
                }
            }
        }
        System.out.println(c);
        for (int i = 0; i< var.size(); i++){
            System.out.print(var.get(i)+var.get(i)+" ");
        }
    }
}
