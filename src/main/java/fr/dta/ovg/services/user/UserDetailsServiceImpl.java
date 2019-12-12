package fr.dta.ovg.services.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserServiceImpl userServiceImpl;
////
//    @Autowired
//    private SecurityRoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        // Role d'un utilisateur Springboot
        UserDetails result = null;

        // User user = userServiceImpl.findByUsername(username);
        User user = userRepo.findByUsername(username).orElse(null);

        // TODO: Search on administrator if not found as simple user

        if (user != null) {

            // List<SecurityRole> roles = roleRepo.findByUsername(username);

            Set<GrantedAuthority> grantedAutorities = new HashSet<>();

            // for (SecurityRole role : roles) { }
            // Simple = role springboot
            grantedAutorities.add(new SimpleGrantedAuthority(user.getRole()));

            UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

            result = userBuilder.username(user.getUsername()).password(user.getPassword())
                    .authorities(grantedAutorities).build();
        }

        return result;
    }
}
