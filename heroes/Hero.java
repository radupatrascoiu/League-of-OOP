package heroes;


import common.Constants;
import main.LocationHistory;
import skills.Buff;
import skills.Effects;
import skills.Skill;
import skills.Stun;

public abstract class Hero {
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
        effects = new Effects();
        this.damageReceived = 0;
        buff = new Buff();
        stun = new Stun(false, 0);
        deathOvertime = false;
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
            this.increaseXp(loser);

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
    /**
     *
     */
    public void calculateHp() {
        this.hp -= damageReceived;

        if (this.hp <= 0) {
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

    public abstract void accept(Skill skill);

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Hero{"
                + "xp=" + xp
                + ", level=" + level
                + ", locationHistory=" + locationHistory
                + '}';
    }

    public abstract String displayRace();
}
