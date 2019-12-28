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

import fr.dta.ovg.contracts.EntityBaseContract;
import io.swagger.annotations.ApiModelProperty;

/** Entity base class. MAPPED SUPER CLASS */
@MappedSuperclass
public class EntityBase {

    /** Entity Auto-generated ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = EntityBaseContract.COL_ID_API, readOnly = true)
    private Long id;

    /** Entity Enabled boolean option.*/
    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(value = EntityBaseContract.COL_ENABLED_API, readOnly = true)
    @Column(name = EntityBaseContract.COL_ENABLED)
    private boolean enabled = true;

    /** Entity Created Date.*/
    @CreatedDate //  @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = EntityBaseContract.COL_CREATED_AT_API, readOnly = true)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = EntityBaseContract.COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /** Entity Last Updated Date.*/
    @LastModifiedDate//  @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = EntityBaseContract.COL_UPDATED_AT_API, readOnly = true)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = EntityBaseContract.COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    /** CREATION: On DB fixtures load and when event is created.*/
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        updatedAt = now;
        createdAt = now;
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

    /** Getter id.
     * @return the id (long).*/
    public Long getId() {
        return id;
    }

    /** Setter id.
     * @param id the id to set (Long).*/
    public void setId(final Long id) {
        this.id = id;
    }

    /** Getter Function isEnabled.
     * @return boolean : enabled.*/
    public boolean isEnabled() {
        return enabled;
    }

    /** Setter setEnabled.
     * @param enabled : the enabled to set.*/
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /** Getter created date.
     * @return LocalDateTime createdAt.*/
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /** Getter updated date.
     * @return LocalDateTime updatedAt.*/
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
