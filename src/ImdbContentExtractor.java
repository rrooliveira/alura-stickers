import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor {
    
    public List<Content> extractContent(String json) {
        
        JsonParser parser = new JsonParser();
        List<Map<String, String>> AttributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attributes : AttributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            Content content = new Content(title, urlImage);
            contents.add(content);
        }

        return contents;
    }
}
