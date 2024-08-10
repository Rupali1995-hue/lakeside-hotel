package contract.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import contract.management.entity.ClientMaster;


public interface ClientMasterRepository extends JpaRepository<ClientMaster, Long> {

	ClientMaster save(ClientMaster clientMaster);

	ClientMaster findByClientNameIgnoreCase(String clientName);

}
