package angels;


import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public abstract class Angel extends Subjects {
    protected LocationHistory locationHistory;
    protected boolean abilityToRevive;

    public Angel(final LocationHistory locationHistory) {
        this.locationHistory = locationHistory;
        this.abilityToRevive = false;
    }

    public final LocationHistory getLocationHistory() {
        return locationHistory;
    }

    public final boolean isAbilityToRevive() {
        return abilityToRevive;
    }

    public abstract void visit(Pyromancer pyromancer) throws IOException;
    public abstract void visit(Knight knight) throws IOException;
    public abstract void visit(Wizard wizard) throws IOException;
    public abstract void visit(Rogue rogue) throws IOException;

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Angel{"
                + "locationHistory=" + locationHistory
                + ", abilityToRevive=" + abilityToRevive
                + '}';
    }
}
