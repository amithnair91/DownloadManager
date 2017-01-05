package com.amith.download;

import com.amith.connection.HttpConnection;
import com.amith.model.HttpFile;

import java.io.IOException;

/**
 * Created by amithnair on 1/4/17.
 */
public class DownloadManager {

    private HttpFile _httpFile;
    private HttpConnection _connection;
    private Thread _downloadThread;


    public DownloadManager(HttpFile httpFile) throws IOException {
        _httpFile = httpFile;
        _connection = new HttpConnection(_httpFile);
        _downloadThread = new Thread(new DownloadWorker(_httpFile, _connection));
    }

    public void startDownload() throws IOException {
        _downloadThread.start();
    }

    public void pause() throws InterruptedException {
        _downloadThread.stop();
    }

    public void resume() throws IOException {
        _downloadThread = new Thread(new DownloadWorker(_httpFile, _connection));
        _downloadThread.start();
    }


}
