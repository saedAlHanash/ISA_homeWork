package com.company;

import java.util.ArrayList;
import java.util.Stack;

public interface Stage {
    int x = 8;
    int y = 8;
    //int[][] stage = new int[x][y];
    ArrayList<State> visited = new ArrayList<>();
    Stack<State> stack = new Stack<>();
    ArrayList<State> queue = new ArrayList<>();
    //ArrayList<State> open = new ArrayList<>();
}
