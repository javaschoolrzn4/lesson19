package com.javarzn.core.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public final class ScanUtils {
    public static final String CONSOLE_REPORT = "%s - размер файла: %s %s";

    private ScanUtils() {
        throw new UnsupportedOperationException("Utils class");
    }

    public static ScanParameters getScanParameters(Properties properties) {
        String kbSize = properties.getProperty("scan.file.size.kb");
        String mbSize = properties.getProperty("scan.file.size.mb");
        String gbSize = properties.getProperty("scan.file.size.gb");
        if (Objects.nonNull(kbSize)) {
            return new ScanParameters(Long.valueOf(kbSize), 1024, "КБ");
        } else if (Objects.nonNull(mbSize)) {
            return new ScanParameters(Long.valueOf(mbSize), 1024 * 1024, "МБ");
        } else if (Objects.nonNull(gbSize)) {
            return new ScanParameters(Long.valueOf(gbSize), 1024 * 1024 * 1024, "ГБ");
        } else {
            return new ScanParameters(Long.valueOf(0), 1, "байт");
        }
    }

    public static void scanDirectory(Properties scanProperties, Path path, List<String> reportList) {
        ScanParameters scanParameters = getScanParameters(scanProperties);
        try {
            Files.newDirectoryStream(path).forEach(item -> {
                File file = item.toAbsolutePath().toFile();
                if (file.isDirectory()) {
                    scanDirectory(scanProperties, item, reportList);
                } else {
                    if (file.length() >= scanParameters.getTargetSize()) {
                        if (file.getAbsolutePath().endsWith(scanProperties.getProperty("scan.file.extension"))) {
                            reportList.add(item.toFile().getAbsolutePath());
                            String consoleReport = String.format(CONSOLE_REPORT, item.toFile().getAbsolutePath(),
                                    file.length() / scanParameters.getByteOffset(), scanParameters.getSizeType());
                            System.out.println(consoleReport);
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
