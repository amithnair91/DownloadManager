package com.amith.parser;

import com.amith.exception.MalformedInputException;
import com.amith.model.HttpFile;
import com.amith.model.InputArgument;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by amithnair on 1/2/17.
 */
public class CommandLineParser {

    public static final String EXCEPTION_MESSAGE = "Invalid input!!! please specify the input in the format: <url> <location>";

    public InputArgument getInputArguments(String[] args) throws MalformedInputException {
        if (args != null && args.length == 2 && args[0] != null && args[1] != null) {
            String url = args[0];
            String directoryPath = args[1];
            String filePath = extractFilePath(url, directoryPath);
            return new InputArgument(url, filePath);
        } else {
            throw new MalformedInputException(EXCEPTION_MESSAGE);
        }
    }

    private String extractFilePath(String url, String directoryPath) {
        String fileName = url.substring(url.lastIndexOf("/"));
        if (new File(directoryPath).isDirectory()) {
            return new File(directoryPath, fileName).getAbsolutePath();
        }else{
            return new File(directoryPath).getAbsolutePath();
        }
    }
}