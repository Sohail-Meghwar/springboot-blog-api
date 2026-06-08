package blogapp.com;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import blogapp.com.entities.Role;
import blogapp.com.repoitories.RoleRepo;

 


@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepo roleRepo;

    public BlogApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) {
        System.out.println(passwordEncoder.encode("15"));

try {
    Role role=new Role();
    role.setId(22);
    role.setName("ROLE_NORMAL");
    Role role1=new Role();
    role1.setId(23);
    role1.setName("ROLE_ADMIN");
    this.roleRepo.save(role);
    this.roleRepo.save(role1);

    List<Role>roles=List.of(role, role1);
   List<Role> result=this.roleRepo.saveAll(roles);
    result.forEach(r->{
     System.out.println(r.getName());
    });

}catch (Exception e) {
    e.printStackTrace();
}
 

    }
}
