package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonManagedReference  // Utilisé pour la partie "parent"
    private List<TierList> tierLists;

    private User(com.takima.backskeleton.models.User.Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.mail = builder.mail;
        this.mdp = builder.mdp;
    }
    public User() {
    }

    public static class Builder {
        private Long id;
        private String username;
        private String mail;
        private String mdp;

        public com.takima.backskeleton.models.User.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public com.takima.backskeleton.models.User.Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public com.takima.backskeleton.models.User.Builder mdp(String mdp) {
            this.mdp = mdp;
            return this;
        }

        public com.takima.backskeleton.models.User build() {
            return new com.takima.backskeleton.models.User(this);
        }
    }
}

