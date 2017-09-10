package ir.serenade.crm.service.impl;

import ir.serenade.crm.domain.Role;
import ir.serenade.crm.domain.User;
import ir.serenade.crm.repository.RoleRepository;
import ir.serenade.crm.repository.UserRepository;
import ir.serenade.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByAuthority(name);

    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
