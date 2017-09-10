package ir.serenade.crm.repository;

import ir.serenade.crm.domain.Role;
import ir.serenade.crm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByAuthority(String name);
}
