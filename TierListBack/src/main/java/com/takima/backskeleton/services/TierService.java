package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.TierDao;
import com.takima.backskeleton.DTO.*;
import com.takima.backskeleton.models.Tier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierService {
    private final TierDao tierDao;

    public TierService(TierDao tierDao) {
        this.tierDao = tierDao;
    }

    public List<Tier> findAll() {
        Iterable<Tier> it = tierDao.findAll();
        List <Tier> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Tier getById(Long id) {
        return tierDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        tierDao.deleteById(id);
    }
//
//    @Transactional
//    public void addTier(TierDto tierDto) {
//        Tier tier;
//        tier = TierMapper.fromDto(tierDto, null);
//        tierDao.save(tier);
//    }
//
    @Transactional
    public void updateTier(TierDto tierDto, Long id) {
        tierDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tier doesn't exist"));
        Tier tier = TierMapper.fromDto(tierDto, id);
        tierDao.save(tier);
    }
}
