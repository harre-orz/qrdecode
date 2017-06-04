package qrdecode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.common.HybridBinarizer;

public class App 
{
    public static void main(String[] args) throws IOException, NotFoundException
    {
        String result = "";
    	for(String path : args) {
            BufferedImage image = ImageReader.readImage(new File(path).toURI());
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            result += new MultiFormatReader().decode(bitmap).getText();
    	}
        System.out.println(result);
    }
}
