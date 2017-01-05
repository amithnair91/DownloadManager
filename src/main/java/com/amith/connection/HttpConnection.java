package com.amith.connection;

import com.amith.model.HttpFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.io.File;

/**
 * Created by amithnair on 1/2/17.
 */
public class HttpConnection {
    private HttpFile _httpFile;
    private HttpURLConnection _connection;

    public HttpConnection(HttpFile httpFile) throws IOException {
        _httpFile = httpFile;
        _connection = (HttpURLConnection) _httpFile.getURL().openConnection();
        _connection.setRequestProperty("Range", "bytes=" + new File(_httpFile.getFilePath()).length() + "-");
    }

    public long getContentLength() {
        return _connection.getContentLength();
    }


    public InputStream getInputStream() throws IOException {
        return _connection.getInputStream();
    }
}
