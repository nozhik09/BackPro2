package de.ait.shop41_02.security.sec_service;

import de.ait.shop41_02.role.Role;
import de.ait.shop41_02.role.roleRepository.RoleRepository;
import de.ait.shop41_02.security.AuthInfo;
import de.ait.shop41_02.users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private SecretKey accessSecretKey;
    private SecretKey refreshSecretKey;
    private RoleRepository roleRepository;
    private final int ACCESS_TOKEN_EXPIRES_TIME = 7;
    private final int REFRESH_TOKEN_EXPIRES_TIME = 30;


    public TokenService(@Value("${key.access}") String accessSecretPhrse,
                        @Value("${key.refresh}") String refreshSecretKey,
                        @Autowired RoleRepository roleRepository) {

        this.accessSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecretPhrse));
        this.refreshSecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecretKey));
        this.roleRepository = roleRepository;

    }


    public String generateAccessToken(User user) {

       return Jwts.builder()
                .subject(user.getUsername())
                .expiration(calcExpiryDate(ACCESS_TOKEN_EXPIRES_TIME))
                .signWith(accessSecretKey)
                .claim("roles", user.getAuthorities())
                .claim("name", user.getUsername())
                .compact();
    }


    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(calcExpiryDate(REFRESH_TOKEN_EXPIRES_TIME))
                .signWith(refreshSecretKey)
                .compact();
    }


    private Date calcExpiryDate(int days) {
        LocalDateTime now = LocalDateTime.now();

        Instant instant = now.plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        return Date.from(instant);
    }

    public boolean validateAccessToken(String token) {
        return validateToken(token, accessSecretKey);
    }

    public boolean validateRefreshToken(String token) {
        return validateToken(token, refreshSecretKey);
    }


    private boolean validateToken(String token, SecretKey key) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    private Claims getClaimsFromToken(String token, SecretKey key) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Claims getAccessClaims(String accessToken) {
        return getClaimsFromToken(accessToken, accessSecretKey);
    }

    public Claims getRefreshClaims(String refreshToken) {
        return getClaimsFromToken(refreshToken, refreshSecretKey);
    }


    public AuthInfo mapClaimsToAuthInfo(Claims claims) {

        String username = claims.getSubject();
        List<LinkedHashMap<String, String>> listOfRolesHashMaps =
                (List<LinkedHashMap<String, String>>) claims.get("roles");

//        Set<Role> roleSet = new HashSet<>();
//        for (LinkedHashMap<String, String> roleMap : listOfRolesHashMaps) {
//            String roleType = roleMap.get("authority");
//            Role role = roleRepository.findByTitle(roleType).orElse(null);
//            if (role != null) {
//                roleSet.add(role);
//
//            }
//        }
        Set<Role> roles = listOfRolesHashMaps.stream().map(roleHashMap -> roleHashMap.get("authority"))
                .map(roleTitle -> roleRepository.findByTitle(roleTitle).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());


        return new AuthInfo(username, roles);
    }


}
