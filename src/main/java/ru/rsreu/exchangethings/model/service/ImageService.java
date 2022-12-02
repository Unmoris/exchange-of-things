package ru.rsreu.exchangethings.model.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageService {
    public static ImageService instance = new ImageService();

    private static File directory = new File("D:\\images");

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public String saveIconImage(InputStream inputStreamImage) throws IOException {
        BufferedImage image = ImageIO.read(inputStreamImage);
        image = resizeImage(image, 300,300);
        File fileImage = File.createTempFile("item_", "_icon.jpg",directory);
        ImageIO.write(  image,"JPG",fileImage);
        return fileImage.getName();
    }
}
