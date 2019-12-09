/* Entity Security Role
 * @author Colin Cerveaux @C-ambium
 * Define security roles into the application
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "app_security_role", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "role" }))
public class SecurityRole {

    @Id
    private Integer user_role_id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String role;

    /**
     * @return the user_role_id
     */
    public Integer getUser_role_id() {
        return user_role_id;
    }

    /**
     * @param user_role_id the user_role_id to set
     */
    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
