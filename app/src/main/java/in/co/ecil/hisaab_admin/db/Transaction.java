package in.co.ecil.hisaab_admin.db;

/**
 * Created by Rishav
 * on 28/7/17.
 */

public class Transaction
{
    private String transactionId; //transaction-id is timestamp, formatted string YYYYMMDD
    private String payer; //We expect party's name in string here rather than an enum
    private String amount;
    private String item;
    private TransactionType type;
    private String timestamp; // Internal variable set automatically to transaction-Id,
                              // Transaction.getTimestamp() makes more sense than Transaction.getTransactionId()
                              // for getting time of occurrence


    public Transaction(String transactionId, String payer, String amount, String item, TransactionType type, String timestamp)
    {
        this.transactionId = transactionId;
        this.payer = payer;
        this.amount = amount;
        this.item = item;
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
        this.timestamp = transactionId; //no public setter for timestamp to preventing un-equal values of
                                        // transaction-id and timestamp
    }

    public String getPayer()
    {
        return payer;
    }

    public void setPayer(String payer)
    {
        this.payer = payer;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public TransactionType getType()
    {
        return type;
    }

    public void setType(TransactionType type)
    {
        this.type = type;
    }
}
