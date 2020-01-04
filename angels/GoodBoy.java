package angels;

import common.GoodBoyConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class GoodBoy extends Angel {

    public GoodBoy(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels()
                + GoodBoyConstants.PYROMANCER_COEFFICIENT);
        pyromancer.increaseHp(GoodBoyConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels()
                + GoodBoyConstants.KNIGHT_COEFFICIENT);
        knight.increaseHp(GoodBoyConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels()
                + GoodBoyConstants.WIZARD_COEFFICIENT);
        wizard.increaseHp(GoodBoyConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels()
                + GoodBoyConstants.ROGUE_COEFFICIENT);
        rogue.increaseHp(GoodBoyConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "GoodBoy";
    }
}
