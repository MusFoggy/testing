package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Roles;
import ua.com.testing.entity.Student;
import ua.com.testing.entity.Users;
import ua.com.testing.repository.RolesRepository;
import ua.com.testing.repository.StudentRepository;
import ua.com.testing.repository.UsersRepository;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public UserService(UsersRepository usersRepository, RolesRepository rolesRepository, StudentRepository studentRepository) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.studentRepository = studentRepository;
    }
    public boolean authenticate(String username, String password) {
        return findByUsernameAndPassword(username, password).isPresent();
    }

    public Optional<Users> findByUsernameAndPassword(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    public boolean userExists(String username) {
        return usersRepository.findByUsername(username).isPresent();
    }

    public Users registerNewUser(String username, String password, String name, String surname, String email, PasswordEncoder passwordEncoder) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        Set<Roles> roles = new HashSet<>();
        roles.add(rolesRepository.findByName("ROLE_Student").orElseThrow(() -> new RuntimeException("Роль не знайдено")));
        user.setRoles(roles);

        Users savedUser = usersRepository.save(user);

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setUsers(savedUser);

        studentRepository.save(student);

        return savedUser;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

}

