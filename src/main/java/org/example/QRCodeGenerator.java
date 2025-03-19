package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class QRCodeGenerator {

    public static void main(String[] args) {
        // The data that you want to encode into a QR Code
        String data = "https://www.linkedin.com/in/ruichao-guan/";
        // Path to save the QR Code image
        String filePath = "QRCode.png";
        // Width and Height for the QR code image
        int width = 300;
        int height = 300;

        try {
            // Generate the QR code
            generateQRCode(data, filePath, width, height);
            System.out.println("QR Code Generated Successfully!");
        } catch (Exception e) {
            System.out.println("Error while generating QR Code: " + e.getMessage());
        }
    }

    // Method to generate the QR code
    public static void generateQRCode(String data, String filePath, int width, int height) throws Exception {
        // Set QR code encoding hints (such as error correction level)
        Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hintMap.put(EncodeHintType.MARGIN, 1); // Set the margin

        // Create a BitMatrix (QR code)
        BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hintMap);

        // Write the BitMatrix to an image file
        File file = new File(filePath);
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", file);
    }
}
