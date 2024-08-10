package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.GeoLoation;

@Repository
public interface GeoLoationRepository extends JpaRepository<GeoLoation, Long> {

}
