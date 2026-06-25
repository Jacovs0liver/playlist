package cl.duoc.playlist.user.controller;

import cl.duoc.playlist.user.dto.LoginRequest;
import cl.duoc.playlist.user.dto.LoginResponse;
import cl.duoc.playlist.user.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        String token =
                jwtService.generateToken(request.getEmail());

        return new LoginResponse(token);
    }
}