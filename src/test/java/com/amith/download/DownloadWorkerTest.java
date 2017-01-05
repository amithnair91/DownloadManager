package com.amith.download;

import com.amith.connection.HttpConnection;
import com.amith.model.HttpFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by amithnair on 1/3/17.
 */
public class DownloadWorkerTest {

    private static final String FILE_DESTINATION = "/Users/amithnair/Documents/test_download/image.png";
    private static final String DOWNLOAD_URL = "http://httpwg.org/asset/http.svg";

    private HttpFile httpFile;
    private File file;

    @Before
    public void setup() throws MalformedURLException {
        httpFile = new HttpFile(new URL(DOWNLOAD_URL), FILE_DESTINATION);
    }


    @Test
    public void shouldBeAbleToDownloadFile() throws IOException, InterruptedException {
        DownloadWorker worker = new DownloadWorker(httpFile, new HttpConnection(httpFile));
        Thread workerThread = new Thread(worker);
        workerThread.start();
        Thread.sleep(3000);
        file = new File(httpFile.getFilePath());
        assertTrue(file.exists());
    }

    @After
    public void tearDown() {
        file.deleteOnExit();
    }


}
