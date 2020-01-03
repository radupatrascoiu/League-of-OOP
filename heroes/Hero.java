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

    public float getCoefficientsStrategy() {
        return coefficientsStrategy;
    }

    public void setCoefficientsStrategy(float coefficientsStrategy) {
        this.coefficientsStrategy = coefficientsStrategy;
    }

    public float getCoefficientsAngels() {
        return coefficientsAngels;
    }

    public void setCoefficientsAngels(float coefficientsAngels) {
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

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
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
    public void levelUp(final Hero loser) {

        if (this.getHp() > 0) {
            if(loser != null) {
                this.increaseXp(loser);
            }

            int xpLevelUp = this.getXp() + this.getLevel() * Constants.XP_MULTIPLICATOR;

            if (xpLevelUp >= Constants.XP_LEVEL_1) {
                this.setDamageReceived(0);
                setLevel(Constants.LEVEL_1);
                if (this.hp <= 0) {
                    return;
                }
                this.hp = this.getMaxHp();

            }

            if (xpLevelUp >= Constants.XP_LEVEL_2) {
                this.setDamageReceived(0);

                setLevel(Constants.LEVEL_2);
                if (this.hp <= 0) {
                    return;
                }
                this.hp = this.getMaxHp();

            }

            if (xpLevelUp >= Constants.XP_LEVEL_3) {
                this.setDamageReceived(0);

                setLevel(Constants.LEVEL_3);
                if (this.hp <= 0) {
                    return;
                }
                this.hp = this.getMaxHp();

            }

            if (xpLevelUp >= Constants.XP_LEVEL_4) {
                this.setDamageReceived(0);

                setLevel(Constants.LEVEL_4);
                if (this.hp <= 0) {
                    return;
                }
                this.hp = this.getMaxHp();
            }
        }
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

    public void increaseHp(final int hpReceived) {
        this.hp += hpReceived;
    }

    public void decreaseHp(final int hpReduced) {
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
                this.getAttacker().levelUp(this);
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

    public void increaseXp(int xpReceived) {
        this.xp += xpReceived;
        this.levelUp(null);
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void levelUp() throws IOException {
        if(this.getLevel() == Constants.LEVEL_0) {
            this.setXp(Constants.XP_LEVEL_1);
            this.setLevel(Constants.LEVEL_1);
            this.hp = this.getMaxHp();
        } else if(this.getLevel() == Constants.LEVEL_1) {
            this.setXp(Constants.XP_LEVEL_2);
            this.setLevel(Constants.LEVEL_2);
            this.hp = this.getMaxHp();
        } else if(this.getLevel() == Constants.LEVEL_2) {
            this.setXp(Constants.XP_LEVEL_3);
            this.setLevel(Constants.XP_LEVEL_3);
            this.hp = this.getMaxHp();
        } else if(this.getLevel() == Constants.LEVEL_3) {
            this.setXp(Constants.XP_LEVEL_4);
            this.setLevel(Constants.LEVEL_4);
            this.hp = this.getMaxHp();
        }

        this.notifyUpdate(GreatMagician.getLevelUpNotification(), this, null);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public abstract void applyStrategy();

    public abstract void accept(Skill skill);

    public abstract void acceptAngel(Angel angel) throws IOException;

    public abstract String displayRace();
}
