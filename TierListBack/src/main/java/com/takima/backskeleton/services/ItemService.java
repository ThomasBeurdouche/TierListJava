package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.ItemDao;
import com.takima.backskeleton.models.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> findAll() {
        Iterable<Item> it = itemDao.findAll();
        List <Item> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

//    public Item getById(Long id) {
//        return itemDao.findById(id).orElseThrow();
//    }
//
//    @Transactional
//    public void deleteById(Long id) {
//        itemDao.deleteById(id);
//    }
//
//    @Transactional
//    public void addItem(ItemDto itemDto) {
//        Item item;
//        item = ItemMapper.fromDto(itemDto, null);
//        itemDao.save(item);
//    }
//
//    @Transactional
//    public void updateItem(ItemDto itemDto, Long id) {
//        itemDao.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Item doesn't exist"));
//        Item item = ItemMapper.fromDto(itemDto, id);
//        itemDao.save(item);
//    }
}
