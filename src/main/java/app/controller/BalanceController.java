package app.controller;

import app.model.Transaction;
import app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alexandru-Adrian Achiritoaei on 19.04.2017.
 */

@RestController
@RequestMapping("/balance/")
public class BalanceController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(method = RequestMethod.GET, params = {"user", "since", "until"})
    public Integer getBalance(@RequestParam(value = "user") Integer user,
                              @RequestParam(value = "since") Integer since,
                              @RequestParam(value = "until") Integer until) {

        List<Transaction> transactions = transactionRepository.findTransactionsByUserAndDateInterval(user, since, until);

        Integer balance = 0;
        for (Transaction t : transactions) {
            // if user is receiver, add to balance else subtract
            int sum = t.getReceiver().equals(user) ? t.getSum() : -t.getSum();
            balance += sum;
        }

        return balance;
    }
}
