package com.amith.ui;

/**
 * Created by amithnair on 1/5/17.
 */
public class ProgressUpdater {

    private float percentageCompleted;


    public void displayProgress(long downloadedSize, long totalFileSize) {
        updateProgress(downloadedSize, totalFileSize);
        System.out.println("Downloading file..... " + percentageCompleted + "%");
    }

    private void updateProgress(long downloadedSize, long totalFileSize) {
        percentageCompleted = ((float)downloadedSize / (float)totalFileSize) * 100;
    }

}
