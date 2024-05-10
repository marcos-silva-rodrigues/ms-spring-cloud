package com.rodrigues.silva.marcos.hroauth.services;

import com.rodrigues.silva.marcos.hroauth.clients.UserFeignClient;
import com.rodrigues.silva.marcos.hroauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

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

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      return findByEmail(username);
    } catch (IllegalArgumentException ex ) {
      throw new UsernameNotFoundException(ex.getMessage());
    }
  }
}
