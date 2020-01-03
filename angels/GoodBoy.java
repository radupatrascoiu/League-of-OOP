package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class GoodBoy extends Angel {

    public GoodBoy(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels() + 0.5f);
        pyromancer.increaseHp(30);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels() + 0.4f);
        knight.increaseHp(20);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);

    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels() + 0.3f);
        wizard.increaseHp(50);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels() + 0.4f);
        rogue.increaseHp(40);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "GoodBoy";
    }
}
