package strategies;

import heroes.Hero;

public interface Strategy {
    void execute(Hero hero, float hp, float coefficients);
}
