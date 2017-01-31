/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
package day3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Thomas
 */
public class NewClass {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    BufferedImage inputImage = ImageIO.read(new File("C:/Users/Thomas/Desktop/ie.png"));
    
     BufferedImage outputImage = new BufferedImage(inputImage.getWidth() * 10,  10*inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    
    for(int y = 0; y < outputImage.getHeight();  y++)
        {
            for(int x = 0; x < outputImage.getWidth(); x++)
            {
                float x_old = x/10;
                float y_old = y/10;
                
                int pixelFirst = inputImage.getRGB((int)x_old, (int)y_old );
                int pixelSecond =  inputImage.getRGB(
                        Math.min((int)x_old + 1, inputImage.getWidth() - 1), 
                       (int)y_old  );
                
                Color cFirst = new Color(pixelFirst);
                Color cSecond = new Color(pixelSecond);
                
                float iValue = (float)x/10.0f -  (int)(x/10);
                
                int iRed = (int) ((1 - iValue) * cFirst.getRed() + iValue * cSecond.getRed());
                int iGreen = (int) ((1 - iValue) * cFirst.getGreen() + iValue * cSecond.getGreen());
                int iBlue = (int) ((1 - iValue) * cFirst.getBlue() + iValue * cSecond.getBlue());
                
                Color iColor = new Color(iRed, iGreen, iBlue);
                
                int iPixel = iColor.getRGB();
                
                
                
                
                outputImage.setRGB(x, y, iPixel);
        }
    }
     ImageIO.write(outputImage, "PNG", new File("c:/Users/Thomas/Desktop/NewPhoto1.png") );
    }
    
}
