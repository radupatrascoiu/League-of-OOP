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

    public Hero getAttacker() {
        return attacker;
    }

    public void setAttacker(Hero attacker) {
        this.attacker = attacker;
    }

    public Hero(LocationHistory locationHistory) {
        this.xp = Constants.INITIAL_XP;
        this.level = Constants.INITIAL_LEVEL;
        this.locationHistory = locationHistory;
        this.hp = 0;
        this.priority = 100;
        effects = new Effects();
        this.damageReceived = 0;
        buff = new Buff();
        stun = new Stun(false, 0);
        deathOvertime = false;
    }

    public boolean isDeathOvertime() {
        return deathOvertime;
    }

    public void setDeathOvertime(boolean deathOvertime) {
        this.deathOvertime = deathOvertime;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Stun getStun() {
        return stun;
    }

    public Buff getBuff() {
        return buff;
    }

    public int getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
    }

    public Effects getEffects() {
        return effects;
    }

    public int getPriority() {
        return priority;
    }

    public abstract void play(Hero hero); // fac actiunea specifica jucatorului; imi dau seama ce visitor sa apelez

    public LocationHistory getLocationHistory() {
        return locationHistory;
    }

    public void setLocationHistory(LocationHistory locationHistory) {
        this.locationHistory = locationHistory;
    }

    public void move(char moveChar) {
        if(moveChar == 'L') {
            locationHistory.setY(locationHistory.getY()-1);
        } else if(moveChar == 'R') {
            locationHistory.setY(locationHistory.getY()+1);
        } else if(moveChar == 'U') {
            locationHistory.setX(locationHistory.getX()-1);
        } else if(moveChar == 'D') {
            locationHistory.setX(locationHistory.getX()+1);
        }
    }

    public abstract float getLandModifier();

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxHp() {
        return 0;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp(Hero loser) {

        this.increaseXp(loser);

//        int xpLevelUp = Constants.XP + super.getLevel() * Constants.XP_MULTIPLICATOR;

        int xpLevelUp = this.getXp() + this.getLevel() * Constants.XP_MULTIPLICATOR;
        System.out.println("XP = " + xpLevelUp);

        if(xpLevelUp >= Constants.XP_LEVEL_1) {
            setLevel(1);
            if(this.hp <= 0) {
                return;
            }
            this.hp = this.getMaxHp();

        }

        if(xpLevelUp >= Constants.XP_LEVEL_2) {
            setLevel(2);
            if(this.hp <= 0) {
                return;
            }
            this.hp = this.getMaxHp();

        }

        if(xpLevelUp >= Constants.XP_LEVEL_3) {
            setLevel(3);
            if(this.hp <= 0) {
                return;
            }
            this.hp = this.getMaxHp();

        }

        if(xpLevelUp >= Constants.XP_LEVEL_4) {
            setLevel(4);
            if(this.hp <= 0) {
                return;
            }
            this.hp = this.getMaxHp();
        }

        System.out.println("level actual = " + getLevel());

    }

    public abstract void increaseDamage(int damageReceived, Hero hero);

    public void calculateHp() {
        this.hp -= damageReceived;
        if(this.hp <= 0) {
            System.out.println("Creste XP");
            if(this.getAttacker() != null) {
                this.getAttacker().levelUp(this);
                this.setAttacker(null);
            }

        }
    }

    public void increaseXp(Hero hero) {
        // this.hero va fi eroul care va castiga batalia
        this.xp += Math.max(0, Constants.XP_FORMULA_1 -
                (this.level - hero.getLevel()) * Constants.XP_FORMULA_2);
    }

    public abstract void accept(Skill skill);

    @Override
    public String toString() {
        return "Hero{" +
                "xp=" + xp +
                ", level=" + level +
                ", locationHistory=" + locationHistory +
                '}';
    }

    public abstract String displayRace();
}
