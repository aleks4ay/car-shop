package ua.aser.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aser.carshop.model.User;
import ua.aser.carshop.repository.UserRepository;

import java.util.List;
import java.util.function.BooleanSupplier;

@Service
@Transactional(readOnly = true)
public class UserService /*implements UserDetailsService*/{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(String login) {
        return userRepository.findByLogin(login);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        passwordEncoder.matches(password, user.getPassword());
        userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(Long.valueOf(id));
    }
}