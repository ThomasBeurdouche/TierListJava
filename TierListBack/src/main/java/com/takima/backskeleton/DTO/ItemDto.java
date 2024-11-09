package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Item;
import com.takima.backskeleton.models.Tier;

public class ItemDto {
    private Long id;
    private String url;
    private String itemTitle;
    private Tier tier;

    public ItemDto() {
    }

    // Constructeur avec paramètres
    public ItemDto(Long id,String itemTitle,String url, Tier tier) {
        this.id = id;
        this.url = url;
        this.itemTitle = itemTitle;
        this.tier = tier;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Méthode pour convertir un Item en ItemDto
    public static ItemDto fromItem(Item item) {
        if (item == null) {
            return null;
        }
        return new ItemDto(item.getId(), item.getItemTitle() ,item.getUrl(), item.getTier());
    }

    // Méthode pour convertir un ItemDto en Item
    public static Item toItem(ItemDto itemDTO) {
        if (itemDTO == null) {
            return null;
        }
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setUrl(itemDTO.getUrl());
        item.setItemTitle(itemDTO.getItemTitle());
        item.setTier(itemDTO.getTier());
        return item;
    }
}
