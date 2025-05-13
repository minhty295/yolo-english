package com.yolo.configs;

import com.yolo.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtProvider;

	public JwtAuthenticationFilter(JwtUtil jwtProvider) {
		this.jwtProvider = jwtProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Nếu là đường dẫn không yêu cầu xác thực (ví dụ /api/auth/**), bỏ qua
        if (request.getRequestURI().startsWith("/api/auth/")) {
            filterChain.doFilter(request, response);  
            return;  
        }

		String authHeader = request.getHeader("Authorization");

		// Kiểm tra nếu header Authorization có chứa Bearer token
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
	
			// Nếu token không hợp lệ, trả về 401 Unauthorized
			try {
				jwtProvider.validateToken(token);
			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
				return; // Ngừng xử lý request
			}

			String username = jwtProvider.getUsernameFromToken(token);
			String role = jwtProvider.getRoleFromToken(token);

			// Nếu token hợp lệ, tạo Authentication và đặt vào SecurityContext
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null,
					Collections.emptyList());

			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		// Tiếp tục xử lý các bộ lọc còn lại
		filterChain.doFilter(request, response);
	}
}
