package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class TheDoomer extends Angel {

    public TheDoomer(final LocationHistory locationHistory) {
        super(locationHistory);
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(0);
        pyromancer.setAttacker(null);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), pyromancer, null);
    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        knight.setHp(0);
        knight.setAttacker(null);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), knight, null);
    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        wizard.setHp(0);
        wizard.setAttacker(null);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), wizard, null);
    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        rogue.setHp(0);
        rogue.setAttacker(null);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), rogue, null);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "TheDoomer";
    }
}
