package com.amith.ui;

import java.math.BigDecimal;

/**
 * Created by amithnair on 1/5/17.
 */
public class ProgressUpdater {

    private float _percentageCompleted;


    public void displayProgress(long downloadedSize, long totalFileSize) {
        updateProgress(downloadedSize, totalFileSize);
        System.out.println("Downloading file..... " + _percentageCompleted + "%");
    }

    private void updateProgress(long downloadedSize, long totalFileSize) {
        float percentage = ((float) downloadedSize / (float) totalFileSize) * 100;
        _percentageCompleted = roundOff(percentage, 2);
    }

    private float roundOff(float percentage, int decimalPlace) {
        BigDecimal decimal = new BigDecimal(Float.toString(percentage));
        decimal = decimal.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return decimal.floatValue();
    }

}
