package com.ardentlabs.globalencyc.util;

/**
 * Created by muneebahmad on 04/04/15.
 */
public class MySorter {

    public MySorter() {}

    /**
     *
     * @param array Array[]
     */
    public static void sortBubble(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i +1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
    }

    /**
     *
     * @param i
     * @param j
     * @param array
     */
    static void swapNumbers(int i, int j, int array[]) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}/** end class. */
