package com.skills;

import com.heroes.*;

public interface Skill {
    void visit(Pyromancer pyromancer);
    void visit(Knight knight);
    void visit(Wizard wizard);
    void visit(Rogue rogue);
}
