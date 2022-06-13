package com.alterra.MiniProjectRyanHernawan.controller;

import com.alterra.MiniProjectRyanHernawan.model.BaseResponse;
import com.alterra.MiniProjectRyanHernawan.model.User;
import com.alterra.MiniProjectRyanHernawan.payload.TokenResponses;
import com.alterra.MiniProjectRyanHernawan.payload.UsernamePassword;
import com.alterra.MiniProjectRyanHernawan.service.Authentication.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req){
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody UsernamePassword req){
        TokenResponses token = authService.generateToken(req);
        Map<String, Object>  response = new HashMap<>();
        response.put("data", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(Principal principal){
        String principal1 = principal.getName();
        Map<String, Object> response = new HashMap<>();
        response.put("data", principal1);
        if (principal == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        BaseResponse<List<User>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(authService.getAllUsers());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        BaseResponse<List<User>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(List.of(authService.getUserById(id)));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        authService.deleteUserById(id);
        return "Success";
    }
}
