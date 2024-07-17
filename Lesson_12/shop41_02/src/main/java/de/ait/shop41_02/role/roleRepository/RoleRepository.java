package de.ait.shop41_02.role.roleRepository;

import de.ait.shop41_02.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional <Role> findByTitle(String title);
}
