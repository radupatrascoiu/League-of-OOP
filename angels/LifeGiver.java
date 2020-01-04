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
        if(pyromancer.getHp() + LifeGiverConstants.PYROMANCER_HP >= pyromancer.getMaxHp()) {
            pyromancer.setHp(pyromancer.getMaxHp());
        } else {
            pyromancer.increaseHp(LifeGiverConstants.PYROMANCER_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        if(knight.getHp() + LifeGiverConstants.KNIGHT_HP >= knight.getMaxHp()) {
            knight.setHp(knight.getMaxHp());
        } else {
            knight.increaseHp(LifeGiverConstants.KNIGHT_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if(wizard.getHp() + LifeGiverConstants.WIZARD_HP >= wizard.getMaxHp()) {
            wizard.setHp(wizard.getMaxHp());
        } else {
            wizard.increaseHp(LifeGiverConstants.WIZARD_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if(rogue.getHp() + LifeGiverConstants.ROGUE_HP >= rogue.getMaxHp()) {
            rogue.setHp(rogue.getMaxHp());
        } else {
            rogue.increaseHp(LifeGiverConstants.ROGUE_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "LifeGiver";
    }
}
