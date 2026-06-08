package blogapp.com.repoitories;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    
}
