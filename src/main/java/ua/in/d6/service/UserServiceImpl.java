package ua.in.d6.service;

import ua.in.d6.domain.root.CustomUser;
import ua.in.d6.repository.root.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CustomUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        CustomUser customUser = userRepository.findByLogin(login);
        return customUser != null;
    }

//    @Override
//    @Transactional
//    public void addUser(CustomUser user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(CustomUser user) {
//        userRepository.save(user);
//    }


}
