//package com.company;

public class MyDeque {
    private int size;
    private String[] dequeArray;
    private String top;
    private String bottom;
    private int head;
    private int tail;

    public MyDeque(){
        size = 200;
        tail = size/2;
        head = size - tail;
        dequeArray = new String[size];
        top = null;
        bottom = null;
    }
    public boolean isVoid(){
        return ((this.dequeArray[head] == null) && (this.dequeArray[tail] == null));
    }
    public void pushT(String a){
        if (this.isVoid()){
            top = a;
            this.dequeArray[head] = top;
            bottom = a;
        }else {
            if (head + 1 == size) {
                System.out.println("Дэк полон спереди");
            } else {
                top = a;
                head += 1;
                this.dequeArray[head] = top;
            }
        }
    }
    public void pushB(String a){
        if (this.isVoid()){
            bottom = a;
            this.dequeArray[tail] = bottom;
            top = a;
        } else {
            if (tail - 1 == 0) {
                System.out.println("Дэк полон сзади");
            } else {
                tail -= 1;
                bottom = a;
                this.dequeArray[tail] = bottom;
            }
        }
    }
    public String popT(){
        String tmptop = top;
        this.dequeArray[head] = null;
        head -= 1;
        if (this.isVoid()){
            bottom = null;
            top = null;
        } else {
            top = this.dequeArray[head];
        }
        return tmptop;
    }
    public String popB(){
        String tmpbottom = bottom;
        this.dequeArray[tail] = null;
        tail += 1;
        if (this.isVoid()){
            bottom = null;
            top = null;
        } else {

            bottom = this.dequeArray[tail];
        }
        return tmpbottom;
    }
    public void DequetoString(){
        System.out.println("Дэк = ");
        for (int i = 0; i<size; i++){
            if (this.dequeArray[i] != null)
            System.out.print(this.dequeArray[i] + "; ");
        }
        System.out.println();
    }
    public String getTop(){
        return top;
    }
    public String getBottom(){
        return bottom;
    }
    public int getSize(){
        int s = 0;
        for (int i = size-1; i>0; i--){
            if (this.dequeArray[i] != null)
                s+=1;
        }
        return s;
    }
}
