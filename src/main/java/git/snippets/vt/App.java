package git.snippets.vt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/21
 * @since 19
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            tasks.add(new Task(i));
        }
        long time = System.currentTimeMillis();
        List<Future<Integer>> futures = executor.invokeAll(tasks);
        long sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        time = System.currentTimeMillis() - time;
        System.out.println("sum = " + sum + "; time = " + time + " ms");
        executor.shutdown();
    }
}
