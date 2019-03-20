package com.javarzn.core.spring.workers;

import com.javarzn.core.common.ScanUtils;
import com.javarzn.core.common.workers.CopyWorker;
import com.javarzn.core.common.workers.ReportWorker;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ScanWorker implements Runnable {
    private Properties appProperties;
    private boolean isRunning = false;

    private String scanDirectory;
    private int scanIntervalSec;

    private boolean copyEnabled;
    private int copyThreadCount;
    private String copyDirectory;
    private boolean copyDirectoryCreate;

    private boolean reportEnabled;
    private String reportNamePrefix;
    private String reportNamePostfix;
    private String reportDirectory;
    private boolean reportDirectoryCreate;

    public ScanWorker(Properties appProperties, String scanDirectory, int scanIntervalSec, boolean copyEnabled,
                      int copyThreadCount, String copyDirectory, boolean copyDirectoryCreate, boolean reportEnabled,
                      String reportNamePrefix, String reportNamePostfix, String reportDirectory, boolean reportDirectoryCreate) {
        this.appProperties = appProperties;
        if (Objects.nonNull(appProperties)) {
            this.isRunning = true;
        }

        // простанавливаем значения файла настроек
        this.scanDirectory = scanDirectory;
        this.scanIntervalSec = scanIntervalSec;

        this.copyEnabled = copyEnabled;
        this.copyThreadCount = copyThreadCount;
        this.copyDirectory = copyDirectory;
        this.copyDirectoryCreate = copyDirectoryCreate;

        this.reportEnabled = reportEnabled;
        this.reportNamePrefix = reportNamePrefix;
        this.reportNamePostfix = reportNamePostfix;
        this.reportDirectory = reportDirectory;
        this.reportDirectoryCreate = reportDirectoryCreate;
    }

    public void run() {
        while (isRunning) {
            try {
                List<String> reportList = new ArrayList<>();

                ScanUtils.scanDirectory(appProperties, Paths.get(scanDirectory), reportList);

                if (copyEnabled) {
                    new CopyWorker(copyThreadCount, copyDirectory, copyDirectoryCreate, reportList);
                }

                if (reportEnabled) {
                    new ReportWorker(reportNamePrefix, reportNamePostfix, reportDirectory, reportDirectoryCreate, reportList);
                }

                System.out.println(String.join("", "\n", "Сканирование завершено, повторение...", "\n"));
                Thread.currentThread().sleep(scanIntervalSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
