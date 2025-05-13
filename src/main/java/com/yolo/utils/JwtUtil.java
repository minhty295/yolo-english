package com.yolo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	private final long JWT_ACCESS_TOKEN_EXPIRATION = 24 * 60 * 60 * 1000; // 1 ngày
	private final long JWT_REFRESH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60 * 1000; // 7 ngày


	public String generateAccessToken(String username, String role) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_ACCESS_TOKEN_EXPIRATION);

		return Jwts.builder().setSubject(username).claim("role", role).claim("type", "access").setIssuedAt(now)
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}


	public String generateRefreshToken(String username, String role) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_REFRESH_TOKEN_EXPIRATION);

		return Jwts.builder().setSubject(username).claim("role", role).claim("type", "refresh").setIssuedAt(now)
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}


	public boolean validateToken(String token) {
		try {
			Claims claims = getAllClaimsFromToken(token);

			String tokenType = claims.get("type", String.class);
			if (tokenType == null || !tokenType.equals("access")) {
				throw new IllegalStateException("Invalid token type");
			}

			return true;
		} catch (ExpiredJwtException e) {
			throw new IllegalStateException("Token expired", e);
		} catch (Exception e) {
			throw new IllegalStateException("Invalid token", e);
		}
	}


	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}


	public String getRoleFromToken(String token) {
		return getAllClaimsFromToken(token).get("role", String.class);
	}


	public String getTypeFromToken(String token) {
		return getAllClaimsFromToken(token).get("type", String.class);
	}


	public boolean isTokenExpired(String token) {
		Date expiration = getAllClaimsFromToken(token).getExpiration();
		return expiration.before(new Date());
	}


	public String refreshAccessToken(String refreshToken) {
		Claims claims = getAllClaimsFromToken(refreshToken);

		if (!"refresh".equals(claims.get("type", String.class))) {
			throw new IllegalStateException("Invalid refresh token");
		}

		String username = claims.getSubject();
		String role = claims.get("role", String.class);

		return generateAccessToken(username, role);
	}


	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}
}
