package heroes;


import angels.Angel;
import angels.Subjects;
import common.Constants;
import greatmagician.GreatMagician;
import main.LocationHistory;
import skills.Buff;
import skills.Effects;
import skills.Skill;
import skills.Stun;
import strategies.Strategy;

import java.io.IOException;

public abstract class Hero extends Subjects {
    protected int xp;
    protected int level;
    protected int hp;
    protected LocationHistory locationHistory;
    protected int priority;
    protected Effects effects;
    protected int damageReceived;
    protected Hero attacker;
    protected Buff buff;
    protected Stun stun;
    protected boolean deathOvertime;
    protected GreatMagician greatMagician;
    protected int position;
    protected Strategy strategy;
    protected float coefficientsStrategy;
    protected float coefficientsAngels;

    /**
     * @return
     */
    public Hero getAttacker() {
        return attacker;
    }

    /**
     * @param attacker
     */
    public void setAttacker(final Hero attacker) {
        this.attacker = attacker;
    }

    public Hero(final LocationHistory locationHistory) {
        this.xp = Constants.INITIAL_XP;
        this.level = Constants.INITIAL_LEVEL;
        this.locationHistory = locationHistory;
        this.hp = 0;
        this.effects = new Effects();
        this.damageReceived = 0;
        this.buff = new Buff();
        this.stun = new Stun(false, 0);
        this.deathOvertime = false;
        this.greatMagician = GreatMagician.getInstance();
        this.position = -1;
        this.coefficientsStrategy = 0;
        this.coefficientsAngels = 0;
    }

    public final float getCoefficientsStrategy() {
        return coefficientsStrategy;
    }

    public final void setCoefficientsStrategy(final float coefficientsStrategy) {
        this.coefficientsStrategy = coefficientsStrategy;
    }

    public final float getCoefficientsAngels() {
        return coefficientsAngels;
    }

    public final void setCoefficientsAngels(final float coefficientsAngels) {
        this.coefficientsAngels = coefficientsAngels;
    }

    /**
     * @return
     */
    // se verifica daca hero a murit de la damage overtime
    public boolean isDeathOvertime() {
        return deathOvertime;
    }

    /**
     * @param deathOvertime
     */
    public void setDeathOvertime(final boolean deathOvertime) {
        this.deathOvertime = deathOvertime;
    }

    public final void setPosition(final int position) {
        this.position = position;
    }

    public final int getPosition() {
        return position;
    }

    /**
     * @param hp
     */
    public void setHp(final int hp) {
        this.hp = hp;
    }

    /**
     * @return
     */
    public Stun getStun() {
        return stun;
    }

    /**
     * @return
     */
    public Buff getBuff() {
        return buff;
    }

    /**
     * @param damageReceived
     */
    public void setDamageReceived(final int damageReceived) {
        this.damageReceived = damageReceived;
    }

    /**
     * @return
     */
    public Effects getEffects() {
        return effects;
    }

    /**
     * @return
     */
    // prioritatea este folosita pentru a-l forta pe wizard sa atace al doilea
    public int getPriority() {
        return priority;
    }

    public abstract void play(Hero hero);

    /**
     * @return
     */
    public LocationHistory getLocationHistory() {
        return locationHistory;
    }

    /**
     * @param moveChar
     */
    public void move(final char moveChar) {
        if (moveChar == 'L') {
            locationHistory.setY(locationHistory.getY() - 1);
        } else if (moveChar == 'R') {
            locationHistory.setY(locationHistory.getY() + 1);
        } else if (moveChar == 'U') {
            locationHistory.setX(locationHistory.getX() - 1);
        } else if (moveChar == 'D') {
            locationHistory.setX(locationHistory.getX() + 1);
        }
    }

    public abstract float getLandModifier();

    /**
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return
     */
    public int getXp() {
        return xp;
    }

    /**
     * @return
     */
    public abstract int getMaxHp();

    /**
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * @param loser
     */
    public void levelUp(final Hero loser) throws IOException {

        if (this.hp > 0) {
            int aux = 0;
            if (loser != null) {
                this.increaseXp(loser);
            }

            int xpLevelUp = this.getXp() + this.getLevel() * Constants.XP_MULTIPLICATOR;
            if (xpLevelUp > Constants.STANDARD_XP) {
                aux++;
            }

            xpLevelUp -= Constants.STANDARD_XP;
            while (xpLevelUp > 0) {
                xpLevelUp -= Constants.LEVEL_XP;
                aux++;
            }

            if (aux > this.level) {
                System.out.println(aux);
                while (this.level != aux) {
                    this.setLevel(this.level + 1);
                    notifyUpdate(GreatMagician.getHeroLevelUpNotification(), this, null);
                }
                this.level = aux;
                if (this.hp <= 0) {
                    return;
                }

                this.hp = this.getMaxHp();
                this.setDamageReceived(0);
            }
        }
    }

    public final void increaseXp(final int xpReceived) throws IOException {
        if (this.hp > 0) {
            this.xp += xpReceived;
            boolean ok = false;
            int initial = this.getLevel();
            int aux = this.getLevel() - 1;
            while (true) {
                if (this.xp >= (Constants.STANDARD_XP + aux * Constants.LEVEL_XP)) {
                    aux++;
                    setLevel(aux);
                    this.setDamageReceived(0);
                    this.hp = this.getMaxHp();
                    ok = true;
                } else {
                    break;
                }
            }

            if (ok && aux != initial) { // TODO
                notifyUpdate(GreatMagician.getHeroLevelUpNotification(), this, null);
            }

        }
    }

    public final void levelUp() throws IOException {
        int aux = 0;
        while (aux != this.getLevel()) {
            aux++;
        }

        System.out.println(aux);

        this.setXp(Constants.STANDARD_XP + aux * Constants.LEVEL_XP);
        this.setLevel(aux + 1);
        this.hp = this.getMaxHp();
        this.notifyUpdate(GreatMagician.getAngelLevelUpNotification(), this, null);
    }

    /**
     * @param damageReceivedFromAttacker
     * @param hero
     */
    // se calculeaza damage-ul primit intr-o runda, fara overtime
    public void increaseDamage(final int damageReceivedFromAttacker, final Hero hero) {
        if (hero.getHp() < 0 || this.getHp() < 0) {
            return;
        }
        this.setAttacker(hero);
        this.damageReceived += damageReceivedFromAttacker;
    }

    public final void increaseHp(final int hpReceived) {
        this.hp += hpReceived;
    }

    public final void decreaseHp(final int hpReduced) {
        this.hp -= hpReduced;
    }

    /**
     *
     */
    public void calculateHp() throws IOException {
        this.hp -= damageReceived;

        if (this.hp <= 0) {
            notifyUpdate(GreatMagician.getHeroKillNotification(), this, null);
            if (this.getAttacker() != null) {

                if (this.getAttacker().getHp() < 0) {
                    this.setXp(0);
                } else {
                    this.getAttacker().levelUp(this);
                }

                this.setAttacker(null);
            }
        }
    }

    /**
     * @param hero
     */
    public void increaseXp(final Hero hero) {
        // this.hero va fi eroul care va castiga batalia

        this.xp += Math.max(0, Constants.XP_FORMULA_1
                - (this.level - hero.getLevel()) * Constants.XP_FORMULA_2);
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    public abstract void applyStrategy();

    public abstract void accept(Skill skill);

    public abstract void acceptAngel(Angel angel) throws IOException;

    public abstract String displayRace();
}
