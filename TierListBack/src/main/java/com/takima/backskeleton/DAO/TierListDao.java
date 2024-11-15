package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.TierList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierListDao extends JpaRepository<TierList, Long> {
    //@Query("SELECT t FROM Tier t WHERE t.tierList.id= :tierListId")
    //List<Item> findbyTierListId(int tierListId);
}

