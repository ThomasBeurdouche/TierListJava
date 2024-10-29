package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
//import com.takima.backskeleton.DAO.UserListDao;
//import com.takima.backskeleton.DTO.UserDto;
//import com.takima.backskeleton.DTO.UserMapper;
import com.takima.backskeleton.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserDao UserDao;

    public UserService(UserDao UserDao) {
        this.UserDao = UserDao;
    }

    public List<User> findAll() {
        Iterable<User> it = UserDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

//    public User getById(Long id) {
//        return UserDao.findById(id).orElseThrow();
//    }
//
//    @Transactional
//    public void deleteById(Long id) {
//        UserDao.deleteById(id);
//    }

    /*
    @Transactional
    public void addUser(UserDto userDto) {
        User User;
        User = UserMapper.fromDto(userDto, null);
        UserDao.save(User);
    }

    @Transactional
    public void updateUser(UserDto userDto, Long id) {
        UserDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist"));
        User User = UserMapper.fromDto(userDto, id);
        UserDao.save(User);
    }
    */
}
