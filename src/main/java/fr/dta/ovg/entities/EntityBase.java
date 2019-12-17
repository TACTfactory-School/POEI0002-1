/* Entity base class.
 * @author Colin Cerveaux @C-ambium.
 * Shared attributes between entity.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

/** Entity base class. MAPPED SUPER CLASS */
@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The generated database ID", readOnly = true)
    private Long id;

    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(value = "Specifies if the entity if enabled or not", readOnly = true)
    private boolean enabled = true;

    @CreatedDate //  @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "The generated date of creation", readOnly = true)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "created", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate//  @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "The updated date of entity", readOnly = true)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "updated", nullable = false)
    private LocalDateTime updatedAt;

    /** CREATION: On DB fixtures load and when event is created.*/
    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = LocalDateTime.now();
        }

    /** UPDATE: On DB fixtures load and when event is updated. */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        }


    /** Constructor of Entity base.*/
    protected EntityBase() {
        super();
    }

    /**
     * Getter id.
     * @return the id (long).
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id.
     * @param id the id to set (Long).
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Getter Function isEnabled.
     * @return boolean : enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Setter setEnabled.
     * @param boolean enabled : the enabled to set.
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Getter created date.
     * @return LocalDateTime createdAt.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter updated date.
     * @return LocalDateTime updatedAt.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
