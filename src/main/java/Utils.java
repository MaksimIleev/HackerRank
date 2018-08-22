public class Utils {

    public static int[] generateRandomArray(int arraySize) {

        int theArray[] = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {

            theArray[i] = (int) (Math.random() * 1000) + 10;

        }

        return theArray;

    }
}
