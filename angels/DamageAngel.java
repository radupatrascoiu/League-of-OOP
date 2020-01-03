package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class DamageAngel extends Angel {


    public DamageAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        pyromancer.setCoefficientsAngels(pyromancer.getCoefficientsAngels() + 0.2f);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), pyromancer, this);

    }

    @Override
    public void visit(Knight knight) throws IOException {
        knight.setCoefficientsAngels(knight.getCoefficientsAngels() + 0.15f);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), knight, this);
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        wizard.setCoefficientsAngels(wizard.getCoefficientsAngels() + 0.4f);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), wizard, this);

    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        rogue.setCoefficientsAngels(rogue.getCoefficientsAngels() + 0.3f);
        notifyUpdate(GreatMagician.getAngelHelpNotification(), rogue, this);

    }

    @Override
    public String toString() {
        return "DamageAngel";
    }
}
