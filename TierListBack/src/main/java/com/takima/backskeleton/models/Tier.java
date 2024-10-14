package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "Tier")
@Getter
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tierTitle")
    private String tierTitle;
    @OneToMany
    @JoinTable(
            name = "tier_item",
            joinColumns = @JoinColumn(name = "tier_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private Tier(com.takima.backskeleton.models.Tier.Builder builder) {
        this.id = builder.id;
        this.tierTitle = builder.tierTitle;
        this.items = builder.items;
    }
    public Tier() {
    }

    public static class Builder {
        private Long id;
        private String tierTitle;
        private List<Item> items;

        public com.takima.backskeleton.models.Tier.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.Tier.Builder tierTitle(String tierTitle) {
            this.tierTitle = tierTitle;
            return this;
        }

        public com.takima.backskeleton.models.Tier.Builder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public com.takima.backskeleton.models.Tier build() {
            return new com.takima.backskeleton.models.Tier(this);
        }
    }
}

