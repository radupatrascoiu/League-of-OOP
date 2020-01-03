package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class Dracula extends Angel {

    public Dracula(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels() - 0.3f);
        pyromancer.decreaseHp(40);
        notifyUpdate(GreatMagician.getAngelHitNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels() - 0.2f);
        knight.decreaseHp(60);
        notifyUpdate(GreatMagician.getAngelHitNotification(), knight, this);
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels() - 0.4f);
        wizard.decreaseHp(20);
        notifyUpdate(GreatMagician.getAngelHitNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels() - 0.1f);
        rogue.decreaseHp(35);
        notifyUpdate(GreatMagician.getAngelHitNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "Dracula";
    }
}
