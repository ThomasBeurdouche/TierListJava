package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.TierListDao;
import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.DTO.TierListDto;
import com.takima.backskeleton.DTO.TierListMapper;
import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.TierList;
import com.takima.backskeleton.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierListService {

    private final TierListDao tierListDao;
    private final UserDao userDao;
    @PersistenceContext
    private EntityManager entityManager;

    public TierListService(TierListDao tierListDao, UserDao userDao) {
        this.tierListDao = tierListDao;
        this.userDao = userDao;
    }

    public List<TierList> findAll() {
        Iterable<TierList> it = tierListDao.findAll();
        List<TierList> users = new ArrayList<>();
        it.forEach(users::add);
        return users;
    }

    public TierList getById(Long id) {
        return tierListDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        tierListDao.deleteById(id);
    }

    @Transactional
    public void updateTierList(TierListDto tierListDto, Long id) {
        tierListDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TierList doesn't exist"));
        TierList tierList;
        try {
            tierList = TierListMapper.fromDto(tierListDto, id);
            for (Tier tier : tierList.getTiers()) {
                tier.setTierList(tierList);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error with TierList image", e);
        }
        tierListDao.save(tierList);
    }

    @Transactional
    public void addTierList(TierListDto tierListDto) {
        TierList tierList;
        try {
            tierList = TierListMapper.fromDto(tierListDto, null);
            User owner = tierList.getOwner();
            if (owner != null && owner.getId() == null) {
                userDao.save(owner);
            }
            for (Tier tier : tierList.getTiers()) {
                tier.setTierList(tierList);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error with tierlist image", e);
        }
        tierListDao.save(tierList);
    }
}