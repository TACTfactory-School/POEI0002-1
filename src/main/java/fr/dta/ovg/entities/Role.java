package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_role")
public class Role extends EntityBase {

    @Column(name = "role", unique = true)
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(int id, String name) {
        super();
        this.name = name;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role [id=" + this.getId() + ", name=" + name + "]";
    }
}
