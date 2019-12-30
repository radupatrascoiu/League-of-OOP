package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

public abstract class Angel {
    protected LocationHistory locationHistory;

    public abstract void visit(Pyromancer pyromancer);
    public abstract void visit(Knight knight);
    public abstract void visit(Wizard wizard);
    public abstract void visit(Rogue rogue);
}
