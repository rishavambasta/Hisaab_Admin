package in.co.ecil.hisaab_admin.db;

/**
 * Created by Rishav
 * on 28/7/17.
 */

public class TransactionMember
{
    private String transactionId; //foreign-key Transaction.transactionId
    private String payee;

    public TransactionMember(String transactionId, String payee)
    {
        this.transactionId = transactionId;
        this.payee = payee;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public String getPayee()
    {
        return payee;
    }

    public void setPayee(String payee)
    {
        this.payee = payee;
    }
}
