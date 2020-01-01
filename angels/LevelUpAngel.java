package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        System.out.println("da");
        pyromancer.levelUp();
        notifyUpdate(GreatMagician.getLevelUpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        notifyUpdate(GreatMagician.getLevelUpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        notifyUpdate(GreatMagician.getLevelUpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        notifyUpdate(GreatMagician.getLevelUpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
