package syn.lessons.quotes.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class BashParser {
    public Map<Integer,String> getIndex() throws IOException {
        Document doc = Jsoup.connect("http://ibash.org.ru/").get();
        Map<Integer, String> quotes = new HashMap<>();
        Elements sourceQuotes = doc.select(".quote");
        for (Element quoteElement : sourceQuotes) {
            int id = (Integer.parseInt(quoteElement.select("b").first().text().substring(1)));
//            System.out.println(id);
            String text = quoteElement.select(".quotbody").first().text();
//            System.out.println(text);
            quotes.put(id, text);
        }
        return quotes;
    }
}
