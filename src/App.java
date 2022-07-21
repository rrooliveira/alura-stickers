import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //Get Movies Imdb
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        ContentExtractor extractor = new ImdbContentExtractor();

        // Get Nasa Images
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        //ContentExtractor extractor = new NasaContentExtractor();

        var clientHttp = new ClientHttp();
        String json = clientHttp.getData(url);

        List<Content> contents = extractor.extractContent(json);

        var generator = new ImageGenerator();
        for (int i = 0; i < 3; i++) {
            Content content = contents.get(i);
            String fileName = content.getTitle() + ".png";

            InputStream inputStream = new URL(content.getUrlImage()).openStream();   
            generator.generate(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
