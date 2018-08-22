package data_structures_algorithms.Sort;

public class QuickSort {

    int theArray[];
    int arraySize;
    int itemsInArray;

    public QuickSort(int size) {
        this.theArray = new int[size];
    }


    public void quickSort(int left, int right) {

        if (right - left <= 0)
            return;

        else {

            int pivot = theArray[right];

            int pivotLocation = partitionArray(left, right, pivot);

            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);

        }

    }

    public int partitionArray(int left, int right, int pivot) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {

            while (theArray[++leftPointer] < pivot);

            while (rightPointer > 0 && theArray[--rightPointer] > pivot);

            if (leftPointer >= rightPointer) {

                break;

            } else {

                swapValues(leftPointer, rightPointer);

            }

        }

        swapValues(leftPointer, right);

        return leftPointer;

    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            theArray[i] = (int) (Math.random() * 1000) + 10;

        }

        itemsInArray = arraySize - 1;

    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

}
