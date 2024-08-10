package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.CrtToSow;

@Repository
public interface CrtToSowRepository extends JpaRepository<CrtToSow, Long> {

}
