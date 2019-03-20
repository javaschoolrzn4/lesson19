package com.javarzn.core.common.workers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyWorker {
    public CopyWorker(int threadCount, String targetDir, boolean isNeedCreate, List<String> reportList) {
        if (isNeedCreate) {
            try {
                Files.createDirectories(Paths.get(targetDir));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (String reportItem: reportList) {
            executorService.submit(()-> {
                try {
                    Files.copy(
                            Paths.get(reportItem),
                            new FileOutputStream(Paths.get(targetDir).toFile().getAbsolutePath() + reportItem.substring(reportItem.lastIndexOf('\\')))
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
