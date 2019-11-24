package com.skills;

import com.heroes.*;
import com.skills.KnightSkills.Execute;
import com.skills.KnightSkills.Slam;
import com.skills.PyromancerSkills.Fireblast;
import com.skills.PyromancerSkills.Ignite;
import com.skills.RogueSkills.Backstab;
import com.skills.RogueSkills.Paralysis;
import com.skills.WizardSkills.Deflect;
import com.skills.WizardSkills.Drain;

public class SkillFactory {
    private SkillFactory() {}

    public static Skill getHero(String skillType) {
        if(skillType == null) {
            return null;
        }

        if(skillType.equalsIgnoreCase("Execute")) {
            return new Execute();
        } else if(skillType.equalsIgnoreCase("Slam")) {
            return new Slam();
        } else if(skillType.equalsIgnoreCase("Fireblast")) {
            return new Fireblast();
        } else if(skillType.equalsIgnoreCase("Ignite")) {
            return new Ignite();
        } else if(skillType.equalsIgnoreCase("Backstab")) {
            return new Backstab();
        } else if(skillType.equalsIgnoreCase("Paralysis")) {
            return new Paralysis();
        } else if(skillType.equalsIgnoreCase("Deflect")) {
            return new Deflect();
        } else if(skillType.equalsIgnoreCase("Drain")) {
            return new Drain();
        }

        return null;
    }
}
