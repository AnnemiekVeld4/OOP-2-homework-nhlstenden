public class Warrior extends Character
{

    private static final int ATTACK_BONUS = 10;

    public Warrior(String name, int attackPower, int defensePower)
    {
        super(name, attackPower, defensePower);
    }

    @Override
    public int useSpecialAbility()
    {
        return getAttackPower() + ATTACK_BONUS;
    }
}