package gastocompartido.api.services;

import gastocompartido.api.entities.auth.AuthResponse;
import gastocompartido.api.entities.auth.LoginRequest;
import gastocompartido.api.entities.auth.RegisterRequest;
import gastocompartido.api.entities.Role;
import gastocompartido.api.entities.User;
import gastocompartido.api.repositories.UserRepository;
import gastocompartido.api.services.interfaces.AuthService;
import gastocompartido.api.services.interfaces.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse registerUser(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUserName())
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .country(registerRequest.getCountry())
                .email(registerRequest.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
