package strategies;

import heroes.Hero;

public class DefensiveStrategy implements Strategy {
    @Override
    public void execute(Hero hero, float hp, float coefficients) {
        System.out.println(hero + " alege strategia defensiva");
        hero.setHp((int) (hero.getHp() + hero.getHp()/hp));
        hero.setCoefficientsStrategy(hero.getCoefficientsStrategy() - coefficients);
    }
}
