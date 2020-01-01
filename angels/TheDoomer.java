package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class TheDoomer extends Angel {

    public TheDoomer(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(0);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), pyromancer, null);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.setHp(0);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), knight, null);
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.setHp(0);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), wizard, null);
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.setHp(0);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);
        notifyUpdate(GreatMagician.getAngelKillNotification(), rogue, null);
    }

    @Override
    public String toString() {
        return "TheDoomer";
    }
}
