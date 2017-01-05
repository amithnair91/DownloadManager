package com.amith.download;

import com.amith.connection.HttpConnection;
import com.amith.model.HttpFile;
import com.amith.ui.ProgressUpdater;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by amithnair on 1/3/17.
 */
public class DownloadWorker implements Runnable {
    private static final int BUFFER_SIZE = 4096;
    private HttpFile _httpFile;
    private HttpConnection _connection;
    private ProgressUpdater _progressUpdater;

    public DownloadWorker(HttpFile httpFile, HttpConnection connection) throws IOException {
        _httpFile = httpFile;
        _connection = connection;
        _progressUpdater = new ProgressUpdater();
    }

    @Override
    public void run() {
        try {
            saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveFile() throws IOException {
        InputStream is = _connection.getInputStream();
        long downloadedFileSize = _httpFile.getDownloadedFileSize();
        final FileOutputStream outputStream = new FileOutputStream(_httpFile.getFilePath(), true);

        writeToDisk(downloadedFileSize, outputStream, is);
    }

    private void writeToDisk(long downloadedFileSize, FileOutputStream outputStream, InputStream inputStream) throws IOException {
        long totalFileSize = downloadedFileSize + _connection.getContentLength();
        final byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = 0;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
            outputStream.flush();
            downloadedFileSize += bytesRead;
            _progressUpdater.displayProgress(downloadedFileSize, totalFileSize);
        }
        outputStream.close();
        inputStream.close();
    }


}
