package com.tihomir.example.qa.testbase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.model.RunnerScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ParallelScheduler implements RunnerScheduler {

    private static final int THREAD_TERMINATION_LIMIT_MINUTES = 500;
	private static final Logger logger = LoggerFactory.getLogger(ParallelScheduler.class);

    private ExecutorService executor;

    public ParallelScheduler(String threadCount) {
        logger.debug("ThreadPoolScheduler contructor start");

        int numThreads = Integer.parseInt(threadCount);
        logger.debug("ThreadPoolScheduler number of threads: " + numThreads);
        executor = Executors.newFixedThreadPool(numThreads);
        logger.debug("ThreadPoolScheduler contructor end");
    }

    public void finished() {
        logger.debug("ThreadPoolScheduler finished start");
        executor.shutdown();
        try {
            executor.awaitTermination(THREAD_TERMINATION_LIMIT_MINUTES, TimeUnit.MINUTES);
        } catch (InterruptedException exc) {
            throw new RuntimeException(exc);
        }
        logger.debug("ThreadPoolScheduler finished end");
    }

    public void schedule(Runnable childStatement) {
        logger.debug("ThreadPoolScheduler schedule start");
        executor.submit(childStatement);
        logger.debug("ThreadPoolScheduler schedule end");
    }
}
