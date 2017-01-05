package com.amith.download;

import com.amith.model.HttpFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by amithnair on 1/2/17.
 */
public class DownloadManagerTest {


    private static final String TEMP_DIR_NAME = "temp-download";
    private static final String DOWNLOAD_URL = "http://httpwg.org/asset/http.svg";
    private String fileName = "http.svg";


    private HttpFile httpFile;
    private File downloadedFile;
    private String FILE_DESTINATION;
    private Path tempDirPath;

    @Before
    public void setup() throws IOException {
        tempDirPath = Files.createTempDirectory(TEMP_DIR_NAME);
        FILE_DESTINATION =  tempDirPath.toAbsolutePath().toString().concat(fileName);
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
        tempDirPath.toFile().delete();
    }


}
