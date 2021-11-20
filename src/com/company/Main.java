package com.company;

public class Main implements Stage {
    static State temp;

    public static void main(String[] args) {

        int[][] saed = {

                // x= 8 , y = 9 ball : x =0 y = 8
/*                {9, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 9, 9, 9, 0, 9, 9},
                {9, 0, 0, 9, 9, 9, 0, 9, 9},
                {9, 9, 0, 9, 9, 9, 0, 0, 0},
                {9, 9, 0, 9, 9, 9, 0, 9, 0},
                {9, 9, 0, 9, 9, 9, 9, 9, 0},
                {0, 0, 0, 0, 0, 9, 9, 9, 0},
                {0, 9, 9, 0, 0, 0, 0, 0, 0},*/

                // x= 8 , y = 8  ball : x =4 y = 7
                {0, 0, 0, 9, 0, 9, 0, 0},
                {9, 0, 0, 0, 0, 9, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 0, 0, 9, 9},
                {0, 9, 9, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},

                //x = 6 y = 9
/*                {0, 0, 0, 9, 0, 0, 9, 0, 2},
                {9, 9, 0, 9, 0, 0, 9, 0, 0},
                {9, 9, 0, 0, 9, 0, 9, 0, 9},
                {0, 0, 0, 0, 0, 0, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 0, 0, 0, 0, 0, 0},*/

        };


        State root = new State(4, 7, 0, null, new int[Stage.x][Stage.y]);
        root.stage = saed;

        queue.add(root);
        stack.add(root);
        visited.add(root);
          printStage(root);

         DFS();
        visited.clear();
        visited.add(root);
        System.out.println("this is BFS" + "\n\n\n\n\n");
        BFS();
        System.out.println("this is UCS" + "\n\n\n\n\n");
        queue.clear();
        visited.clear();
        queue.add(root);
        visited.add(root);
        UCS();


    }

    static void DFS() {
        while (!stack.isEmpty()) {
            State state = stack.pop();
            if (isGaol(state)) {
                System.out.println("cost = " + state.cost);
                while (state.parent != null) {
                    printStage(state);
                    state = state.parent;
                }
                return;
            }
            // printStage(state);
//            if (state.parent != null)
//                System.out.println(state.toString() + state.parent.x + "  " + state.parent.y);
//            else {
//                System.out.println(state.toString() + "  " + state.parent);
//            }

            temp = state.moveUp();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    stack.add(temp);
                }
            }
            temp = state.moveDown();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    stack.add(temp);
                }
            }
            temp = state.moveRight();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    stack.add(temp);
                }
            }
            temp = state.moveLift();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    stack.add(temp);
                }
            }

        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {

            State state = queue.get(0);
            queue.remove(0);
            if (isGaol(state)) {
                System.out.println("cost = " + state.cost);
                while (state.parent != null) {
                    printStage(state);
                    state = state.parent;

                }
                return;
            }
            //printStage(state);
/*           if (state.parent != null)
               System.out.println(state.toString() + state.parent.x + "  " + state.parent.y);
           else {
               System.out.println(state.toString() + "  " + state.parent);
           }*/

            temp = state.moveUp();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                }
            }
            temp = state.moveDown();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                }
            }
            temp = state.moveLift();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                }
            }
            temp = state.moveRight();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                }
            }
        }

    }

    static void UCS() {
        while (!queue.isEmpty()) {

            State state = queue.get(0);
            queue.remove(0);

            if (isGaol(state)) {
                System.out.println("cost = " + state.cost);
                while (state.parent != null) {
                    printStage(state);
                    state = state.parent;
                }
                return;
            }
            //printStage(state);
/*            if (state.parent != null)
                System.out.println(state.toString() + state.parent.x + "  " + state.parent.y);
            else {
                System.out.println(state.toString() + "  " + state.parent);
            }*/

            temp = state.moveUp();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                    queue.sort(new SortByCost());
                }
            }
            temp = state.moveDown();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                    queue.sort(new SortByCost());
                }
            }
            temp = state.moveRight();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                    queue.sort(new SortByCost());
                }
            }
            temp = state.moveLift();
            if (state.checkMove(temp)) {
                if (!state.checkVisited(temp)) {
                    temp.parent = state;
                    visited.add(temp);
                    queue.add(temp);
                    queue.sort(new SortByCost());
                }
            }

        }
    }

    public static boolean isGaol(State state) {
        for (int i = 0; i < Stage.x; i++) {
            for (int j = 0; j < Stage.y; j++) {
                if (state.stage[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void printStage(State state) {
        State state1 = state.getState();
        //state1.stage[state.x][state.y] = 2;
        for (int i = 0; i < y; i++) {
            System.out.println();
            for (int j = 0; j < x; j++) {
                if (state1.stage[j][i] == 0)
                    System.out.print(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
                else if (state1.stage[j][i] == 1)
                    System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET);
                else if (state1.stage[j][i] == 2)
                    System.out.print(ANSI_RED_BACKGROUND + "   " + ANSI_RESET);
                else
                    System.out.print(" * " + ANSI_RESET);


            }
        }
        System.out.println("\n\n\n\n\n\n");
    }


    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLAC


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}
