//package com.company;

import java.util.*;

public class Solver {
    private final List<Board> result = new ArrayList<>();
    private static class State {    // Чтобы узнать длину пути, нам нужно помнить предыдущие позиции (и не только поэтому)
        private final State prevBoard;
        private final Board presentBoard;
        private State(State prevBoard, Board presentBoard) {
            this.prevBoard = prevBoard;
            this.presentBoard = presentBoard;
        }
        public Board getPresentBoard() {
            return presentBoard;
        }
    }
    public Solver(Board initial) {
        if(!isSolvable(initial)) {
            System.out.println("Нерешаемо");
            return;
        }
        // Очередь. Для нахождения приоритетного сравниваем меры
        PriorityQueue<State> priorityQueue = new PriorityQueue<>(10, Comparator.comparingInt(Solver::f));
        priorityQueue.add(new State(null, initial));
        while (true){
            State board = priorityQueue.poll();
            if(board.presentBoard.isGoal()) {            //   если дошли до решения, сохраняем весь путь ходов в лист
                itemToList(new State(board, board.presentBoard));
                return;
            }
            //соседи
            for (Board board1 : board.presentBoard.neighbors()) {
                if (board1 != null && !containsInPath(board, board1))
                    priorityQueue.add(new State(board, board1));
            }

        }
    }
    //  вычисляем f(x)
    private static int f(State state){
        State state2 = state;
        int c = 0;   // g(x)(стоимость) - количество ходов, которые привели к этому состоянию
        int measure = state.getPresentBoard().h();  // h(x)(расстояние)
        while (true){
            c++;
            state2 = state2.prevBoard;
            if(state2 == null) {
                return measure + c;// g(x) + h(x)
            }
        }
    }
    //  сохранение
    private void itemToList(State state){
        State state2 = state;
        while (true){
            state2 = state2.prevBoard;
            if(state2 == null) {
                Collections.reverse(result);
                return;
            }
            result.add(state2.presentBoard);
        }
    }
    // была ли уже такая позиция в пути
    private boolean containsInPath(State state, Board board){
        State state2 = state;
        while (true){
            if(state2.presentBoard.equals(board)) return true;
            state2 = state2.prevBoard;
            if(state2 == null) return false;
        }
    }
    public boolean isSolvable(Board board) {
        int e = board.getZeroY() + 1;
        int k = 0;
        int tmpk = 0;
        int min = 16;
        int[][] tmp = board.getBlocks();
        for (int i = 0; i<tmp.length; i++){
            for (int j = 0; j<tmp.length; j++){
                for (int u = i; u <tmp.length; u++){
                    for (int o = j; o <tmp.length; o++){
                        if((tmp[i][j]>tmp[u][o]) && (tmp[u][o] != 0)){
                            k+=1;
                        }
                    }
                }
            }
        }
        tmpk = e + k;
        return (tmpk % 2 == 0);
    }
    public Iterable<Board> solution() {
        return result;
    }
}
