package com.javarzn.core.nospring.workers;

import com.javarzn.core.common.ScanUtils;
import com.javarzn.core.common.workers.CopyWorker;
import com.javarzn.core.common.workers.ReportWorker;
import com.javarzn.core.nospring.config.AppConfig;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ScanWorker implements Runnable {
    private Properties appProperties;
    private boolean isRunning = false;

    public ScanWorker() {
        this.appProperties = new AppConfig().getResource();
        if (Objects.nonNull(appProperties)) {
            this.isRunning = true;
        }
    }

    public void run() {
        while (isRunning) {
            try {
                List<String> reportList = new ArrayList<>();

                ScanUtils.scanDirectory(appProperties, Paths.get(appProperties.getProperty("scan.directory")), reportList);

                if (Boolean.valueOf(appProperties.getProperty("copy.enabled"))) {
                    new CopyWorker(
                            Integer.valueOf(appProperties.getProperty("copy.thread.count")),
                            appProperties.getProperty("copy.directory"),
                            Boolean.valueOf(appProperties.getProperty("copy.directory.create")),
                            reportList
                    );
                }

                if (Boolean.valueOf(appProperties.getProperty("report.enabled"))) {
                    new ReportWorker(
                            appProperties.getProperty("report.name.prefix"),
                            appProperties.getProperty("report.name.postfix"),
                            appProperties.getProperty("report.directory"),
                            Boolean.valueOf(appProperties.getProperty("report.directory.create")),
                            reportList
                    );
                }

                System.out.println(String.join("", "\n", "Сканирование завершено, повторение...", "\n"));
                Thread.currentThread().sleep(Long.valueOf(appProperties.getProperty("scan.interval.sec")) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
