package com.amith.download;

import com.amith.connection.HttpConnection;
import com.amith.model.HttpFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by amithnair on 1/3/17.
 */
public class DownloadWorkerTest {

    private static final String TEMP_DIR_NAME = "temp-download";
    private static final String DOWNLOAD_URL = "http://httpwg.org/asset/http.svg";
    private String fileName = "http.svg";

    private HttpFile httpFile;
    private File file;
    private String fileDestination;
    private Path tempDirPath;

    @Before
    public void setup() throws IOException {
        tempDirPath = Files.createTempDirectory(TEMP_DIR_NAME);
        fileDestination =  tempDirPath.toAbsolutePath().toString().concat(fileName);
        httpFile = new HttpFile(new URL(DOWNLOAD_URL), fileDestination);
    }


    @Test
    public void shouldBeAbleToDownloadFile() throws IOException, InterruptedException {
        DownloadWorker worker = new DownloadWorker(httpFile, new HttpConnection(httpFile));
        Thread workerThread = new Thread(worker);
        workerThread.start();
        Thread.sleep(5000);
        file = new File(httpFile.getFilePath());
        assertTrue(file.exists());
        assertEquals(2771, httpFile.getDownloadedFileSize());
    }

    @After
    public void tearDown() {
        file.deleteOnExit();
        tempDirPath.toFile().delete();
    }


}
