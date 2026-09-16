public class Mage extends Character
{

    private static final int DEFENSE_BONUS = 10;

    public Mage(String name, int attackPower, int defensePower)
    {
        super(name, attackPower, defensePower);
    }

    @Override
    public int useSpecialAbility()
    {
        return getDefensePower() + DEFENSE_BONUS;
    }
}