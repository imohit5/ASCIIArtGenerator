package com.ascii.art.service.impl;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.ascii.art.service.ASCIIArtService;

@Service("ASCIIArtService")
public class ASCIIArtServiceImpl implements ASCIIArtService {

	@Override
	public String[][] generateASCIIArt(String string, String print) throws IOException {

    Font font = new Font("SansSerif", Font.BOLD, 24);
    
    
    BufferedImage checkSize = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Graphics gSize = checkSize.getGraphics();
    gSize.setFont(font);
    
    FontMetrics metrics = gSize.getFontMetrics(font);
    int height = metrics.getHeight();
    System.out.println(height);
    int width = metrics.stringWidth(string);
    System.out.println(width);
    

	
    

    BufferedImage image = new BufferedImage(width+2, height+2, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setFont(font);
    
    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.drawString(string, 0, 25);


    String[][] myArray = new String[height][width];

    for (int y = 0; y < height; y++) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < width; x++) {

            String str = image.getRGB(x, y) == -16777216 ? " " : print;
			sb.append(str);
			myArray[y][x]=str;

        }

        if (sb.toString().trim().isEmpty()) {
            continue;
        }

        //System.out.println(sb);
    }
    
//    	System.out.println(Arrays.deepToString(myArray).replace("], ", "\n").replace("[[", "").replace("]]", "").replace("[", "").replace(",",""));
    
	return myArray;

}

}
