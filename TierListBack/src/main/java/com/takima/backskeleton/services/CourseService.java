package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.CourseDao;
import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseService {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
