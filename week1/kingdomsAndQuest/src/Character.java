public abstract class Character
{

    private String name;
    private int attackPower;
    private int defensePower;
    private int xp;
    private int level;

    public Character(String name, int attackPower, int defensePower)
    {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.xp = 0;
        this.level = 1;
    }

    public int attack()
    {
        return attackPower;
    }

    public int defend()
    {
        return defensePower;
    }

    public abstract int useSpecialAbility();

    public void addXp(int xp)
    {
        if (xp > 0)
        {
            this.xp += xp;
        }
    }

    public boolean isAbleToLevelUp()
    {
        return xp >= 200;
    }

    public void levelUp()
    {
        if (isAbleToLevelUp())
        {
            level++;
            xp -= 200;
        }
    }

    public String getName()
    {
        return name;
    }

    public int getAttackPower()
    {
        return attackPower;
    }

    public int getDefensePower()
    {
        return defensePower;
    }

    public int getXp()
    {
        return xp;
    }

    public int getLevel()
    {
        return level;
    }

    protected void setAttackPower(int attackPower)
    {
        this.attackPower = attackPower;
    }

    protected void setDefensePower(int defensePower)
    {
        this.defensePower = defensePower;
    }
}