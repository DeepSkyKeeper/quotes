package syn.lessons.quotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import syn.lessons.quotes.models.Quote;
import syn.lessons.quotes.repository.QuoteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QuoteService {
    @Autowired
    BashParser parser;
    @Autowired
    QuoteRepository repository;

    public List<Quote> getIndex() {
        List<Quote> ret = new ArrayList<>();
        try {
            Map<Integer, String> map = parser.getIndex();
            for (var entry : map.entrySet()) {
                var rawQuote = new Quote();
                rawQuote.setQuoteId(entry.getKey());
                rawQuote.setText(entry.getValue());
                var existed =repository.findByQuoteIdEquals(rawQuote.getQuoteId());
                if (existed.isEmpty())
                    ret.add(repository.save(rawQuote));
                else
                    ret.add(existed.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
