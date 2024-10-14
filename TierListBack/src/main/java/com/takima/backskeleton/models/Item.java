package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Item")
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "itemTitle")
    private String itemTitle;
    //ToDo : private String lien_Image;

    private Item(com.takima.backskeleton.models.Item.Builder builder) {
        this.id = builder.id;
        this.itemTitle = builder.itemTitle;
    }
    public Item() {
    }

    public static class Builder {
        private Long id;
        private String itemTitle;

        public com.takima.backskeleton.models.Item.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public com.takima.backskeleton.models.Item.Builder itemTitle(String itemTitle) {
            this.itemTitle = itemTitle;
            return this;
        }

        public com.takima.backskeleton.models.Item build() {
            return new com.takima.backskeleton.models.Item(this);
        }
    }
}

