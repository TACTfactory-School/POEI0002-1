/* User Details Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action : Delete an Event.
 * License : ©2019 All rights reserved
 */

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

/** User Details Service Implementation.*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /** Link to user repository. */
    @Autowired
    private UserRepository userRepo;

    /** Load by username function.
     * @param username of the user.
     * @return UserDetails with security builder.
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        UserDetails result = null;

        User user = userRepo.findByUsername(username).orElse(null);

        if (user != null) {

            Set<GrantedAuthority> grantedAutorities = new HashSet<>();

            grantedAutorities.add(new SimpleGrantedAuthority(user.getRole()));

            UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

            result = userBuilder.username(user.getUsername()).password(user.getPassword())
                    .authorities(grantedAutorities).build();
        }

        return result;
    }
}
