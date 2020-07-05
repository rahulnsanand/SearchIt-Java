package com.searchit.tfg.TESTING;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RetrieveMapsAPI {

    private static String API_KEY = "AIzaSyC-BH_ZRhd4idviLzTVae13oHpFtoXfAHU";
    private static String defaultURL = "https://maps.googleapis.com/maps/api/staticmap?";
    private static String outputFile = "src\\main\\resources\\image.jpg";

    public static ImageIcon getMapImage(String latitude, String longitude){
        String updatedURL = defaultURL+"center="+latitude+","+longitude+"&markers=size:mid%7color:red|"+latitude+","+longitude+"&zoom=15&size=400x400&key="+API_KEY;
        InputStream is = null;
        try {
            URL url = new URL(updatedURL);
            is = url.openStream();
            OutputStream os = new FileOutputStream(outputFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ImageIcon((new ImageIcon(outputFile))
                .getImage().getScaledInstance(630, 600,
                        java.awt.Image.SCALE_SMOOTH));
    }

    public static void clearImage(){
        try {
            Files.delete(Paths.get(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
