package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "commune", path = "communes")
public interface CommuneRepository
		extends JpaRepository<CommuneAbregee, CommuneId>,
		JpaSpecificationExecutor<CommuneAbregee> {

}
