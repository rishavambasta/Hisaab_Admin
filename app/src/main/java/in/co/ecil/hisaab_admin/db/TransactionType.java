package in.co.ecil.hisaab_admin.db;

/**
 * Created by Rishav
 * on 28/7/17.
 */

public enum TransactionType
{

    SETTLEMENT  //One-to-One txn which results in zero balance of either or both parties
            {
                @Override
                public String toString()
                { return type_settlement;}
            },


    CREDIT      //One-to-One txn which results in non-zero balances of both parties
            {
                @Override
                public String toString()
                { return type_credit;}
            },


    EXPENSE     //One-to-Many Transaction
            {
                @Override
                public String toString()
                { return type_expense;}
            };


    private static final String type_settlement = "SETTLEMENT";
    private static final String type_credit = "CREDIT";
    private static final String type_expense = "EXPENSE";


    public TransactionType parseTransactionType (String transactionTypeString)
    {
        switch (transactionTypeString)
        {
            case type_settlement:return SETTLEMENT;
            case type_credit:return CREDIT;
            case type_expense:return EXPENSE;
            default:throw new IllegalArgumentException("Not a valid transaction type: "+transactionTypeString);
        }
    }

}
