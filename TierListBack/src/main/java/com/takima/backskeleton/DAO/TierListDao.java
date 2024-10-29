package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Item;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Tier;

import com.takima.backskeleton.models.TierList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierListDao extends JpaRepository<TierList, Long> {
    //@Query("SELECT t FROM Tier t WHERE t.tierList.id= :tierListId")
    //List<Item> findbyTierListId(int tierListId);
}

