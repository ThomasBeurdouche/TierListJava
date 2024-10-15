package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.TierDao;
import com.takima.backskeleton.DAO.TierListDao;
import com.takima.backskeleton.DTO.*;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.models.TierList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TierService {
    private final TierDao tierDao;
    private final TierListDao tierListDao;

    public TierService(TierDao tierDao, TierListDao tierListDao) {
        this.tierDao = tierDao;
        this.tierListDao = tierListDao;
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

    @Transactional
    public void addStudent(TierDto tierDto) {
        Tier tier;
        tier = TierMapper.fromDto(tierDto, null);
        tierDao.save(tier);
    }

    @Transactional
    public void updateTier(TierDto tierDto, Long id) {
        tierDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Tier tier = TierMapper.fromDto(tierDto, id);
        tierDao.save(tier);
    }
}
