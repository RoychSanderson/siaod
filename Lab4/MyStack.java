//package com.company;

public class MyStack {
    private int size;
    private String[] stackArray;
    private String top;
    private int poz;
    public int number;

    public MyStack(int i){
        size = 1000;
        stackArray = new String[size];
        top = null;
        poz = -1;
        number = i;
    }
    public boolean isVoid(){
        return top == null;
    }
    public void push(String a){
        if (poz == -1){
            this.stackArray[0] = a;
            poz = 0;
        } else {
            if (poz+1 >= size){
                System.out.println("Стэк полон");
                return;
            }
            poz += 1;
            this.stackArray[poz] = a;
        }
        top = a;
    }
    public String popout(){
        String tmptop = top;
        this.stackArray[poz] = null;
        poz -= 1;
        if (poz == -1){
            top = null;
        } else {
            top = this.stackArray[poz];
        }
        return tmptop;
    }
    public void MyToString(){
        System.out.print("Стэк = ");
        for (int i = 0; i < size; i++){
            if (this.stackArray[i] != null)
                System.out.print(" " + this.stackArray[i]);
        }
        System.out.println();
    }
    public String getTop(){
        return top;
    }
}
