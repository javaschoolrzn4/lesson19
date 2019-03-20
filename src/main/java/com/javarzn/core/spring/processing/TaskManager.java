package com.javarzn.core.spring.processing;

import java.util.concurrent.Executor;

public class TaskManager {
    public TaskManager(Executor executor, Runnable task) {
        executor.execute(task);
    }
}
