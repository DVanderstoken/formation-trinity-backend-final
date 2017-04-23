package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommuneRepository
		extends JpaRepository<CommuneAbregee, CommuneId>,
		JpaSpecificationExecutor<CommuneAbregee> {

}
