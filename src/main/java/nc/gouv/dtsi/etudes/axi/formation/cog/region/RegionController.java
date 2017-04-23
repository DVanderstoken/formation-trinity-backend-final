package nc.gouv.dtsi.etudes.axi.formation.cog.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*")
public class RegionController {

	@Autowired
	private RegionRepository lRegionRepository;

	@RequestMapping(path = "/regions")
	public List<Region> getAll() {
		return lRegionRepository.findAll();
	}

	@RequestMapping(path = "/regions/{criteria}")
	public ResponseEntity<Region> getByCriteria(
			@PathVariable(name = ("criteria"), required = true) final String pCriteria) {

		/*
		 * Default pessimistic response
		 */
		ResponseEntity<Region> response = new ResponseEntity<>(null,
				HttpStatus.NOT_FOUND);

		Region result = lRegionRepository
				.findByCodeRegionOrNomTypoEnrichie(pCriteria, pCriteria);

		if (result != null) {
			response = new ResponseEntity<>(result, HttpStatus.OK);
		}

		return response;

	}

}
