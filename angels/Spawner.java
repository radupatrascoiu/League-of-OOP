package angels;

import common.SpawnerConstants;
import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class Spawner extends Angel {

    public Spawner(final LocationHistory locationHistory) {
        super(locationHistory);
        this.abilityToRevive = true;
    }

    /**
     * @param pyromancer
     * @throws IOException
     */
    @Override
    public void visit(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getHp() <= 0) {
            pyromancer.setHp(SpawnerConstants.HP_PYROMANCER);
            pyromancer.setDeathOvertime(false);
            pyromancer.getBuff().setTime(0);
            pyromancer.getBuff().setDamageOverTime(0);
            pyromancer.getStun().setStun(false);
            pyromancer.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), pyromancer, this);
        }
    }

    /**
     * @param knight
     * @throws IOException
     */
    @Override
    public void visit(final Knight knight) throws IOException {
        if (knight.getHp() <= 0) {
            knight.setHp(SpawnerConstants.HP_KNIGHT);
            knight.setDeathOvertime(false);
            knight.getBuff().setTime(0);
            knight.getBuff().setDamageOverTime(0);
            knight.getStun().setStun(false);
            knight.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), knight, this);
        }
    }

    /**
     * @param wizard
     * @throws IOException
     */
    @Override
    public void visit(final Wizard wizard) throws IOException {
        if (wizard.getHp() <= 0) {
            wizard.setHp(SpawnerConstants.HP_WIZARD);
            wizard.setDeathOvertime(false);
            wizard.getBuff().setTime(0);
            wizard.getBuff().setDamageOverTime(0);
            wizard.getStun().setStun(false);
            wizard.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), wizard, this);
        }
    }

    /**
     * @param rogue
     * @throws IOException
     */
    @Override
    public void visit(final Rogue rogue) throws IOException {
        if (rogue.getHp() <= 0) {
            rogue.setHp(SpawnerConstants.HP_ROGUE);
            rogue.setDeathOvertime(false);
            rogue.getBuff().setTime(0);
            rogue.getBuff().setDamageOverTime(0);
            rogue.getStun().setStun(false);
            rogue.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), rogue, this);
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Spawner";
    }
}
