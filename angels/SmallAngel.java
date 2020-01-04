package angels;

import common.SmallAngelConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class SmallAngel extends Angel {

    public SmallAngel(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels()
                + SmallAngelConstants.PYROMANCER_COEFFICIENT);
        pyromancer.increaseHp(SmallAngelConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels()
                + SmallAngelConstants.KNIGHT_COEFFICIENT);
        knight.increaseHp(SmallAngelConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels()
                + SmallAngelConstants.WIZARD_COEFFICIENT);
        wizard.increaseHp(SmallAngelConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels()
                + SmallAngelConstants.ROGUE_COEFFICIENT);
        rogue.increaseHp(SmallAngelConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "SmallAngel";
    }
}
