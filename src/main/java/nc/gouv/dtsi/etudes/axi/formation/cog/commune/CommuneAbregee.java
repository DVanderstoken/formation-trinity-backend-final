package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "T_COMMUNE")
@NamedQueries({
		@NamedQuery(name = "findAllCommunesAbregees", query = "SELECT ca FROM CommuneAbregee ca"),
		@NamedQuery(name = "findCommunesAbregeesByDept", query = "SELECT ca FROM CommuneAbregee ca WHERE codeDepartement = :pCodeDepartement") })
public class CommuneAbregee extends Commune implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7264814083766482275L;

}
