package com.amith.parser;

import com.amith.exception.MalformedInputException;
import com.amith.model.InputArgument;
import org.junit.*;

import java.io.File;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by amithnair on 1/2/17.
 */
public class CommandLineParserTest {

    private static final String CURRENT_DIRECTORY = new File("").getAbsolutePath();
    private static final String DOWNLOAD_URL = "http://dynamodb-local.s3-website-us-west-2.amazonaws.com/dynamodb_local_2016-05-17.zip";
    private InputArgument inputArgument;

    @Before
    public void setup() throws MalformedInputException {
        String[] args = new String[]{DOWNLOAD_URL, CURRENT_DIRECTORY};
        CommandLineParser commandLineParser = new CommandLineParser();
        inputArgument = commandLineParser.getInputArguments(args);

    }

    @Test
    public void shouldBeAbleToExtractURLFromInput() throws MalformedInputException {
        assertEquals(DOWNLOAD_URL, inputArgument.getUrl());
    }

    @Test
    public void shouldBeAbleToExtractDestinationFilePathFromInput(){
        String fileName = "/dynamodb_local_2016-05-17.zip";
        String expected = new File(CURRENT_DIRECTORY).getAbsolutePath()+ fileName;
        assertEquals(expected,inputArgument.getDestinationFilePath());
    }

    @Test(expected=MalformedInputException.class)
    public void shouldThrowErrorIfInputArgumentsIsNull() throws MalformedInputException {
        CommandLineParser commandLineParser = new CommandLineParser();
        commandLineParser.getInputArguments(null);
    }

    @Test(expected=MalformedInputException.class)
    public void shouldThrowErrorIfIncorrectInputNumberOfArgumentsIsSupplied() throws MalformedInputException {
        CommandLineParser commandLineParser = new CommandLineParser();
        commandLineParser.getInputArguments(new String[]{"wrong_input"});
    }



}
