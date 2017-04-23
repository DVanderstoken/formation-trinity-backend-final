package nc.gouv.dtsi.etudes.axi.formation.cog.departement;

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
public class DepartementController {

	@Autowired
	private DepartementRepository lDepartementRepository;

	/**
	 * Méthode de récupération de l'ensemble de la liste des Departements.
	 * 
	 * @return une liste de départements.
	 */
	@RequestMapping(path = "/departements")
	public List<Departement> getAll() {

		return lDepartementRepository.findAll();

	}

	/**
	 * @param pCriteria,
	 *            le critère de recherche : un code département ou le nom du
	 *            département (typographie enrichie).
	 * @return un département.
	 */
	@RequestMapping(path = "/departements/{criteria}")
	public ResponseEntity<Departement> getByCriteria(
			@PathVariable(name = ("criteria"), required = true) final String pCriteria) {

		/*
		 * Default pessimistic response
		 */
		ResponseEntity<Departement> response = new ResponseEntity<>(null,
				HttpStatus.NOT_FOUND);

		Departement result = lDepartementRepository
				.findByNomTypoEnrichieOrCodeDepartement(pCriteria, pCriteria);

		if (result != null) {
			response = new ResponseEntity<>(result, HttpStatus.OK);
		}

		return response;

	}
}
