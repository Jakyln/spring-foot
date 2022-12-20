package com.ipi.springfoot.services.impl;

import com.ipi.springfoot.dao.UserDao;
import com.ipi.springfoot.pojos.User;
import com.ipi.springfoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User ajouterUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User recupererUser(Long idUser) {
        return userDao.findById(idUser).orElse(null);
    }

    @Override
    public List<User> recupererUserAll() {
        return userDao.findAll();
    }
}
