package angels;

import greatmagician.GreatMagician;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import main.LocationHistory;

import java.io.IOException;

public class Spawner extends Angel {

    public Spawner(LocationHistory locationHistory) {
        super(locationHistory);
        this.abilityToRevive = true;
    }

    @Override
    public void visit(Pyromancer pyromancer) throws IOException {
        if(pyromancer.getHp() <= 0) {
            pyromancer.setHp(150);
            pyromancer.setDeathOvertime(false);
            pyromancer.getBuff().setTime(0);
            pyromancer.getBuff().setDamageOverTime(0);
            pyromancer.getStun().setStun(false);
            pyromancer.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), pyromancer, this);
        }
    }

    @Override
    public void visit(Knight knight) throws IOException {
        if(knight.getHp() <= 0) {
            knight.setHp(200);
            knight.setDeathOvertime(false);
            knight.getBuff().setTime(0);
            knight.getBuff().setDamageOverTime(0);
            knight.getStun().setStun(false);
            knight.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), knight, this);
        }
    }

    @Override
    public void visit(Wizard wizard) throws IOException {
        if(wizard.getHp() <= 0) {
            wizard.setHp(120);
            wizard.setDeathOvertime(false);
            wizard.getBuff().setTime(0);
            wizard.getBuff().setDamageOverTime(0);
            wizard.getStun().setStun(false);
            wizard.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), wizard, this);
        }
    }

    @Override
    public void visit(Rogue rogue) throws IOException {
        if(rogue.getHp() <= 0) {
            rogue.setHp(180);
            rogue.setDeathOvertime(false);
            rogue.getBuff().setTime(0);
            rogue.getBuff().setDamageOverTime(0);
            rogue.getStun().setStun(false);
            rogue.getStun().setTime(0);
            notifyUpdate(GreatMagician.getAngelReviveNotification(), rogue, this);
        }
    }

    @Override
    public String toString() {
        return "Spawner";
    }
}
