package com.company;

import java.util.Comparator;

public class SortByCost implements Comparator<State> {
    @Override
    public int compare(State state, State t1) {
        return state.cost - t1.cost;
    }
}
