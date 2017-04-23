package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import java.io.Serializable;

import javax.persistence.IdClass;

@IdClass(CommuneId.class)
public class CommuneId implements Serializable {

	/**
	 * generated serialVersionUID.
	 */
	private static final long serialVersionUID = 7580110303211797900L;

	/**
	 * Define PRIME to avoid using magic number...
	 */
	private static final int PRIME = 31;

	/**
	 * Code du département.
	 */
	private String codeDepartement;
	/**
	 * Code de la Commune.
	 */
	private String codeCommune;

	/**
	 * Default constructor.
	 */
	public CommuneId() {
		super();
	}

	/**
	 * @param pCodeDepartement,
	 *            le code du département.
	 * @param pCodeCommune,
	 *            le code de la commune.
	 */
	public CommuneId(final String pCodeDepartement, final String pCodeCommune) {
		super();
		this.codeDepartement = pCodeDepartement;
		this.codeCommune = pCodeCommune;
	}

	/**
	 * @return le code du département.
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param pCodeDepartement,
	 *            le code du département.
	 */
	public void setCodeDepartement(final String pCodeDepartement) {
		this.codeDepartement = pCodeDepartement;
	}

	/**
	 * @return le code commune.
	 */
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * @param pCodeCommune,
	 *            le code de la commune.
	 */
	public void setCodeCommune(final String pCodeCommune) {
		this.codeCommune = pCodeCommune;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = 1;
		result = prime * result
				+ ((codeCommune == null) ? 0 : codeCommune.hashCode());
		result = prime * result
				+ ((codeDepartement == null) ? 0 : codeDepartement.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommuneId other = (CommuneId) obj;
		if (codeCommune == null) {
			if (other.codeCommune != null) {
				return false;
			}
		} else if (!codeCommune.equals(other.codeCommune)) {
			return false;
		}

		if (codeDepartement == null) {
			if (other.codeDepartement != null) {
				return false;
			}
		} else if (!codeDepartement.equals(other.codeDepartement)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommuneId [codeDepartement=").append(codeDepartement)
				.append(", codeCommune=").append(codeCommune).append("]");
		return builder.toString();
	}

}
