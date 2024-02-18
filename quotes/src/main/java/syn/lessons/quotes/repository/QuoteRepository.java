package syn.lessons.quotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syn.lessons.quotes.models.Quote;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote,Integer> {

    Optional<Quote> findByQuoteIdEquals(Integer quoteId);
}
