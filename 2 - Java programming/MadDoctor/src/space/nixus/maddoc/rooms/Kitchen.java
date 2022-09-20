package space.nixus.maddoc.rooms;

import space.nixus.maddoc.Player;
import space.nixus.maddoc.Room;
import space.nixus.maddoc.items.LightSwitch;
import space.nixus.maddoc.items.SeveredHead;

public class Kitchen extends Room {

    public static final String NAME = "kitchen";
    private static final String[] LINKS = { "entry-hall" };

    public Kitchen() {
        super();
        inventory.init(new LightSwitch(false), new SeveredHead());
    }
    @Override
    public boolean isLit() {
        return true;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getLinks() {
        return LINKS;
    }

    @Override
    public void describe() {
        //TODO: Implement
    }

    @Override
    public boolean movingTo(Player p) {
        return true;
    }

    @Override
    public boolean locked() {
        return false;
    }
}