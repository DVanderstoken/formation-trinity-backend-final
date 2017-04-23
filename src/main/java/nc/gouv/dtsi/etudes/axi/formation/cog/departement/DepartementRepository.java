package nc.gouv.dtsi.etudes.axi.formation.cog.departement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "departement", path = "departements")
public interface DepartementRepository
		extends JpaRepository<Departement, String> {

	Departement findByNomTypoEnrichieOrCodeDepartement(
			final String pNomTypoEnrichie, final String pCodeDepartement);

}
