package space.nixus.maddoc.rooms;

import space.nixus.maddoc.Game;
import space.nixus.maddoc.Player;
import space.nixus.maddoc.Room;
import space.nixus.maddoc.items.BasementKey;
import space.nixus.maddoc.items.LightSwitch;
import space.nixus.maddoc.items.SeveredHead;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Kitchen extends Room implements Serializable {

    public static final String NAME = "kitchen";
    private static final List<String> LINKS = Arrays.asList(LivingRoom.NAME);

    public Kitchen() {
        super();
        inventory.init(new LightSwitch(false), new SeveredHead(), new BasementKey());
    }
    @Override
    public boolean isLit() {
        return inventory.getItem(LightSwitch.NAME).hasFlags("on");
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public List<String> getLinks() {
        return LINKS;
    }

    @Override
    public void describe() {
        Game.fmt("The kitchen.");
        if(isLit()) {
            Game.fmt("A standard kitchen on the older side. All the surfaces are\n" +
                    "filthy, the oven and fridge doors are left open and the\n" +
                    "kitchen sink is full of reddish water.");
        }
        else {
            Game.fmt("It is too dark here.");
        }
        Game.fmt("You can go back to the [%s].", LivingRoom.NAME);
        inventory.describe();
    }

    @Override
    public boolean movingTo(Player p) {
        return true;
    }
}
