package angels;

import common.DarkAngelConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class DarkAngel extends Angel {

    public DarkAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.decreaseHp(DarkAngelConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.decreaseHp(DarkAngelConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.decreaseHp(DarkAngelConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.decreaseHp(DarkAngelConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "DarkAngel";
    }
}
