package a;
import java.util.*;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Asking for the length of the array
        System.out.println("Enter the length of the array:");
        int length = input.nextInt();

        //Initialize the array with the given length
        int[] array = new int[length];

        //Getting the elements of the array from the user
        System.out.println("Enter array elements:");
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }

        //Sorting the array
        Arrays.sort(array);

        //Calculating the sum
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        //Calculating the average
        double average = (double) sum / length;

        //Printing the sorted array, sum and average
        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}