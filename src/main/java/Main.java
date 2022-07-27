import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    /*
    Create a program that takes integers as input from the user (standard input)
    and only the numbers that are prime (in any order).

    A prime number is any number greater than 1 that whose only factor is itself, i.e.,
    it cannot be formed by multiplying two smaller natural numbers.

    The main method should read numbers from the user, create a task to check if the number is prime,
    and print the number if it’s prime.
    Remember to properly shutdown the executor you create.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            PrimeLogger primeLogger = new PrimeLogger(num);
            executor.submit(primeLogger);
        }

        executor.shutdown();
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        boolean flag = false;
        if (num == 1) {
            flag = true;
        }
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println(num);
        } else {
            System.out.print("");
        }
    }
}