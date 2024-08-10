package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
