package authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.repositories.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private UsersRepository usersRepository;

	public AuthenticationController(AuthenticationManager authenticationManager, UsersRepository usersRepository) {
		this.authenticationManager = authenticationManager;
		this.usersRepository = usersRepository;
	};

	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
		if (this.usersRepository.findByEmail(data.email()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		UsersEntity usersEntity = new UsersEntity(data.email(), data.password(), UserRole.valueOf(data.role()));

		this.usersRepository.save(usersEntity);

		return ResponseEntity.ok().build();

	}

}
