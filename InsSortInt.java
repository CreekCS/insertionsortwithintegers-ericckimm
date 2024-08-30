//import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class InsSortInt {

    // Method to read integers from a file and add them to an ArrayList
    public static ArrayList<Integer> input(File file) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        scanner.close();
        return list;
    }

    // Method to convert ArrayList to an array
    public static int[] convert(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // Method to sort the array from greatest to smallest using insertion sort
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are smaller than key, to one position ahead
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        try {
            // File containing integers
            File file = new File("randInts.txt");

            // Step 1: Read integers from the file into an ArrayList
            ArrayList<Integer> list = input(file);

            // Step 2: Convert ArrayList to an array
            int[] array = convert(list);

            // Step 3: Sort the array from greatest to smallest
            sort(array);

            // Print sorted array for verification
            System.out.println("the smallest value in the array is: " +array[0]);
            System.out.println("the largest value in the array is: " +array[array.length-1]);

        } catch (FileNotFoundException e) {
            // Handle the case where the file was not found
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
