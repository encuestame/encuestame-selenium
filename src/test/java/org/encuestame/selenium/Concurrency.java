package org.encuestame.selenium;

/**
 * Created by dmorales on 30/06/15.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

public class Concurrency extends Parameterized {

    private static class ThreadPoolScheduler implements RunnerScheduler  {
        private ExecutorService executor;

        public ThreadPoolScheduler() {
            String threads = System.getProperty("junit.parallel.threads", "16");
            int numThreads = Integer.parseInt(threads);
            executor = Executors.newFixedThreadPool(numThreads);
        }


        public void schedule(Runnable runnable) {
            executor.submit(runnable);
        }

        public void finished() {
            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                throw new RuntimeException(exc);
            }
        }
    }

    public Concurrency(Class<?> klass) throws Throwable {
        super(klass);
        setScheduler(new ThreadPoolScheduler());
    }
}
