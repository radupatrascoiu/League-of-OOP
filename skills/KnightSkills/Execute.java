package skills.KnightSkills;


import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import skills.Skill;

public class Execute implements Skill {
    private int baseDamage;
    private int baseDamagePerLevel;
    //TODO HP LIMIT?????

    private Knight knight;

    public Execute(Knight knight) {
        this.knight = knight;
        this.baseDamagePerLevel = Constants.EXECUTE_BASE_DAMAGE_PER_LEVEL *
                this.knight.getLevel();
        this.baseDamage = Constants.EXECUTE_BASE_DAMAGE +
                this.baseDamagePerLevel;

    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseDamagePerLevel() {
        return baseDamagePerLevel;
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        // trebuie sa fac cumva sa vad cat e damage ul cu Race !!! --> poate sa schimb in int
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_PYROMANCER_MODIFIER);

    }

    @Override
    public void visit(Knight knight) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_KNIGHT_MODIFIER);
        System.out.println("Execute Damage total dat = " + totalDamage);
        knight.increaseDamage(totalDamage);
    }

    @Override
    public void visit(Wizard wizard) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_WIZARD_MODIFIER);
    }

    @Override
    public void visit(Rogue rogue) {
        int levelLandDamage = Math.round(this.baseDamage *
                this.knight.getLandModifier());
        int totalDamage = Math.round(levelLandDamage *
                Constants.EXECUTE_VS_ROGUE_MODIFIER);
    }

    @Override
    public String toString() {
        return "Execute";
    }
}
