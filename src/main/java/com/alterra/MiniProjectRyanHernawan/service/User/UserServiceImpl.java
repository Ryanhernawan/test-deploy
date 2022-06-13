package com.alterra.MiniProjectRyanHernawan.service.User;

import com.alterra.MiniProjectRyanHernawan.model.User;
import com.alterra.MiniProjectRyanHernawan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getDistinctTopByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username Not Found");
        }
        return user;
    }
}
