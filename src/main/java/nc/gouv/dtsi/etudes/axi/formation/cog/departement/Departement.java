package nc.gouv.dtsi.etudes.axi.formation.cog.departement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_DEPARTEMENT")
public class Departement {

	/**
	 * Code Région
	 */
	@Column(name = "REGION")
	private String codeRegion;

	/**
	 * DEP - Code département. Il est sur 3 positions afin de prendre en compte
	 * les quatre départements des DOM.
	 */
	@Id
	@Column(name = "DEP")
	private String codeDepartement;

	/**
	 * <p>
	 * <strong>CHEFLIEU - Chef-lieu de canton, d'arrondissement, de département,
	 * de région</strong>
	 * </p>
	 * <p>
	 * Code chef-lieu
	 * </p>
	 * <table>
	 * <caption>Chef-lieu</caption>
	 * <tr>
	 * <td>0</td>
	 * <td>commune non chef-lieu</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>commune chef-lieu de canton</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>commune chef-lieu d'arrondissement</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>commune chef-lieu de département</td>
	 * </tr>
	 * <tr>
	 * <td>4</td>
	 * <td>commune chef-lieu de région</td>
	 * </tr>
	 * </table>
	 * <p>
	 * Pour les observations concernant les fractions cantonales, si la commune
	 * à laquelle appartient la fraction est chef-lieu de ce canton, la variable
	 * CHEFLIEU prendra la valeur 1. Si ce n'est pas le cas, elle prendra la
	 * valeur 0. Si la commune est au moins une fois chef-lieu de canton, la
	 * variable CHEFLIEU prendra au moins la valeur 1 pour l'observation de la
	 * commune ayant trait au canton non précisé. Si elle est également
	 * chef-lieu d'arrondissement, de département, voire de région, elle prendra
	 * les valeurs allant de 2 à 4 suivant le cas correspondant. Si la commune
	 * est chef-lieu de région, elle est obligatoirement chef-lieu des échelons
	 * supracommunaux inférieurs. De même, si elle est chef-lieu de département
	 * ou d'arrondissement, elle est chef-lieu des échelons supracommunaux
	 * inférieurs.
	 * </p>
	 * <p>
	 * Cette variable apparaît dans les fichiers de niveau communal. Il ne faut
	 * pas la confondre avec la variable cheflieu qui donne le code de la
	 * commune chef-lieu des autres niveaux géographiques.
	 * </p>
	 */
	@Column(name = "CHEFLIEU")
	private String chefLieu;

	/**
	 * <p>
	 * <strong>TNCC - Type de nom en clair</strong>
	 * </p>
	 * <p>
	 * Type de nom en clair&nbsp;; cette variable permet d'écrire le nom complet
	 * dans le cas d'un libellé avec article, et d'adapter la charnière si le
	 * nom est utilisé dans une expression comme "la commune <u>de</u>
	 * Marseille", "l'arrondissement <u>du</u> Mans", etc.
	 * </p>
	 * <p>
	 * Pour les noms de communes (et donc de canton et d'arrondissement),
	 * l'article est obligatoire ("Rochelle" n'existe pas sans article), alors
	 * que ce n'est pas le cas pour les noms de département ou de région
	 * ("Charente-Maritime" peut être écrit sans article). Pour les département
	 * et les régions, ce code ne sert donc que pour la charnière.
	 * </p>
	 * <table summary="Codes de la variable TNCC">
	 * <tr>
	 * <td>0</td>
	 * <td>pas d'article et le nom commence par une consonne sauf H muet.</td>
	 * <td>charnière = DE</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>pas d'article et le nom commence par une voyelle ou un H muet.</td>
	 * <td>charnière = D'</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>article = LE</td>
	 * <td>charnière = DU</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>article = LA</td>
	 * <td>charnière = DE LA</td>
	 * </tr>
	 * <tr>
	 * <td>4</td>
	 * <td>article = LES</td>
	 * <td>charnière = DES</td>
	 * </tr>
	 * <tr>
	 * <td>5</td>
	 * <td>article = L'</td>
	 * <td>charnière = DE L'</td>
	 * </tr>
	 * <tr>
	 * <td>6</td>
	 * <td>article = AUX</td>
	 * <td>charnière = DES</td>
	 * </tr>
	 * <tr>
	 * <td>7</td>
	 * <td>article = LAS</td>
	 * <td>charnière = DE LAS</td>
	 * </tr>
	 * <tr>
	 * <td>8</td>
	 * <td>article = LOS</td>
	 * <td>charnière = DE LOS</td>
	 * </tr>
	 * </table>
	 * <p>
	 * <u>Exemple pour une commune</u> :
	 * </p>
	 * <table summary="Exemple de TNCC">
	 * <tr>
	 * <td>Com = 104</td>
	 * <td>Dep = 66</td>
	 * <td>NCC = MASOS</td>
	 * <td>TNCC = 8</td>
	 * <td>charnière = DE LOS</td>
	 * <td>article = LOS</td>
	 * </tr>
	 * </table>
	 * <p>
	 * Nom de la commune = LOS MASOS
	 * </p>
	 * <p>
	 * Commune DE LOS MASOS
	 * </p>
	 * 
	 */
	@Column(name = "TNCC")
	private String typeDeNomEnClair;

