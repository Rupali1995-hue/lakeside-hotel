package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
