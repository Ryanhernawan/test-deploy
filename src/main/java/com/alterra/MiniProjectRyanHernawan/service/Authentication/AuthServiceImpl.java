package com.alterra.MiniProjectRyanHernawan.service.Authentication;


import com.alterra.MiniProjectRyanHernawan.model.User;
import com.alterra.MiniProjectRyanHernawan.payload.TokenResponses;
import com.alterra.MiniProjectRyanHernawan.payload.UsernamePassword;
import com.alterra.MiniProjectRyanHernawan.repository.UserRepository;
import com.alterra.MiniProjectRyanHernawan.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private  final AuthenticationManager authenticationManager;
    private  final JwtProvider jwtProvider;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public User register(UsernamePassword req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        return userRepository.save(user);
    }



    @Override
    public TokenResponses generateToken(UsernamePassword req) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            TokenResponses tokenResponses = new TokenResponses();
            tokenResponses.setToken(jwt);
            return tokenResponses;
        }catch (BadCredentialsException e){
            log.error("Bad Credential", e);
            throw new RuntimeException(e.getMessage(), e);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }



    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