	/**
	 * NCC - Nom en clair (majuscules) Libellé en lettres majuscules
	 */
	@Column(name = "NCC")
	private String nomEnClair;

	/**
	 * NCCENR - Nom en clair (typographie riche) Libellé en typographie riche,
	 * majuscules, minuscules, accentuation.
	 */
	@Column(name = "NCCENR")
	private String nomTypoEnrichie;

	/**
	 * Default constructor
	 */
	public Departement() {
	}

	/**
	 * @param pCodeRegion,
	 *            le code région.
	 * @param pCodeDepartement,
	 *            le code département.
	 * @param pChefLieu,
	 *            le code commune de la commune chef lieu.
	 * @param pTypeDeNomEnClair,
	 *            le type de nom en clair.
	 * @param pNomEnClair,
	 *            le nom en clair.
	 * @param pNomTypoEnrichie,
	 *            le nom avec une typographie enrichie.
	 */
	public Departement(final String pCodeRegion, final String pCodeDepartement,
			final String pChefLieu, final String pTypeDeNomEnClair,
			final String pNomEnClair, final String pNomTypoEnrichie) {
		this.codeRegion = pCodeRegion;
		this.codeDepartement = pCodeDepartement;
		this.chefLieu = pChefLieu;
		this.typeDeNomEnClair = pTypeDeNomEnClair;
		nomEnClair = pNomEnClair;
		this.nomTypoEnrichie = pNomTypoEnrichie;
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

	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param codeDepartement
	 *            the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * @return the chefLieu
	 */
	public String getChefLieu() {
		return chefLieu;
	}

	/**
	 * @param chefLieu
	 *            the chefLieu to set
	 */
	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}

	/**
	 * @return the typeDeNomEnClair
	 */
	public String getTypeDeNomEnClair() {
		return typeDeNomEnClair;
	}

	/**
	 * @param typeDeNomEnClair
	 *            the typeDeNomEnClair to set
	 */
	public void setTypeDeNomEnClair(String typeDeNomEnClair) {
		this.typeDeNomEnClair = typeDeNomEnClair;
	}

	/**
	 * @return the nomEnClair
	 */
	public String getNomEnClair() {
		return nomEnClair;
	}

	/**
	 * @param nomEnClair
	 *            the nomEnClair to set
	 */
	public void setNomEnClair(String nomEnClair) {
		this.nomEnClair = nomEnClair;
	}

	/**
	 * @return the nomTypoEnrichie
	 */
	public String getNomTypoEnrichie() {
		return nomTypoEnrichie;
	}

	/**
	 * @param nomTypoEnrichie
	 *            the nomTypoEnrichie to set
	 */
	public void setNomTypoEnrichie(String nomTypoEnrichie) {
		this.nomTypoEnrichie = nomTypoEnrichie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Departement other = (Departement) obj;
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
		builder.append("Departement [\n\tcodeRegion=").append(codeRegion)
				.append("[\n\t, codeDepartement=").append(codeDepartement)
				.append("[\n\t, chefLieu=").append(chefLieu)
				.append("[\n\t, typeDeNomEnClair=").append(typeDeNomEnClair)
				.append("[\n\t, NomEnClair=").append(nomEnClair)
				.append("[\n\t, nomTypoEnrichie=").append(nomTypoEnrichie)
				.append("[\n]");
		return builder.toString();
	}

}
