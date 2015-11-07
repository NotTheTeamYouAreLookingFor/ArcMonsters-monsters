import java.util.List;

/**
 * Created by alexandernohe on 11/7/15.
 */
public class Player {
    private List<Employees> activeTeam;
    private int maxActiveTeamSize;
    private String name;
    private Backpack backpack; //This will be used to hold all the items and the custom behavior of the backpack.
    private long cash;
    private List<Employees> reserveTeam; //This is like the computer in the game that stores monsters not in use.

    public String getName()
    {
       return this.name;
    }

    public void setName(String Name)
    {
        this.name = Name;
    }

    public long getCash()
    {
        return this.cash;
    }

    public void adjustCash(long Cash)
    {
        if (Cash < 0)
        {
            if ((-Cash) > this.cash)
            {
                // Need to throw an exception or handle this where the cash is not modified and the
                // transaction does not occur since the amount of cash difference is greater than the
                // amount of cash that the player currently has.
            }
            else
            {
                this.cash += Cash;
            }
        }
        else
        {
            this.cash += Cash;
        }

    }

    public void getActiveTeamMembers()
    {
        //Not yet implemented
    }

    public void swapActiveTeamMembers()
    {
        //Not yet implemented
    }
}
