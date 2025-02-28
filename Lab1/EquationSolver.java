import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select equation type (1: single variable linear, 2: two variable linear, 3: quadratic):");
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                System.out.println("Enter coefficients a and b for equation in format ax + b = 0:");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();

                if (a == 0 && b== 0) {
                    System.out.println("The solution is all real numbers.");
                } else if (a == 0 && b != 0) {
                    System.out.println("No solution.");
                } else {
                    System.out.println("Solution: " + (-b/a));
                }
                break;

            case 2:
                System.out.println("Enter coefficients a1, b1, c1, a2, b2, c2 for equations in format a1x + b1y = c1 and a2x + b2y = c2:");
                double a1 = scanner.nextDouble();
                double b1 = scanner.nextDouble();
                double c1 = scanner.nextDouble();
                double a2 = scanner.nextDouble();
                double b2 = scanner.nextDouble();
                double c2 = scanner.nextDouble();

                double determinant = a1*b2 - a2*b1;
                double x = (c1*b2 - c2*b1)/determinant;
                double y = (a1*c2 - a2*c1)/determinant;

                if (determinant == 0 && a1*c2 - a2*c1 != 0) {
                    System.out.println("The system of equations has no solution.");
                } else if (determinant == 0 && a1*c2 - a2*c1 == 0) {
                    System.out.println("The system of equations has infinitely many solutions.");
                } else {
                    System.out.println("Solution: x = " + x + ", y = " + y);
                }
                break;

            case 3:
                System.out.println("Enter coefficients a, b, c for for quadratic equation in format ax^2 + bx + c = 0:");
                double aq = scanner.nextDouble();
                double bq = scanner.nextDouble();
                double cq = scanner.nextDouble();

                if (aq == 0) {
                    if (bq == 0 && cq == 0) {
                        System.out.println("The solution is all real numbers.");
                    } else if (bq == 0 && cq != 0) {
                        System.out.println("No solution.");
                    } else {
                        System.out.println("Solution: " + (-cq/bq));
                    }
                } else {
                    double discriminant = bq*bq - 4*aq*cq;
                    if (discriminant < 0) {
                        System.out.println("The equation has no real roots.");
                    } else if (discriminant == 0) {
                        double root = -bq / (2*aq);
                        System.out.println("The equation has one root: " + root);
                    } else {
                        double root1 = (-bq + Math.sqrt(discriminant))/(2*aq);
                        double root2 = (-bq - Math.sqrt(discriminant))/(2*aq);
                        System.out.println("The equation has two roots: " + root1 + " and " + root2);
                    }
                }
                break;

            default:
                System.out.println("Invalid input.");
                break;
        }
    }
}