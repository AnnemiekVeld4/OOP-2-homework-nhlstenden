public class SpecialQuest extends Quest
{

    private Item rewardItem;

    public SpecialQuest(
            String title,
            int experiencePointReward,
            int difficulty,
            Character enemy,
            Item rewardItem)
    {

        super(title, experiencePointReward, difficulty, enemy);
        this.rewardItem = rewardItem;
    }

    public Item getRewardItem()
    {
        return rewardItem;
    }
}