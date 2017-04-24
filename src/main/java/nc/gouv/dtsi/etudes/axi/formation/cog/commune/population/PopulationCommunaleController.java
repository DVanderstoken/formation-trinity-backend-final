package nc.gouv.dtsi.etudes.axi.formation.cog.commune.population;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopulationCommunaleController {

    @Autowired
    private PopulationCommunaleRepository lPopulationCommunaleRepository;

    @RequestMapping("/api/v1/departement/{dep}/commune/{com}/population")
    public HttpEntity<PopulationCommunale> getPopulation(
            @PathVariable("dep") final String dep,
            @PathVariable("com") final String com) {

        PopulationCommunale response = null;

        response = lPopulationCommunaleRepository
                .findByCodeDepartementAndCodeCommune(dep, com);

        return new HttpEntity<PopulationCommunale>(response);

    }
}
