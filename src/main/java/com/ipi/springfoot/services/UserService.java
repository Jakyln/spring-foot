package com.ipi.springfoot.services;

import com.ipi.springfoot.pojos.User;

import java.util.List;

public interface UserService {
    User ajouterUser(User user);
    User recupererUser(Long idUser);
    List<User> recupererUserAll();
}
