public class Quest
{

    private String title;
    private int xp;
    private int difficulty;
    private Character enemy;

    public Quest(
            String title,
            int experiencePointReward,
            int difficulty,
            Character enemy)
    {

        this.title = title;
        this.xp = experiencePointReward;
        this.difficulty = difficulty;
        this.enemy = enemy;
    }

    public int getRequiredExperiencePoints()
    {
        return difficulty * 10;
    }

    public boolean isPlayableBy(Character character)
    {
        return character.getXp() >= getRequiredExperiencePoints();
    }

    public void completeQuest(Character character)
    {
        if (isPlayableBy(character))
        {
            character.addXp(xp);
        }
    }

    public String getTitle()
    {
        return title;
    }

    public int getXp()
    {
        return xp;
    }

    public int getDifficulty()
    {
        return difficulty;
    }

    public Character getEnemy()
    {
        return enemy;
    }
}