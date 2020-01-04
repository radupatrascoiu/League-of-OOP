package angels;

import common.LevelUpAngelConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.levelUp();
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels()
                + LevelUpAngelConstants.PYROMANCER_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelLevelUpNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.levelUp();
        knight.setCoefficientsAngels(knight.getCoefficientsAngels()
                + LevelUpAngelConstants.KNIGHT_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelLevelUpNotification(), knight, this);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.levelUp();
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels()
                + LevelUpAngelConstants.WIZARD_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelLevelUpNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.levelUp();
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels()
                + LevelUpAngelConstants.ROGUE_COEFFICIENT);
        notifyUpdate(GreatMagician.getAngelLevelUpNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "LevelUpAngel";
    }
}
