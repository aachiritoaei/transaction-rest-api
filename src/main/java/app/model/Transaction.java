package app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Alexandru-Adrian Achiritoaei on 19.04.2017.
 */

@Document(collection = "transaction")
public class Transaction {

    @Id
    private String id;
    private Integer sender;
    private Integer receiver;

    @Indexed
    private Integer timestamp;
    private Integer sum;

    public Transaction() {}

    public Transaction(Integer sender, Integer receiver, Integer timestamp, Integer sum) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
