package com.amith.model;

import java.io.File;
import java.net.URL;

/**
 * Created by amithnair on 1/2/17.
 */
public class HttpFile {

    private String _filePath;
    private URL _httpUrl;

    public HttpFile(URL httpUrl, String fileDirectory) {
        _httpUrl = httpUrl;
        _filePath = fileDirectory;
    }

    public long getDownloadedFileSize() {
        return new File(_filePath).length();
    }

    public URL getURL() {
        return _httpUrl;
    }

    public String getFilePath() {
        return _filePath;
    }
}
