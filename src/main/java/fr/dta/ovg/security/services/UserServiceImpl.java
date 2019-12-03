package fr.dta.ovg.security.services;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import fr.dta.ovg.security.entities.SecurityUser;
import fr.dta.ovg.security.repositories.SecurityUserRepository;

@Service
@Validated
public class UserServiceImpl implements UserService {

    @Autowired
    private SecurityUserRepository userSecurityRepository;

    @Override
    public void save(@Valid SecurityUser user) {
      String idForEncode = "bcrypt";
      Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
      encoders.put(idForEncode, new BCryptPasswordEncoder());

      PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userSecurityRepository.save(user);
    }

    @Override
    public SecurityUser findByUsername(String login) {
      return userSecurityRepository.findByUsername(login);
    }

}
