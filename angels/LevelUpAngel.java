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
        pyromancer.levelUp();
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels() + 0.2f);
        notifyUpdate(GreatMagician.getLevelUpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.levelUp();
        knight.setCoefficientsAngels(knight.getCoefficientsAngels() + 0.1f);
        notifyUpdate(GreatMagician.getLevelUpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.levelUp();
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels() + 0.25f);
        notifyUpdate(GreatMagician.getLevelUpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.levelUp();
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels() + 0.15f);
        notifyUpdate(GreatMagician.getLevelUpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
