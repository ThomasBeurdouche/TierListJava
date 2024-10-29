package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Item;

public class ItemDto {
    private Long id;
    private String url;
    // Vous pouvez également inclure d'autres propriétés si nécessaire
    // par exemple, les propriétés liées à Tier, si besoin.

    // Constructeur par défaut
    public ItemDto() {
    }

    // Constructeur avec paramètres
    public ItemDto(Long id, String url) {
        this.id = id;
        this.url = url;
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
        return new ItemDto(item.getId(), item.getUrl());
    }

    // Méthode pour convertir un ItemDto en Item
    public static Item toItem(ItemDto itemDTO) {
        if (itemDTO == null) {
            return null;
        }
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setUrl(itemDTO.getUrl());
        // Si vous avez besoin d'une tier, il faudra l'ajouter ici
        return item;
    }
}
