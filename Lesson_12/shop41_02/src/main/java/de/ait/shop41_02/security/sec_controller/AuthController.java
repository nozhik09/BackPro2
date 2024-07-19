package de.ait.shop41_02.security.sec_controller;


import de.ait.shop41_02.security.sec_dto.RefreshRequestDto;
import de.ait.shop41_02.security.sec_dto.TokenResponseDto;
import de.ait.shop41_02.security.sec_service.AuthService;
import de.ait.shop41_02.users.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody User user) {
        try {
            return authService.login(user);
        } catch (AuthException e) {
            return new TokenResponseDto(null,null);
        }
    }


    @PostMapping("/refresh")
public TokenResponseDto getAccessToken(@RequestBody RefreshRequestDto requestDto) {
      return   authService.getNewAccessToken(requestDto.getRefreshToken());
    }

}
