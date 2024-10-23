package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tiers")
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tiertitle")
    private String tierTitle;
    //Todo : private String description

    @OneToMany(mappedBy = "tier", cascade = CascadeType.ALL)
    @JsonManagedReference  // Utilisé pour la partie "parent"
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "tierlist_id")
    @JsonBackReference  // Utilisé pour la partie "enfant"
    private TierList tierList;

    private Tier(com.takima.backskeleton.models.Tier.Builder builder) {
        this.id = builder.id;
        this.tierTitle = builder.tierTitle;
        this.items = builder.items;
    }
    public Tier() {
    }

    public Tier(Long id, String name,TierList tierList) {
        this.id = id;
        this.tierTitle = name;
        this.tierList = new TierList();
        this.tierList.setId(tierList.getId());
    }

    public String getTierTitle() {
        return tierTitle;
    }

    public TierList getTierList() {
        return tierList;
    }
    public Long getId() {
        return id;
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

