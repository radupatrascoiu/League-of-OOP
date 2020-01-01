package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

public class XPAngel extends Angel {

    public XPAngel(LocationHistory locationHistory) {
        super(locationHistory);
    }

    @Override
    public void visit(Pyromancer pyromancer) {

    }

    @Override
    public void visit(Knight knight) {

    }

    @Override
    public void visit(Wizard wizard) {

    }

    @Override
    public void visit(Rogue rogue) {

    }

    @Override
    public String toString() {
        return "XPAngel";
    }
}
