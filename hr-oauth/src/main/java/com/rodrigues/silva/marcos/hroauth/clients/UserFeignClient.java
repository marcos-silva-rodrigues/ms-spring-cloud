package com.rodrigues.silva.marcos.hroauth.clients;

import com.rodrigues.silva.marcos.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

  @GetMapping(value = "/search")
  ResponseEntity<User> findByEmail(@RequestParam String email);
}
