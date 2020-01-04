package strategies;

import heroes.Hero;

public class OffensiveStrategy implements Strategy {
    @Override
    public void execute(Hero hero, float hp, float coefficients) {
        System.out.println(hero + " alege strategia ofensiva");
        hero.setHp((int) (hero.getHp() - hero.getHp() / hp));
        hero.setCoefficientsStrategy(hero.getCoefficientsStrategy() + coefficients);
    }
}
