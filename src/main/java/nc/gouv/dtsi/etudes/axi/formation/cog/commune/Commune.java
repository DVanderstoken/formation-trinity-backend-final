package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@IdClass(CommuneId.class)
public class Commune implements Serializable {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7292694884965248230L;

	/**
	 * Code de la region de la commune.
	 */
	@Id
	@Column(name = "REG", insertable = false, updatable = false)
	protected String codeRegion;

	/**
	 * Code du département de la commune.
	 */
	@Id
	@Column(name = "DEP", insertable = false, updatable = false)
	protected String codeDepartement;

	/**
	 * Code de la commune.
	 */
	@Id
	@Column(name = "COM", insertable = false, updatable = false)
	protected String codeCommune;

	/**
	 * <p>
	 * <strong>ARTMIN - Article (typographie riche)</strong>
	 * </p>
	 * <p>
	 * L'article est décodé en fonction des modalités du code
	 * <a href="#tncc">TNCC</a> et encadré de parenthèses.
	 * </p>
	 * <p>
	 * ARTMAJ est en caractères majuscules et ARTMIN en caractères enrichis.
	 * </p>
	 */
	@Column(name = "ARTMIN")
	protected String articleTypoEnrichie;

	/**
	 * NCCENR - Nom en clair (typographie riche) Libellé en typographie riche,
	 * majuscules, minuscules, accentuation.
	 */
	@Column(name = "NCCENR")
	protected String nomTypoEnrichie;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommuneAbregee [\n\tcodeRegion=");
		builder.append(codeRegion);
		builder.append("codeDepartement=");
		builder.append(codeDepartement);
		builder.append("\n\t, codeCommune=");
		builder.append(codeCommune);
		builder.append("\n\t, articleTypoEnrichie=");
		builder.append(articleTypoEnrichie);
		builder.append("\n\t, nomTypoEnrichie=");
		builder.append(nomTypoEnrichie);
		builder.append("\n]");
		return builder.toString();
	}

	/**
	 * @return the codeCommune
	 */
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * @param pCodeCommune
	 *            the codeCommune to set
	 */
	public void setCodeCommune(final String pCodeCommune) {
		this.codeCommune = pCodeCommune;
	}

	/**
	 * @return the articleTypoEnrichie
	 */
	public String getArticleTypoEnrichie() {
		return articleTypoEnrichie;
	}

	/**
	 * @param pArticleTypoEnrichie
	 *            the articleTypoEnrichie to set
	 */
	public void setArticleTypoEnrichie(final String pArticleTypoEnrichie) {
		this.articleTypoEnrichie = pArticleTypoEnrichie;
	}

	/**
	 * @return the nomTypoEnrichie
	 */
	public String getNomTypoEnrichie() {
		return nomTypoEnrichie;
	}

	/**
	 * @param pNomTypoEnrichie
	 *            the nomTypoEnrichie to set
	 */
	public void setNomTypoEnrichie(final String pNomTypoEnrichie) {
		this.nomTypoEnrichie = pNomTypoEnrichie;
	}

	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param pCodeDepartement
	 *            the codeDepartement to set
	 */
	public void setCodeDepartement(final String pCodeDepartement) {
		this.codeDepartement = pCodeDepartement;
	}

	/**
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/**
	 * @param codeRegion
	 *            the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

}
