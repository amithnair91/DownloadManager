package com.amith.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by amithnair on 1/2/17.
 */
public class InputArgumentTest {

    private static final String FILE_DESTINATION = "test.txt";
    private static final String DOWNLOAD_URL = "http://dynamodb-local.s3-website-us-west-2.amazonaws.com/dynamodb_local_2016-05-17.zip";
    private InputArgument inputArgument;


    @Before
    public void setup() {
        inputArgument = new InputArgument(DOWNLOAD_URL, FILE_DESTINATION);
    }


    @Test
    public void shouldBeAbleToGetURL() {
        assertEquals(DOWNLOAD_URL, inputArgument.getUrl());
    }

    @Test
    public void shouldBeAbleToGetDestinationFilePath() {
        assertEquals(FILE_DESTINATION, inputArgument.getDestinationFilePath());
    }

}
