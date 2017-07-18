package in.co.ecil.hisaab_admin;

/**
 * Created by Rishav
 * on 18/7/17.
 */

public class Roommate
{
    private String name;
    private float balance;
    private String avatarUri;

    public Roommate(String name, float balance, String avatarUri)
    {
        this.name = name;
        this.balance = balance;
        this.avatarUri = avatarUri;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getBalance()
    {
        return balance;
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    public String getAvatarUri()
    {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri)
    {
        this.avatarUri = avatarUri;
    }
}
