package strategies;

import heroes.Hero;

public class DefensiveStrategy implements Strategy {
    /**
     * @param hero
     * @param hp
     * @param coefficients
     */
    @Override
    public void execute(final Hero hero, final float hp, final float coefficients) {
        System.out.println(hero + " alege strategia defensiva");
        hero.setHp((int) (hero.getHp() + hero.getHp() / hp));
        hero.setCoefficientsStrategy(hero.getCoefficientsStrategy() - coefficients);
    }
}
