package com.amith.ui;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by amithnair on 1/5/17.
 */
public class ProgressUpdaterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void shouldDisplayProgressOnConsole() throws InterruptedException {
        ProgressUpdater progressUpdater = new ProgressUpdater();
        progressUpdater.displayProgress(10, 100);
        String expected = "Downloading file..... " + 10.0 + "%";
        assertEquals(expected,outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
