package br.com.portfolio.basicform.service;

import br.com.portfolio.basicform.data.model.User;

public interface IUserService {

    User createUser(User user);
    User findByEmail(String email);
    void deleteByEmail(String email);
    Iterable<User> findAll();

}
