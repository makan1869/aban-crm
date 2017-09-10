package ir.serenade.crm.service;

import ir.serenade.crm.domain.Role;
import ir.serenade.crm.domain.User;

public interface UserService {
    User findUserByUsername(String username);

    Role findRoleByName(String name);

    Role saveRole(Role role);

    User saveUser(User user);
}
