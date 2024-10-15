package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "TierLists")
@Getter
public class TierList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tierListTitle")
    private String tierListTitle;
    @Column(name = "publicTierList")
    private boolean publicTierList;
    @Column(name = "Vote pour")
    private Integer votePour;
    @Column(name = "Vote contre")
    private Integer voteContre;
    @Column(name = "Date")
    private Instant creationDate;
    @OneToMany
    @JoinTable(
            name = "tierList_tier",
            joinColumns = @JoinColumn(name = "tierList_id"),
            inverseJoinColumns = @JoinColumn(name = "tier_id"))
    private List<Tier> tiers;
    @ManyToOne
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

