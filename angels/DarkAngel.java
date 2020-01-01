package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class DarkAngel extends Angel {

    public DarkAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "DarkAngel";
    }
}
