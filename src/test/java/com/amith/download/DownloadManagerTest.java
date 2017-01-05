package com.amith.download;

import com.amith.connection.HttpConnection;
import com.amith.model.HttpFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by amithnair on 1/2/17.
 */
public class DownloadManagerTest {

    private static final String FILE_DESTINATION = "/Users/amithnair/Documents/test_download/http.svg";
    private static final String DOWNLOAD_URL = "http://httpwg.org/asset/http.svg";

    private HttpFile httpFile;
    private File downloadedFile;

    @Before
    public void setup() throws IOException {
        httpFile = new HttpFile(new URL(DOWNLOAD_URL), FILE_DESTINATION);
    }

    @Test
    public void shouldBeAbleToDownloadFile() throws IOException, InterruptedException {
        DownloadManager downloadManager = new DownloadManager(httpFile);
        downloadManager.startDownload();
        Thread.sleep(3000);
        downloadedFile = new File(FILE_DESTINATION);
        assertTrue(new File(FILE_DESTINATION).exists());
        assertEquals(2771, httpFile.getDownloadedFileSize());
    }


    @Test
    public void shouldBeAbleToPauseAndResumeWhileDownloadingFile() throws IOException, InterruptedException {
        DownloadManager downloadManager = new DownloadManager(httpFile);

        downloadManager.startDownload();
        downloadManager.pause();
        Thread.sleep(100);
        downloadManager.resume();
        Thread.sleep(3000);

        downloadedFile = new File(FILE_DESTINATION);
        assertTrue(downloadedFile.exists());
        assertEquals(2771, httpFile.getDownloadedFileSize());
    }

    @After
    public void tearDown() {
        downloadedFile.delete();
    }


}
