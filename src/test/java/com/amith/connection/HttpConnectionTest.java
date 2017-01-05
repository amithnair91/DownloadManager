package com.amith.connection;

import com.amith.model.HttpFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by amithnair on 1/2/17.
 */
public class HttpConnectionTest {

    private static final String FILE_DESTINATION = "http.svg";
    private static final String DOWNLOAD_URL = "http://httpwg.org/asset/http.svg";

    HttpFile _httpFile;

    @Before
    public void setup() throws MalformedURLException {
        _httpFile = new HttpFile(new URL(DOWNLOAD_URL),FILE_DESTINATION);
    }

    @Test
    public void shouldBeAbleToGetContentLength() throws IOException {
        HttpConnection httpConnection = new HttpConnection(_httpFile);

        assertEquals(2771,httpConnection.getContentLength());
    }

    @Test
    public void shouldBeAbleToGetHttpContentAsInputStream() throws IOException {
        HttpConnection httpConnection = new HttpConnection(_httpFile);
        assertTrue(httpConnection.getInputStream() instanceof InputStream);
    }

}
