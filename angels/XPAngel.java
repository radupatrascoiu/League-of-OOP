package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class XPAngel extends Angel {

    public XPAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), pyromancer, this);
        pyromancer.increaseXp(50);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), knight, this);
        knight.increaseXp(45);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), wizard, this);
        wizard.increaseXp(60);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        notifyUpdate(GreatMagician.getAngelXpNotification(), rogue, this);
        rogue.increaseXp(40);

    }

    @Override
    public String toString() {
        return "XPAngel";
    }
}
