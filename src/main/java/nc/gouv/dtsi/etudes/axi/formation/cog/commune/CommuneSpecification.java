package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class CommuneSpecification {

	public static Specification<CommuneAbregee> isInRegion(final String codeRegion) {

		return checkSpec(CommuneAbregee_.codeRegion, codeRegion);
	}

	public static Specification<CommuneAbregee> isInDepartement(
			final String codeDepartement) {

		return checkSpec(CommuneAbregee_.codeRegion, codeDepartement);
	}

	public static Specification<CommuneAbregee> isTheCommune(
			final String codeCommune) {

		return checkSpec(CommuneAbregee_.codeRegion, codeCommune);
	}

	private static Specification<CommuneAbregee> checkSpec(
			SingularAttribute<Commune, String> propertyName, String content) {

		if (StringUtils.trimToNull(content) != null) {

			return (root, query, cb) -> cb.equal(root.get(propertyName),
					content);

		}

		return null;
	}
}
