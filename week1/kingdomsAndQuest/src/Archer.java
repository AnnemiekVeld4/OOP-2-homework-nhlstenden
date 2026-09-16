public class Archer extends Character
{

    private static final int DAMAGE_MULTIPLIER = 2;

    public Archer(String name, int attackPower, int defensePower)
    {
        super(name, attackPower, defensePower);
    }

    @Override
    public int useSpecialAbility()
    {
        return getAttackPower() * DAMAGE_MULTIPLIER;
    }
}