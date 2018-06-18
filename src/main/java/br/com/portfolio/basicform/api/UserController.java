package br.com.portfolio.basicform.api;

import br.com.portfolio.basicform.data.model.User;
import br.com.portfolio.basicform.exception.BadRequestException;
import br.com.portfolio.basicform.exception.NotFoundException;
import br.com.portfolio.basicform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "create",
            method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User userBody){

        if (userBody.getEmail() == null) {
            throw new BadRequestException("Invalid email");
        }

        User user = userService.createUser(userBody);
        return user != null ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "get",
            method = RequestMethod.POST)
    public ResponseEntity findByEmail(@PathVariable String email){

        if (email == null) {
            throw new BadRequestException("Invalid email");
        }

        User user = userService.findByEmail(email);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "delete",
            method = RequestMethod.DELETE)
    public Iterable<User> deleteByEmail(@RequestParam String email){

        if (email == null) {
            throw new BadRequestException("Invalid email");
        }

        userService.deleteByEmail(email);
        return userService.findAll();
    }

    @RequestMapping(value = "update",
            method = RequestMethod.POST)
    public ResponseEntity updateByEmail(@RequestBody User userBody){

        if (userBody.getName() == null) {
            throw new BadRequestException("Invalid name");
        }

        if (userService.findByEmail(userBody.getEmail()) == null) {
            throw new NotFoundException();
        }

        userService.createUser(userBody);
        return ResponseEntity.ok().build();
    }
}
