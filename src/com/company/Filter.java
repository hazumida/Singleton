package com.company;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        int pass = 0;
        List<Integer> result = new ArrayList<>();
        for (int element : source) {
            if (element < treshold) {
                logger.log(String.format("Элемент \"%d\" не проходит", element));
            } else {
                logger.log(String.format("Элемент \"%d\" проходит", element));
                result.add(element);
                pass++;
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", pass, source.size()));
        return result;
    }
}
