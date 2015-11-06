/**
 * Created by alex7370 on 11/5/2015.
 */
public class Employees {
    private int level;
    private long currentXP;
    private long nextXP;
    public enum TeamType {SDK, DESKTOP, SERVER, IMPLEMENTATION, GEODATA};
    private TeamType EmpType;
    private String name;
    private long currentHP;
    private long maxHP;

    Employees(String Name, long xp, TeamType TypeOfCharacter)
    {
        this.name = Name;
        this.EmpType = TypeOfCharacter;
        this.currentXP = 0;
        this.level = 1;
        this.generateMaxHP();
        this.nextXP = 222;
        this.adjustXP(xp);
        this.currentHP = this.maxHP;
    }

    Employees()
    {
        this("David", 25, TeamType.SDK);
    }

    Employees(String Name)
    {
        this(Name, 25, TeamType.SDK);
    }

    Employees(String Name, long xp)
    {
        this(Name, xp, TeamType.SDK);
    }

    Employees(String Name, TeamType TypeOfCharacter)
    {
        this(Name, 25, TypeOfCharacter);
    }

    public int getLevel()
    {
        return this.level;
    }

    public long getCurrentXP()
    {
        return this.currentXP;
    }

    public void adjustXP(long xp)
    {
        if ((this.currentXP + xp) > this.nextXP)
        {
            if (this.level < 99) {
                this.level++;
                this.generateMaxHP();
            }
            xp -= this.nextXP;
            this.currentXP += this.nextXP;
            this.nextXP += 222*this.level;
            adjustXP(xp);
        }
        else {
            this.currentXP+=xp;
        }
    }

    public TeamType getType()
    {
        return this.EmpType;
    }

    public String getName()
    {
        return this.name;
    }

    public long getMaxHP() {
        return this.maxHP;
    }

    public long getCurrentHP() {
        return this.currentHP;
    }

    private void generateMaxHP() {
        if (this.level == 1)
        {
            this.maxHP = 25;
        }
        else {
            this.maxHP += 2 * this.level;
            this.currentHP += 2*this.level;
        }
    }
}
