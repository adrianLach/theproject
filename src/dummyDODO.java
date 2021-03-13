import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class dummyDODO {
    
    public static void main(String[] args) {
        
        String url = "D:\\development\\workspace\\TheProject\\src\\rcs\\512";
        String url2 = "D:\\development\\workspace\\TheProject\\src\\rcs\\p32";
        
        File dir = new File(url);
        
        File[] files = dir.listFiles();
        
        for (File file : files) {
            System.out.println(file.getName());
            
            BufferedImage bi = null;
            try {
                bi = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            BufferedImage scaled = scale(bi, 32);
            
            try {
                ImageIO.write(scaled, "png", new File(url2 + "\\" + file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    private static BufferedImage scale(BufferedImage src, int size) {
        try {
            return resizeImage(src, size, size);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
            throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
    
}
