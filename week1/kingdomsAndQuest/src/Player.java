import java.util.ArrayList;
import java.util.List;

public class Player
{

    private String name;
    private Character character;
    private List<Item> items;

    public Player(String name, Character character)
    {
        this.name = name;
        this.character = character;
        this.items = new ArrayList<>();
    }

    public void playQuest(Quest quest)
    {
        if (!quest.isPlayableBy(character))
        {
            return;
        }

        quest.completeQuest(character);

        if (quest instanceof SpecialQuest)
        {
            SpecialQuest specialQuest = (SpecialQuest) quest;
            addItem(specialQuest.getRewardItem());
        }
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public String getName()
    {
        return name;
    }

    public Character getCharacter()
    {
        return character;
    }

    public List<Item> getItems()
    {
        return items;
    }
}