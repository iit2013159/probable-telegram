package interviewbit.hashing;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RollingHash {
    static Random random = new Random(System.currentTimeMillis());

    static long getRand() {
        return random.nextLong() % 1000;
    }

    public static void main(String[] args) {
        Math.random();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            service.submit(() -> IntStream.range(1, 1000000000).parallel().filter(al -> check()).forEach(System.out::println));
        }
        service.shutdown();
    }

    private static boolean check() {
        long a = getRand();
        long b = getRand();
        long c = getRand();
        long x = getRand();
        long y = getRand();
        long z = getRand();
        boolean re = (a + b * 2 + c) % (x + y * 2 + z) == 0;
        if (re == true) {
            System.out.println("a " + a + " b " + b + " c " + c + " x " + x + " y " + y + " z " + z);
        }
        return re;
    }
}
