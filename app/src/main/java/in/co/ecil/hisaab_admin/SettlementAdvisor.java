package in.co.ecil.hisaab_admin;

/**
 * Created by Rishav
 * on 19/7/17.
 */

public class SettlementAdvisor
{
    public static void minimalTransaction (float[] balances)
    {
        int maxPositive=0,maxNegative=0;
        int i;
        for (i=0;i<HisaabController.MAX_ROOMMATE_COUNT;i++)
        {
            if (balances[i] == 0.0f) break;

            if (balances[i] > balances[maxPositive]) maxPositive = i;

            if ((balances[i] < 0) && (balances[i] > balances[maxNegative])) maxNegative = i;
        }

        if (i < HisaabController.MAX_ROOMMATE_COUNT)
            System.out.println("Already in 3rd degree");
        else
            System.out.println("Maxpositive = " + maxPositive + " and Maxnegative = " + maxNegative);
    }
}
