package com.ovg.app.aexamples.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "app_pokemon_species")
public class PokemonSpecies extends EntityBase {
    @Column(length = 100, nullable = false, unique = true)
    @NotBlank
    private String name;

    @Min(1)
    private int pv;

    @Column(name = "att", nullable = false)
    @Min(1)
    private int attack;

    @Column(name = "att_spe", nullable = false)
    @Min(1)
    private int attackSpe;

    @Column(name = "def", nullable = false)
    @Min(1)
    private int defense;

    @Column(name = "def_spe", nullable = false)
    @Min(1)
    private int defenseSpe;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pv
     */
    public int getPv() {
        return pv;
    }

    /**
     * @param pv the pv to set
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * @return the attackSpe
     */
    public int getAttackSpe() {
        return attackSpe;
    }

    /**
     * @param attackSpe the attackSpe to set
     */
    public void setAttackSpe(int attackSpe) {
        this.attackSpe = attackSpe;
    }

    /**
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * @return the defenseSpe
     */
    public int getDefenseSpe() {
        return defenseSpe;
    }

    /**
     * @param defenseSpe the defenseSpe to set
     */
    public void setDefenseSpe(int defenseSpe) {
        this.defenseSpe = defenseSpe;
    }
}
