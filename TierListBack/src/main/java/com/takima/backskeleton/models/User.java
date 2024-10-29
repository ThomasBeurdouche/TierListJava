package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "mail")
    private String mail;
    @Column(name = "mdp")
    private String mdp;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<TierList> tierLists;

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.mail = builder.mail;
        this.mdp = builder.mdp;
        this.tierLists = builder.tierLists;
    }
    public User() {
    }
    public User(Long id, String username, String mail, String mdp, List<TierList> tierLists) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.mdp = mdp;
        this.tierLists = tierLists;
    }

    public static class Builder {
        private Long id;
        private String username;
        private String mail;
        private String mdp;
        private List<TierList> tierLists;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }
        public Builder mdp(String mdp) {
            this.mdp = mdp;
            return this;
        }
        public Builder tierLists(List<TierList> tierLists) {
            this.tierLists = tierLists;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }
    public String getMail() {
        return mail;
    }
    public String getUsername() {
        return username;
    }
    public String getMdp() {
        return mdp;
    }
    public List<TierList> getTierLists() {
        return tierLists;
    }
}

