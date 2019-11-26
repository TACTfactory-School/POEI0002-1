package com.ovg.app.aexamples.hibernate.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean enabled = false;

    protected EntityBase() {
        super();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

//    /**
//     * @return the createdAt
//     */
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    /**
//     * @param createdAt the createdAt to set
//     */
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
