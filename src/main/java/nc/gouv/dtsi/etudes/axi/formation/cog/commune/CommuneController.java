package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import static nc.gouv.dtsi.etudes.axi.formation.cog.commune.CommuneSpecification.isInDepartement;
import static nc.gouv.dtsi.etudes.axi.formation.cog.commune.CommuneSpecification.isInRegion;
import static nc.gouv.dtsi.etudes.axi.formation.cog.commune.CommuneSpecification.isTheCommune;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*")
public class CommuneController {

	@Autowired
	private CommuneRepository lCommuneRepository;

	/**
	 * Méthode de récupération de l'ensemble de la liste des communes.
	 * 
	 * @return une Liste de communes.
	 */
	@RequestMapping(path = "/communes", method = RequestMethod.GET)
	public List<CommuneAbregee> getAll() {

		return lCommuneRepository.findAll();

	}

	/**
	 * Méthode de recherche des communes :
	 * <ul>
	 * <li>par région</li>
	 * <li>par département</li>
	 * <li>par commune</li>
	 * </ul>
	 * <p>
	 * L'ensemble des paramètres de rcherche sont combinables. Une recherche par
	 * commune retournera une seulle commune, les autres critères deviennent
	 * dans ce cas inutiles.
	 * </p>
	 * <p>
	 * ATTENTION : L'ensemble des critères sont optionnels. Si aucun critère
	 * n'est renseigné, l'ensemble de la liste des communes sera retourné. Si
	 * les code région et code département sont utilisés ensemble, il doit y
	 * avoir cohérence sur l'appartenance du département à la région en
	 * question. Dans le cas contraire c'est une liste vide qui sera retournée.
	 * 
	 * @param pRegion,
	 *            le code de la région d'appartenance des communes recherchées.
	 * @param pDepartement,
	 *            le code du département d'appartenance des communes
	 *            recherchées.
	 * @param pCommune,
	 *            le code de la commune recherchée.
	 * @param pPageable,
	 *            pour avoir un résultat paginé par défaut dans le cas où aucun
	 *            critère n'est renseigné (volume de données).
	 * @return une liste de commune paginée.
	 */
	@RequestMapping(path = "/communes/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<CommuneAbregee> search(
			@RequestParam(name = "region", required = false) final String pRegion,
			@RequestParam(name = "departement", required = false) final String pDepartement,
			@RequestParam(name = "commune", required = false) final String pCommune,
			Pageable pPageable) {

		return lCommuneRepository.findAll(where(isInRegion(pRegion))
				.and(isInDepartement(pDepartement)).and(isTheCommune(pCommune)),
				pPageable);

	}

}
