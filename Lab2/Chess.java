//package com.company;

public class Chess {
    static int[] bd = {0,0,0,0,0,0,0,0};
    static int ind = 0;
    static int flag = 0;
    public static void Place(){
        do {
            if (checking()){
                if (ind == 7) {
                    int[][] matrix = new int[8][8];
                    System.out.println(" A" + (bd[0]+1)
                            + " B" + (bd[1]+1)
                            + " C" + (bd[2]+1)
                            + " D" + (bd[3]+1)
                            + " E" + (bd[4]+1)
                            + " F" + (bd[5]+1)
                            + " G" + (bd[6]+1)
                            + " H" + (bd[7]+1));
                    for (int i = 0; i<8; i++){
                        for (int j = 0; j<8; j++){
                            matrix[i][j] = 0;
                        }
                    }
                    for (int i = 0; i<8; i++){
                        matrix[bd[i]][i] = 1;
                    }
                    for (int i = 0; i<8; i++){
                        for (int j = 0; j<8; j++){
                            System.out.print(matrix[i][j]);
                        }
                        System.out.println();
                    }
                    flag = 1;
                }
                else {
                    ind++;//строки - буквы
                }
            }
            else {
                bd[ind]++;//столбцы
            }
        } while (flag < 1);
    }
    static boolean checking() {
            int i;
        if (ind == 0) {
            return true;
        }
        if (bd[ind]>7){
            bd[ind] = 0;
            ind--;
            return false;
        }
        for (i = 0; i < ind; i++){
            if ( (bd[ind] == bd[i]) || ( (Math.abs(bd[ind] - bd[i]) ) == (ind -i) ) ){
                return false;
            }
        }
        return true;
    }
}

