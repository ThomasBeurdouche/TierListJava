package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Item;

public class ItemMapper {
    public static Item fromDto(ItemDto itemDto, Long id) {
        return new Item(
                id,
                itemDto.getItemTitle(),
                itemDto.getUrl(),
                itemDto.getTier()
        );
    }
    public static ItemDto toDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getItemTitle(),
                item.getUrl(),
                item.getTier()
        );
    }
}
