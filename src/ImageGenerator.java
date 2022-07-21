import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageGenerator {
    public void generate(InputStream inputStream, String fileName) {
        try {
            var newFileName = fileName.replace(":", "");
            
            //Get Image
            //InputStream inputStream = new FileInputStream(new File("assets/images/TheShawshankRedemption.jpg"));
            //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
            BufferedImage movieCoverImage = ImageIO.read(inputStream);

            //Create new image in memory with transparency and new size
            int width = movieCoverImage.getWidth();
            int height = movieCoverImage.getHeight();
            int newHeight = height + 200;
            BufferedImage newMovieCoverImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

            //Copy original image to new image (in memory)
            Graphics2D graphics = (Graphics2D) newMovieCoverImage.getGraphics();
            graphics.drawImage(movieCoverImage, 0, 0, null);

            //Font configuration
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
            graphics.setColor(Color.YELLOW);
            graphics.setFont(font);

            //Write an phrase on new image
            int textAlign = (width / 2) - 150;
            graphics.drawString("TOPZERA", textAlign, newHeight - 100);

            ImageIO.write(newMovieCoverImage, "png", new File("assets/images/" + newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
