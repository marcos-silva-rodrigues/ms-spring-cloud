package com.rodrigues.silva.marcos.hroauth.resources;

import com.rodrigues.silva.marcos.hroauth.entities.User;
import com.rodrigues.silva.marcos.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping("/search")
  public ResponseEntity<User> findByEamil(@RequestParam String email) {
    return ResponseEntity.ok(userService.findByEmail(email));
  }
}
