package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import contract.management.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
