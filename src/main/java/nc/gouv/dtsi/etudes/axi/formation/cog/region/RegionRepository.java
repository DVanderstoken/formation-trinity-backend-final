package nc.gouv.dtsi.etudes.axi.formation.cog.region;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {

	Region findByNomTypoEnrichie(final String pCriteria);

	Region findByCodeRegionOrNomTypoEnrichie(final String pCodeRegion,
			final String pNomTypoEnrichie);

}
