package com.orm.emrpatientservice.data.entity.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orm.emrpatientservice.data.entity.BaseEntity;
import com.orm.emrpatientservice.data.entity.Patient;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Entry extends BaseEntity {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private Patient patient;
    private LocalDateTime time;
    private String official;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
