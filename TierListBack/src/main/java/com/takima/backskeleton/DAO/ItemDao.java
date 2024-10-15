package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Item;
import com.takima.backskeleton.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<Course, Long> {

}
