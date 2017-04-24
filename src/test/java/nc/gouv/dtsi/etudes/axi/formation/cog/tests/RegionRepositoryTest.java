package nc.gouv.dtsi.etudes.axi.formation.cog.tests;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import nc.gouv.dtsi.etudes.axi.formation.FormationTrinityBackendAbstractTest;
import nc.gouv.dtsi.etudes.axi.formation.cog.region.Region;
import nc.gouv.dtsi.etudes.axi.formation.cog.region.RegionRepository;

public class RegionRepositoryTest extends FormationTrinityBackendAbstractTest {

	@Autowired
	private RegionRepository lRegionRepository;

	@Test
	public void shouldReturnNonEmptyRegionList() {

		List<Region> result = lRegionRepository.findAll();

		assertFalse(result.isEmpty());

	}

}
