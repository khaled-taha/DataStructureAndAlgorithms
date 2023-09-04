package cloudNativeBaseCamp.sections.section_1;

import java.util.Scanner;

public class Correlation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y, a, b, c, n, sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter X[" + (i + 1) + "] : ");
            x = input.nextInt();

            System.out.print("Enter Y[" + (i + 1) + "] : ");
            y = input.nextInt();

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }

        a = (n * sumXY) - (sumX * sumY);
        b = n * sumX2 - (int) Math.pow(sumX, 2);
        c = n * sumY2 - (int) Math.pow(sumY, 2);

        System.out.println("R = " + a / Math.sqrt(b * c));
    }
}
