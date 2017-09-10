package ir.serenade.crm.config;

import ir.serenade.crm.domain.Role;
import ir.serenade.crm.domain.User;
import ir.serenade.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CrmApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Role adminRole = userService.findRoleByName("ROLE_ADMIN");
        if(adminRole == null) {
            adminRole = userService.saveRole(new Role("ROLE_ADMIN"));
        }

        Role cusotmerRole = userService.findRoleByName("ROLE_CUSTOMER");
        if(cusotmerRole == null) {
            cusotmerRole = userService.saveRole(new Role("ROLE_CUSTOMER"));
        }

    }
}
