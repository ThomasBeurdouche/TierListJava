package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "tier", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Utilisé pour la partie "parent"
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "tierlist_id")
    @JsonBackReference  // Utilisé pour la partie "enfant"
    private TierList tierList;

    private Tier(Builder builder) {
        this.id = builder.id;
        this.tierTitle = builder.tierTitle;
        this.items = builder.items;
    }
    public Tier() {
    }
    public Tier(Long id, String name,TierList tierList) {
        this.id = id;
        this.tierTitle = name;
        this.tierList = tierList;
    }

    public void setTierTitle(String tierTitle) {
        this.tierTitle = tierTitle;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTierList(TierList tierList) {
        this.tierList = tierList;
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

        public Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Builder tierTitle(String tierTitle) {
            this.tierTitle = tierTitle;
            return this;
        }
        public Builder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public Tier build() {
            return new Tier(this);
        }
    }


}

