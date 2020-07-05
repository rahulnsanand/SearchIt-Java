package com.searchit.tfg.TESTING;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThumbnailRetrieve {
    private static String outputFile = "src\\main\\resources\\ThumbImage.jpg";
    private static String backUP = "src\\main\\resources\\noThumb.png";

    public static ImageIcon getThumbImage(String thumbUrl){
        InputStream is = null;
        OutputStream os = null;
        try {
            URL url = new URL(thumbUrl);
            is = url.openStream();
            os = new FileOutputStream(outputFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        }
        catch (MalformedURLException malformedURLException){
            clearThumbImage();
            return new ImageIcon(backUP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon(outputFile);
    }

    public static void clearThumbImage(){

        try {
            Files.delete(Paths.get(outputFile));
        } catch (IOException e) {
            return;
        }

    }


}
