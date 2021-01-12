package it.academy.picture;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PrintPicture {

    public BufferedImage getPictureForInputNumberOfVisits(int numberOfVisits){

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif", Font.ITALIC, 200));
        graphics2D.setColor(Color.white);
        graphics2D.drawString(String.valueOf(numberOfVisits), 25, 175);

        return image;
    }
}
