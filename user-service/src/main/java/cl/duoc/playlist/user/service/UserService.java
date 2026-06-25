package cl.duoc.playlist.user.service;

import cl.duoc.playlist.user.dto.UserRequest;
import cl.duoc.playlist.user.dto.UserResponse;
import cl.duoc.playlist.user.mapper.UserMapper;
import cl.duoc.playlist.user.model.User;
import cl.duoc.playlist.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserResponse> findAll() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toResponse(user);
    }

    public UserResponse create(UserRequest request) {
        User user = userMapper.toEntity(request);

        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setActivo(true);

        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();

        userMapper.updateEntity(request, user);

        return userMapper.toResponse(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}