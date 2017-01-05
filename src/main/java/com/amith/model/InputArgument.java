package com.amith.model;

/**
 * Created by amithnair on 1/2/17.
 */
public class InputArgument {

    private String _url;
    private String _destinationFilePath;

    public InputArgument(String url, String destinationFilePath) {
        _url = url;
        _destinationFilePath = destinationFilePath;
    }

    public String getUrl() {
        return _url;
    }

    public String getDestinationFilePath() {
        return _destinationFilePath;
    }
}
