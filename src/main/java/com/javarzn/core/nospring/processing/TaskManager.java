package com.javarzn.core.nospring.processing;

import com.javarzn.core.nospring.workers.ScanWorker;

public class TaskManager {
    public TaskManager() {
        new ScanWorker().run();
    }
}
