package Logic;

/**
 *
 * @author ganesan
 */
public class Fibonacci {

    public static void main(String args[]) {

        int num = 10;

        System.out.println("*****Fibonacci Series*****");
        int f1 = 0, f2 = 1, f3 = 0;
        for (int i = 1; i <= num; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
            System.out.print(" " + f3 + " ");
        }

        System.out.println(" ");
        for (int i = 1; i <= 10; i++) {
            int f = fibo(i);
            System.out.print(f + " ");
        }

        newMethod();
    }

    static int fibo(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    static void newMethod() {
        int limit = 20;
        long[] series = new long[limit];
        series[0] = 0;
        series[1] = 1;
        for (int i = 2; i < limit; i++) {
            series[i] = series[i - 1] + series[i - 2];
        }
        System.out.println("Fibonacci Series upto " + limit);
        for (int i = 0; i < limit; i++) {
            System.out.print(series[i] + " ");
        }
    }
}
