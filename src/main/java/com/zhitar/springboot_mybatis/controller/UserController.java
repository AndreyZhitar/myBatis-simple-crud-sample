package com.zhitar.springboot_mybatis.controller;

import com.zhitar.springboot_mybatis.mapper.UserMapper;
import com.zhitar.springboot_mybatis.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserMapper mapper;

    @GetMapping
    public List<User> findAll() {
        return mapper.findAll();
    }

    @PutMapping
    public void update(@RequestBody User user) {
        mapper.update(user);
    }

    @PostMapping
    public List<User> insertById(@RequestBody User user) {
        mapper.insert(user);
        return mapper.findAll();
    }

    @GetMapping("/{name}")
    public List<User> findByName(@PathVariable String name) {
        return mapper.findByName(name);
    }

    @DeleteMapping()
    public void deleteById(@RequestParam Long id) {
        mapper.deleteById(id);
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String surname,
                                   @RequestParam(required = false) String password) {
        return mapper.search(name, surname, password);
    }
}
