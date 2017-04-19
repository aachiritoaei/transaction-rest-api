package app.controller;

import app.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.repository.TransactionRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexandru-Adrian Achiritoaei on 19.04.2017.
 */

@RestController
@RequestMapping("/transactions/")
public class TransactionController {

    private final static Integer DAY_IN_SEC = 86_400;

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createTransaction(@RequestBody Map<String, Object> transactionMap) {
        Transaction transaction = new Transaction(
                Integer.parseInt(transactionMap.get("sender").toString()),
                Integer.parseInt(transactionMap.get("receiver").toString()),
                Integer.parseInt(transactionMap.get("timestamp").toString()),
                Integer.parseInt(transactionMap.get("sum").toString()));

        transactionRepository.save(transaction);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Transaction created successfully");
        response.put("transaction", transaction);

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAll")
    public Map<String, Object> deleteAllTransactions() {
        transactionRepository.deleteAll();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All transactions deleted successfully");
        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,
            params = {"user", "day", "threshold"})
    public List<Transaction> getSuspiciousTransactions(@RequestParam(value = "user") Integer user,
                                                       @RequestParam(value = "day") Integer day,
                                                       @RequestParam(value = "threshold") Integer threshold) {

        return transactionRepository.findSuspiciousTransactions(user, day, day + DAY_IN_SEC, threshold);
    }
}
