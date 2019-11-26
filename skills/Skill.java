package skills;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface Skill {
    void visit(Pyromancer pyromancer);
    void visit(Knight knight);
    void visit(Wizard wizard);
    void visit(Rogue rogue);
}
