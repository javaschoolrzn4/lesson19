package com.javarzn.core.common.workers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportWorker {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public ReportWorker(String prefix, String postfix, String targetDir, boolean isNeedCreate, List<String> reportList) {

        if (isNeedCreate) {
            try {
                Files.createDirectories(Paths.get(targetDir));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(
                    Paths.get(targetDir, prefix + DATE_FORMAT.format(new Date()) + postfix),
                    String.join("\n", reportList).getBytes()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
