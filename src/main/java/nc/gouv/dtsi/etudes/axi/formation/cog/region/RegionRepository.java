package nc.gouv.dtsi.etudes.axi.formation.cog.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "region", path = "regions")
public interface RegionRepository extends JpaRepository<Region, String> {

	Region findByCodeRegionOrNomTypoEnrichie(final String pCodeRegion,
			final String pNomTypoEnrichie);

}
