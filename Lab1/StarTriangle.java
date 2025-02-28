package a;
import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the height of the triangle:");
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");  // print spaces
            }

            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*"); // print stars
            }
            System.out.println();
        }
    }
}