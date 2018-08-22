package data_structures_algorithms.Sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int data[] = new int[10000];
        for(int i = 0; i < data.length; i++) {

        }
        long start = System.currentTimeMillis();

        new InsertionSort().sort(data);

        long end = System.currentTimeMillis();
        System.out.println("Insertion Sort execution time: " + (end - start) + " ms");
        System.out.println(Arrays.toString(data));
    }

    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] >= current) {
                data[j + 1] = data[j];// swap values
                j--;
            }
            data[j + 1] = current;
        }
    }
}
