package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.management.entity.BillingModel;

@Repository
public interface BillingModelRepository extends JpaRepository<BillingModel, Long> {

}
