package com.example.demo2.Services;

import com.example.demo2.Data.Entities.Authority;
import com.example.demo2.Data.Entities.User;
import com.example.demo2.Data.Repositories.AuthorityRepository;
import com.example.demo2.Data.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    public boolean createSuperAdmin(String username, String password, String firstName, String lastName,
                                    String emailAddress) {

        if (!authorityRepository.findByAuthority("ROLE_SUPERADMIN").isEmpty())
            return false;

        String[] authorities = { "ROLE_SUPERADMIN" };
        create(username, password, firstName, lastName, emailAddress, authorities);
        return true;
    }

    public void createAdmin(String username, String password, String firstName, String lastName, String emailAddress
                            ) {

        String[] authorities = { "ROLE_ADMIN", "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, authorities);
    }

    public void createUser(String username, String password, String firstName, String lastName, String emailAddress
                           ) {

        String[] authorities = { "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, authorities);
    }

    private void create(String username, String password, String firstName, String lastName, String emailAddress
                        , String[] authorities) {

        User user = new User(username, password, firstName, lastName, emailAddress);
        userRepository.save(user);
        for (String auth : authorities) {
            Authority authority = new Authority(username, auth);
            authorityRepository.save(authority);
        }
    }

    public void update(long userId, String password, String newPassword, String firstName, String lastName,
                       String emailAddress) {
        User user = userRepository.findById(userId).get();
       /* if (password != null && (newPassword == null
               || !(new BCryptPasswordEncoder().encode(password).equals(user.getPassword())))) {
            return;
        }

        if (newPassword != null)
            user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        if (firstName != null)
            user.setFirstName(firstName);
        if (lastName != null)
            user.setLastName(lastName);
        if (emailAddress != null)
            user.setEmailAddress(emailAddress);*/

        userRepository.save(user);
    }
}
