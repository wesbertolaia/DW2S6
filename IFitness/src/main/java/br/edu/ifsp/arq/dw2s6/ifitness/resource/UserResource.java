package br.edu.ifsp.arq.dw2s6.ifitness.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.User;
import br.edu.ifsp.arq.dw2s6.ifitness.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> list() {
		return userRepository.findAll();
	}

	// testar Postman
	// http://localhost:8080/users

	@PostMapping
	public User create(@RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}

	// testar Postman
	// POST - http://localhost:8080/users
	// Body - raw - JSON
	/*
	 * { "name": "Adriana Silva", "email": "adrianasilva@ifsp.edu.br", "password":
	 * "$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji", "age": 30,
	 * "gender": "FEMININO" }
	 */

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}

	// testar Postman
	// GET - http://localhost:8080/users/1
	// GET - http://localhost:8080/users/10

}