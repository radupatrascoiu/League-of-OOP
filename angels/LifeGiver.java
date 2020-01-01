package angels;

import common.LifeGiverConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class LifeGiver extends Angel {

    public LifeGiver(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.increaseHp(LifeGiverConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.increaseHp(LifeGiverConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.increaseHp(LifeGiverConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.increaseHp(LifeGiverConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "LifeGiver";
    }
}
