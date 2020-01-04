package angels;

import common.XPAngelConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class XPAngel extends Angel {

    public XPAngel(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), pyromancer, this);
        pyromancer.increaseXp(XPAngelConstants.XP_PYROMANCER);
    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), knight, this);
        knight.increaseXp(XPAngelConstants.XP_KNIGHT);

    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), wizard, this);
        wizard.increaseXp(XPAngelConstants.XP_WIZARD);

    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), rogue, this);
        rogue.increaseXp(XPAngelConstants.XP_ROGUE);

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "XPAngel";
    }
}
