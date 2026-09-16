import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest
{

    @Test
    void newCharacterShouldStartAtLevelOne()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);

        assertEquals(1, warrior.getLevel());
    }

    @Test
    void newCharacterShouldStartWithZeroXp()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);

        assertEquals(0, warrior.getXp());
    }

    @Test
    void addExperiencePointsShouldIncreaseXp()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);

        warrior.addXp(100);

        assertEquals(100, warrior.getXp());
    }

    @Test
    void characterShouldNotLevelUpWithLessThanTwoHundredXp()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);
        warrior.addXp(199);

        assertFalse(warrior.isAbleToLevelUp());
    }

    @Test
    void characterShouldBeAbleToLevelUpWithTwoHundredXp()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);
        warrior.addXp(200);

        assertTrue(warrior.isAbleToLevelUp());
    }

    @Test
    void levelUpShouldIncreaseLevel()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);
        warrior.addXp(200);

        warrior.levelUp();

        assertEquals(2, warrior.getLevel());
    }

    @Test
    void levelUpShouldSubtractTwoHundredXp()
    {
        Warrior warrior = new Warrior("Thor", 30, 20);
        warrior.addXp(250);

        warrior.levelUp();

        assertEquals(50, warrior.getXp());
    }
}
