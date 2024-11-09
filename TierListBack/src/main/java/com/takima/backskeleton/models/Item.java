package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "items")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "itemurl")
    private String url;
    @Column(name = "itemtitle")
    private String itemTitle;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    @JsonBackReference  // Utilisé pour la partie "enfant"
    private Tier tier;

    public Item(Long id, String itemTitle, String url, Tier tier) {
        this.id = id;
        this.itemTitle = itemTitle;
        this.url = url;
        this.tier = tier;
    }



    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    private Item(Builder builder) {
        this.id = builder.id;
        this.url = builder.url;
        this.itemTitle = builder.itemTitle;
        this.tier = tier;
    }
    public Item() {
    }

    public static class Builder {
        public String itemTitle;
        private Long id;
        private String url;
        private Tier tier;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder itemTitle(String itemTitle) {
            this.itemTitle = itemTitle;
            return this;
        }

        public Builder tier(Tier tier) {this.tier = tier;return this;}

        public Item build() {
            return new Item(this);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}

