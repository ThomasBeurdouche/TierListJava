package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Tier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierDao extends JpaRepository<Tier, Long> {
    //@Query("SELECT i FROM Item i WHERE i.tier.id= :tierId")
    //List<Item> findByTierId(int tierId);
}

