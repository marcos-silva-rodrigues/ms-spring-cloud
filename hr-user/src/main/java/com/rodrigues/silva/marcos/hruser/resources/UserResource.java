package com.rodrigues.silva.marcos.hruser.resources;

import com.rodrigues.silva.marcos.hruser.entities.User;
import com.rodrigues.silva.marcos.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserResource {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);

    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

  }

  @GetMapping("/search")
  public ResponseEntity<User> search(@RequestParam(name = "email") String email) {
    Optional<User> user = userRepository.findByEmail(email);

    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

  }
}
