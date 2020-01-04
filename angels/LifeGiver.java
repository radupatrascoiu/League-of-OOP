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

    public LifeGiver(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getHp() + LifeGiverConstants.PYROMANCER_HP >= pyromancer.getMaxHp()) {
            pyromancer.setHp(pyromancer.getMaxHp());
        } else {
            pyromancer.increaseHp(LifeGiverConstants.PYROMANCER_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        if (knight.getHp() + LifeGiverConstants.KNIGHT_HP >= knight.getMaxHp()) {
            knight.setHp(knight.getMaxHp());
        } else {
            knight.increaseHp(LifeGiverConstants.KNIGHT_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        if (wizard.getHp() + LifeGiverConstants.WIZARD_HP >= wizard.getMaxHp()) {
            wizard.setHp(wizard.getMaxHp());
        } else {
            wizard.increaseHp(LifeGiverConstants.WIZARD_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        if (rogue.getHp() + LifeGiverConstants.ROGUE_HP >= rogue.getMaxHp()) {
            rogue.setHp(rogue.getMaxHp());
        } else {
            rogue.increaseHp(LifeGiverConstants.ROGUE_HP);
        }
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "LifeGiver";
    }
}
