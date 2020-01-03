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
        pyromancer.increaseXp(50);
        notifyUpdate(GreatMagician.getAngelXpNotification(), pyromancer, this);
    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.increaseXp(45);
        notifyUpdate(GreatMagician.getAngelXpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.increaseXp(60);
        notifyUpdate(GreatMagician.getAngelXpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.increaseXp(40);
        notifyUpdate(GreatMagician.getAngelXpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "XPAngel";
    }
}
