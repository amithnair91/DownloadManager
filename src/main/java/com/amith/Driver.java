package com.amith;

import com.amith.download.DownloadManager;
import com.amith.exception.MalformedInputException;
import com.amith.model.HttpFile;
import com.amith.model.InputArgument;
import com.amith.parser.CommandLineParser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by amithnair on 1/5/17.
 */
public class Driver {

    public static void main(String[] args) {
        CommandLineParser commandLineParser = new CommandLineParser();
        try {
            InputArgument inputArguments = commandLineParser.getInputArguments(args);
            HttpFile httpFile = new HttpFile(new URL(inputArguments.getUrl()), inputArguments.getDestinationFilePath());
            DownloadManager downloadManager = new DownloadManager(httpFile);
            downloadManager.startDownload();
        } catch (MalformedInputException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
