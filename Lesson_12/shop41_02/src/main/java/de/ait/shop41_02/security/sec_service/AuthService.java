package de.ait.shop41_02.security.sec_service;

import de.ait.shop41_02.security.sec_dto.TokenResponseDto;
import de.ait.shop41_02.users.User;
import de.ait.shop41_02.users.service.UserService;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.rowset.spi.SyncResolver;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserService userService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private Map<String, String> refreshStorage = new HashMap<>();


    public TokenResponseDto login(User inboundUser) throws AuthException {

        String username = inboundUser.getUsername();
        User foundUser = (User) userService.loadUserByUsername(username);

        if (bCryptPasswordEncoder.matches(inboundUser.getPassword(), foundUser.getPassword())) {
            //create Tokens

            String accessToken = tokenService.generateAccessToken(foundUser);
            String refreshToken = tokenService.generateRefreshToken(foundUser);

            refreshStorage.put(username, refreshToken);
            return new TokenResponseDto(accessToken, refreshToken);
        } else {
            throw new AuthException("Login/password not correct");

        }


    }


    public TokenResponseDto getNewAccessToken(String inboundRefreshToken) {


        Claims refreshClaims = tokenService.getRefreshClaims(inboundRefreshToken);

        String userName = refreshClaims.getSubject();
        String savedRefreshToken = refreshStorage.get(userName);

        if (savedRefreshToken!=null && savedRefreshToken.equals(inboundRefreshToken)) {

            User user = (User) userService.loadUserByUsername(userName);
            String accessToken = tokenService.generateAccessToken(user);
            return new TokenResponseDto(accessToken, null);
        }else {
            return new TokenResponseDto(null, null);
        }
    }

}
