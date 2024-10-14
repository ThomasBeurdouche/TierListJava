package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "TierList")
@Getter
public class TierList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tierListTitle")
    private String tierListTitle;
    private Instant creationDate;
    @OneToMany
    @JoinTable(
            name = "tierList_tier",
            joinColumns = @JoinColumn(name = "tierList_id"),
            inverseJoinColumns = @JoinColumn(name = "tier_id"))
    private List<Tier> tiers;
    @ManyToOne
    @Column(name = "owner")
    private User owner;

    private TierList(com.takima.backskeleton.models.TierList.Builder builder) {
        this.id = builder.id;
        this.tierListTitle = builder.tierListTitle;
        this.creationDate = builder.creationDate;
        this.owner = builder.owner;
        this.tiers = builder.tiers;
    }
    public TierList() {
    }

    public static class Builder {
        private Long id;
        private String tierListTitle;
        private User owner;
        private Instant creationDate;
        private List<Tier> tiers;

        public com.takima.backskeleton.models.TierList.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.TierList.Builder tierListTitle(String tierListTitle) {
            this.tierListTitle = tierListTitle;
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

