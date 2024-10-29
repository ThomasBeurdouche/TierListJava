package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.TierListDao;
import com.takima.backskeleton.models.TierList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TierListService {

    private final TierListDao tierListDao;

    public TierListService(TierListDao tierListDao) {
        this.tierListDao = tierListDao;
    }
    public List<TierList> findAll() {
        Iterable<TierList> it = tierListDao.findAll();
        List <TierList> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

//    public TierList getById(Long id) {
//        return tierListDao.findById(id).orElseThrow();
//    }

//    @Transactional
//    public void deleteById(Long id) {
//        tierListDao.deleteById(id);
//    }

//    @Transactional
//    public void addTierList(TierListDto tierListDto) {
//        TierList tierList;
//        try {
//            tierList = TierListMapper.fromDto(tierListDto, null); //TODO : change to TierListMapper
//        } catch (IOException e) {
//            throw new RuntimeException("Error with tierlist image", e);
//        }
//
//        tierListDao.save(tierList);
//    }

//    @Transactional
//    public void updateTierList(TierListDto tierListDto, Long id) {
//        tierListDao.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("TierList doesn't exist"));
//        TierList tierList;
//        try {
//            tierList = TierListMapper.fromDto(tierListDto, null); //TODO : change to TierListMapper
//        } catch (IOException e) {
//            throw new RuntimeException("Error with TierList image", e);
//        }
//        tierListDao.save(tierList);
//    }


//    public void addTierList(StudentDto studentDto) {
//        // TODO  : addTierList
//    }
//
//    public TierList getTierListById(Long id) {
//        return null;//TODO : getTierListById
//    }
}

