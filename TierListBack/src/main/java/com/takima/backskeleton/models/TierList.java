package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tierlists")
public class TierList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tierlisttitle")
    private String tierListTitle;
    @Column(name = "publictierlist")
    private boolean publicTierList;
    @Column(name = "votepour")
    private Integer votePour;
    @Column(name = "votecontre")
    private Integer voteContre;
    @Column(name = "creationdate")
    private Instant creationDate;

    @OneToMany(mappedBy = "tierList", cascade = CascadeType.ALL)
    @JsonManagedReference  // Utilisé pour la partie "parent"
    private List<Tier> tiers;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference  // Utilisé pour la partie "enfant"
    private User owner;

    private TierList(com.takima.backskeleton.models.TierList.Builder builder) {
        this.id = builder.id;
        this.tierListTitle = builder.tierListTitle;
        this.publicTierList = builder.publicTierList;
        this.votePour = builder.votePour;
        this.voteContre = builder.voteContre;
        this.creationDate = builder.creationDate;
        this.tiers = builder.tiers;
        this.owner = builder.owner;
    }
    public TierList() {
    }

    public Integer getVotePour() {
        return votePour;
    }
    public Integer getVoteContre() {
        return voteContre;
    }
    public Instant getCreationDate() {
        return creationDate;
    }
    public List<Tier> getTiers() {
        return tiers;
    }
    public User getOwner() {
        return owner;
    }
    public Long getId() {
        return id;
    }
    public String getTierListTitle() {
        return tierListTitle;
    }
    public boolean isPublicTierList() {
        return publicTierList;
    }

    public void setId(Long tierListId) {
        this.id = tierListId;
    }

    public static class Builder {
        private Long id;
        private String tierListTitle;
        private boolean publicTierList;
        private Integer votePour;
        private Integer voteContre;
        private Instant creationDate;
        private List<Tier> tiers;
        private User owner;


        public com.takima.backskeleton.models.TierList.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder tierListTitle(String tierListTitle) {
            this.tierListTitle = tierListTitle;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder publicTierList(boolean publicTierList) {
            this.publicTierList = publicTierList;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder votePour(Integer votePour) {
            this.votePour = votePour;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder voteContre(Integer voteContre) {
            this.voteContre = voteContre;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder tiers(List<Tier> tiers) {
            this.tiers = tiers;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public com.takima.backskeleton.models.TierList build() {
            return new com.takima.backskeleton.models.TierList(this);
        }



    }

}

