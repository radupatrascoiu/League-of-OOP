package angels;

import common.DraculaConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class Dracula extends Angel {

    public Dracula(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels()
                - DraculaConstants.PYROMANCER_COEFFICIENT);
        pyromancer.decreaseHp(DraculaConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);
        if (pyromancer.getHp() <= 0) {
            notifyUpdate(GreatMagician.getAngelKillNotification(), pyromancer, this);
        }

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels()
                - DraculaConstants.KNIGHT_COEFFICIENT);
        knight.decreaseHp(DraculaConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);
        if (knight.getHp() <= 0) {
            notifyUpdate(GreatMagician.getAngelKillNotification(), knight, this);
        }
    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels()
                - DraculaConstants.WIZARD_COEFFICIENT);
        wizard.decreaseHp(DraculaConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);
        if (wizard.getHp() <= 0) {
            notifyUpdate(GreatMagician.getAngelKillNotification(), wizard, this);
        }

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels()
                - DraculaConstants.ROGUE_COEFFICIENT);
        rogue.decreaseHp(DraculaConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);
        if (rogue.getHp() <= 0) {
            notifyUpdate(GreatMagician.getAngelKillNotification(), rogue, this);
        }

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Dracula";
    }
}
