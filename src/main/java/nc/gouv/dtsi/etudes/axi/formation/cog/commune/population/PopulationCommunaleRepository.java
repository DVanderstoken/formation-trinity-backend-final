package nc.gouv.dtsi.etudes.axi.formation.cog.commune.population;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationCommunaleRepository extends
        JpaRepository<PopulationCommunale, PopulationCommunaleId> {

    PopulationCommunale findByCodeDepartementAndCodeCommune(
            final String pCodeDepartement, final String pCodeCommune);

}
