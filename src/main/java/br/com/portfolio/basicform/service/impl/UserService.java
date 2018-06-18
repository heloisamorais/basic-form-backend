package br.com.portfolio.basicform.service.impl;

import br.com.portfolio.basicform.data.model.User;
import br.com.portfolio.basicform.data.repository.UserRepository;
import br.com.portfolio.basicform.exception.NotFoundException;
import br.com.portfolio.basicform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        user = userRepository.save(user);
        return user;
    }

    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new NotFoundException();
        }

        return user;
    }

    public void deleteByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new NotFoundException();
        }

        userRepository.delete(user.getId());
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
