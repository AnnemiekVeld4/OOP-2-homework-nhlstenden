import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest
{

    @Test
    void useSpecialAbilityShouldIncreaseAttackPower()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);

        int specialAttackPower = warrior.useSpecialAbility();

        assertEquals(40, specialAttackPower);
    }

    @Test
    void attackShouldReturnNormalAttackPower()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);

        assertEquals(30, warrior.attack());
    }
}
