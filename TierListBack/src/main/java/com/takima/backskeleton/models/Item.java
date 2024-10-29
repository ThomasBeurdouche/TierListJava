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
    @Column(name = "itemURL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    @JsonBackReference  // Utilisé pour la partie "enfant"
    private Tier tier;

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }



    private Item(com.takima.backskeleton.models.Item.Builder builder) {
        this.id = builder.id;
        this.url = builder.url;
    }
    public Item() {
    }

    public static class Builder {
        private Long id;
        private String url;

        public com.takima.backskeleton.models.Item.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.Item.Builder itemTitle(String itemTitle) {
            this.url = url;
            return this;
        }

        public com.takima.backskeleton.models.Item build() {
            return new com.takima.backskeleton.models.Item(this);
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
}

