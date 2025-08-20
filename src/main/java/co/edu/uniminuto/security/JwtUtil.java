package co.edu.uniminuto.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import java.util.Date;
import java.security.Key;
import java.nio.charset.StandardCharsets;

public class JwtUtil {

    private static final String SECRET = "admin123admin123admin123admin123"; // mínimo 256 bits
    private static final long EXPIRATION = 1000 * 60 * 90; // 1.5 horas

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(KEY)
            .compact();
    }

    public static String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                   .setSigningKey(KEY)
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
    }
}
