package angels;

import common.DamageAngelConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class DamageAngel extends Angel {


    public DamageAngel(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels()
                + DamageAngelConstants.PYROMANCER_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels()
                + DamageAngelConstants.KNIGHT_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);
    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels()
                + DamageAngelConstants.WIZARD_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels()
                + DamageAngelConstants.ROGUE_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "DamageAngel";
    }
}
