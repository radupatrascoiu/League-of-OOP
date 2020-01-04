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

    public DarkAngel(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.decreaseHp(DarkAngelConstants.PYROMANCER_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);

    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.decreaseHp(DarkAngelConstants.KNIGHT_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.decreaseHp(DarkAngelConstants.WIZARD_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.decreaseHp(DarkAngelConstants.ROGUE_HP);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "DarkAngel";
    }
}
