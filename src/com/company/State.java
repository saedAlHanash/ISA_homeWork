package com.company;


import java.util.Arrays;

public class State implements Stage, Cloneable {

    public int x, y;
    public int cost;
    public State parent;
    public int[][] stage;


    public State(int x, int y, int cost, State parent, int[][] stage) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.parent = parent;
        this.stage = stage;
    }


    public State getState() {

        int[][] tempStage;
        tempStage = this.stage.clone();
        for (int i = 0; i < tempStage.length; i++) {
            tempStage[i] = tempStage[i].clone();
        }
        return new State(x, y, this.cost, this, tempStage);
    }

    public boolean checkVisited(State state) {

        for (int i = 0; i < visited.size(); i++) {
            if (Arrays.deepEquals(visited.get(i).stage,state.stage)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkQueue(State state) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).x == state.x && queue.get(i).y == state.y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPath(int newX, int newY) {
        if (newX < Stage.x && newX >= 0 && newY < Stage.y && newY >= 0 && stage[newX][newY] != 9)
        {
            return true;
        }
        else return false;
    }

    public boolean checkMove(State state) {
        return this.x != state.x || this.y != state.y;
    }

    public State moveUp() {
        State state = this.getState();
        state.stage[state.x][state.y] = 1;

        while (checkPath(state.x, state.y - 1)) {
            state.y = state.y - 1;
            state.cost += 1;
            state.stage[state.x][state.y] = 1;
        }
        state.stage[state.x][state.y] = 2;

        return state;
    }


    public State moveDown() {
        State state = this.getState();
        state.stage[state.x][state.y] = 1;

        while (checkPath(state.x, state.y + 1)) {
            state.y = state.y + 1;
            state.cost += 1;
            state.stage[state.x][state.y] = 1;
        }
        state.stage[state.x][state.y] = 2;
        return state;
    }

    public State moveRight() {
        State state = this.getState();
        state.stage[state.x][state.y] = 1;

        while (checkPath(state.x + 1, state.y)) {
            state.x = state.x + 1;
            state.cost += 1;
            state.stage[state.x][state.y] = 1;
        }
        state.stage[state.x][state.y] = 2;
        return state;
    }

    public State moveLift() {
        State state = this.getState();
        state.stage[state.x][state.y] = 1;

        while (checkPath(state.x - 1, state.y)) {
            state.x = state.x - 1;
            state.cost += 1;
            state.stage[state.x][state.y] = 1;
        }
        state.stage[state.x][state.y] = 2;
        return state;
    }

    @Override
    public String toString() {
        return "{" +
                x +
                ", " + y +
                ", cost=" + cost +
                '}';
    }
}
