package app.repository;

import app.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Alexandru-Adrian Achiritoaei on 19.04.2017.
 */
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    @Query ("{'$and' : [" +
                "{'$or' : [{'sender' : ?0}, {'receiver' : ?0}]}," +
                "{'timestamp' : {$gte : ?1, $lte : ?2}}," +
                "{'sum' : {$gte : ?3}}" +
            "]}")
    List <Transaction> findSuspiciousTransactions(Integer user, Integer startDate, Integer endDate, Integer threshold);

    @Query ("{'$and' : [" +
                "{'$or' : [{'sender' : ?0}, {'receiver' : ?0}]}," +
                "{'timestamp' : {$gte : ?1, $lte : ?2}}" +
            "]}")
    List <Transaction> findTransactionsByUserAndDateInterval(Integer user, Integer startDate, Integer endDate);

}
