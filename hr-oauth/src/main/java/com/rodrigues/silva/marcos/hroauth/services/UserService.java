package com.rodrigues.silva.marcos.hroauth.services;

import com.rodrigues.silva.marcos.hroauth.clients.UserFeignClient;
import com.rodrigues.silva.marcos.hroauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserFeignClient userFeignClient;

  public User findByEmail (String email) {
    User user = userFeignClient.findByEmail(email).getBody();
    if (user == null) {
      log.error("Email not found: " + email);
      throw new IllegalArgumentException("Email not found");
    }

    log.error("Email found: " + email);
    return user;
  }

}
