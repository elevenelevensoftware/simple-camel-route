package com.learncamel.simpleroute;

public class CamelFile {

    private final String absolutePath;
    private final String fileName;
    private final String filePath;

    public CamelFile(String absolutePath, String fileName, String filePath) {
        this.absolutePath = absolutePath;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}
