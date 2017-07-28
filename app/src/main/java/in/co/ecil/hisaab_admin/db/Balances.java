package in.co.ecil.hisaab_admin.db;

import in.co.ecil.hisaab_admin.HisaabController;

/**
 * Created by Rishav
 * on 28/7/17.
 */

public final class Balances
{
    private String transactionId;
    private float balance[] = new float[HisaabController.MAX_ROOMMATE_COUNT];

    public Balances(String transactionId, float[] balance)
    {
        this.transactionId = transactionId;
        this.balance = balance;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public float[] getBalance()
    {
        return balance;
    }

    public void setBalance(float[] balance)
    {
        this.balance = balance;
    }
}
