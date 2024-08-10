package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
