package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Item;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Tier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierDao extends JpaRepository<Student, Long> {
    @Query("SELECT i FROM Item i WHERE i.tier.id= :tierId")
    List<Item> findByMajorIdAndCourseId(int tierId);
}

