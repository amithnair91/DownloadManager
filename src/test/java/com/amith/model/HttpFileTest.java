package com.amith.model;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

/**
 * Created by amithnair on 1/2/17.
 */
public class HttpFileTest {

    public static final String TEMP_DIR = "temp";
    public static final String TEMP_FILE = "testFile.zip";
    public static final String DOWNLOAD_URL = "http://dynamodb-local.s3-website-us-west-2.amazonaws.com/dynamodb_local_2016-05-17.zip";
    public static final String RANDOM_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Portenta haec esse dicit, neque ea ratione ullo";


    @Test
    public void shouldBeAbleToGetFileSize() throws IOException {
        File tempFile = File.createTempFile(TEMP_DIR, TEMP_FILE);
        tempFile.deleteOnExit();
        HttpFile httpFile = new HttpFile(new URL(DOWNLOAD_URL), tempFile.getAbsolutePath());

        Files.write(tempFile.toPath(), RANDOM_TEXT.getBytes());

        assertEquals(104, httpFile.getDownloadedFileSize());
    }

    @Test
    public void shouldreturnZeroIfFileDoesNotExist() throws MalformedURLException {
        HttpFile httpFile = new HttpFile(new URL(DOWNLOAD_URL), TEMP_FILE);
        assertEquals(0, httpFile.getDownloadedFileSize());
    }

    @Test
    public void shouldReturnURL() throws MalformedURLException {
        URL url = new URL(DOWNLOAD_URL);
        HttpFile httpFile = new HttpFile(url, TEMP_FILE);

        assertEquals(url,httpFile.getURL());
    }

    @Test
    public void shouldReturnDestinationFilePath() throws MalformedURLException {
        HttpFile httpFile = new HttpFile(null, TEMP_FILE);

        assertEquals(TEMP_FILE,httpFile.getFilePath());
    }

}
