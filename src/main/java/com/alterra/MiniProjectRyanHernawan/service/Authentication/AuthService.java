package com.alterra.MiniProjectRyanHernawan.service.Authentication;


import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.model.User;
import com.alterra.MiniProjectRyanHernawan.payload.TokenResponses;
import com.alterra.MiniProjectRyanHernawan.payload.UsernamePassword;

import java.util.List;

public interface AuthService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User register(UsernamePassword req);
    TokenResponses generateToken(UsernamePassword req);
    void deleteUserById(Long id);
}
