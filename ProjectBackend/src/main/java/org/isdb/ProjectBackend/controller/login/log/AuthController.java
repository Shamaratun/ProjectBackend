package org.isdb.ProjectBackend.controller.login.log;

import java.util.HashMap;
import java.util.Map;

import org.isdb.ProjectBackend.config.JwtTokenProvider;
import org.isdb.ProjectBackend.dto.login.LoginRequest;
import org.isdb.ProjectBackend.dto.login.RegisterRequest;
import org.isdb.ProjectBackend.dto.login.UserResponse;
import org.isdb.ProjectBackend.model.CustomUserDetails;
import org.isdb.ProjectBackend.model.User;
import org.isdb.ProjectBackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserService userService;

	public AuthController(AuthenticationManager authenticationManager,
			JwtTokenProvider jwtTokenProvider,
			UserService userService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(
			@Valid @RequestBody RegisterRequest registerRequest) {
		try {
			User user = new User(registerRequest.email(), registerRequest.password(), registerRequest.role(),
					registerRequest.address(), registerRequest.nid(), registerRequest.phoneNumber(),
					registerRequest.fullName(), registerRequest.username()

			);

			User savedUser = userService.createUser(user);

			UserResponse userResponse = new UserResponse();
			userResponse.setId(savedUser.getId());
			userResponse.setEmail(savedUser.getEmail());
			userResponse.setRole(savedUser.getRole());

			userResponse.setAddress(savedUser.getAddress());
			userResponse.setNid(savedUser.getNid());
			userResponse.setPhoneNumber(savedUser.getPhoneNumber());
			userResponse.setFullName(savedUser.getFullName());
			userResponse.setUsername(savedUser.getUsername());
			userResponse.setCreatedAt(savedUser.getCreatedAt());
			userResponse.setUpdatedAt(savedUser.getUpdatedAt());
		
			return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtTokenProvider.createToken(authentication);

			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			User user = userDetails.user();

			Map<String, Object> responseData = new HashMap<>();
			responseData.put("access_token", jwt);
			responseData.put("tokenType", "Bearer");

			Map<String, Object> userData = new HashMap<>();
			userData.put("id", user.getId());
			userData.put("email", user.getEmail());
			userData.put("role", user.getRole());
			userData.put("fullname", user.getFullName());
			userData.put("username", user.getUsername());

			responseData.put("user", userData);

			return ResponseEntity.ok(responseData);
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
	}

	@GetMapping("/validate-token")
	public ResponseEntity<?> validateToken(HttpServletRequest request) {
		String jwt = getJwtFromRequest(request);

		if (jwt != null && jwtTokenProvider.validateToken(jwt)) {
			String username = jwtTokenProvider.getUsernameFromToken(jwt);
			UserDetails userDetails = userService.loadUserByUsername(username);
			CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
			User user = customUserDetails.user();

			UserResponse userResponse = new UserResponse();
			userResponse.setId(user.getId());
			userResponse.setEmail(user.getEmail());
			userResponse.setRole(user.getRole());
			userResponse.setFullName(user.getFullName());

			userResponse.setUsername(user.getUsername());

			return ResponseEntity.ok(userResponse);
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
