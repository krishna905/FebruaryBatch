package GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {
    private void sortDataOnBasisOfEndArray(int start[], int end[]) {
        Map<Integer, List<Integer>> startEndMap = new TreeMap<>();

        for(int i = 0; i < end.length; i++) {
            List<Integer> valueList;
            if(startEndMap.containsKey(end[i])) {
                valueList = startEndMap.get(end[i]);
            }
            else {
                valueList = new ArrayList<>();
            }
            valueList.add(start[i]);
            Collections.sort(valueList);
            startEndMap.put(end[i], valueList);
        }

        int currentIndex = 0;
        for(Map.Entry<Integer, List<Integer>> eachEntry : startEndMap.entrySet()) {
            int key = eachEntry.getKey();
            List<Integer> value = eachEntry.getValue();

            for(Integer eachValue : value) {
                start[currentIndex] = eachValue;
                end[currentIndex] = key;

                currentIndex++;
            }
        }
    }

    private void solve(int start[], int end[]) {
        int i, j, count;

        i = 0;
        count = 1;
        System.out.print(i + " ");

        for(j = 1; j < start.length; j++) {
            if(start[j] >= end[i]) {
                System.out.print(j + " ");
                i = j;
                count++;
            }
        }
        System.out.println();
        System.out.println("Number of activities: " + count);
    }

    public static void main(String[] args) {
        ActivitySelection activitySelection = new ActivitySelection();

        int start[] = {0, 1, 2, 5, 5, 8};
        int end[] = {6, 2, 4, 9, 7, 9};

        activitySelection.sortDataOnBasisOfEndArray(start, end);
        activitySelection.solve(start, end);
    }
}