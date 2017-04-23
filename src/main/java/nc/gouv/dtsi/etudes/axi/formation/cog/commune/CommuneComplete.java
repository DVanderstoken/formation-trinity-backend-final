package nc.gouv.dtsi.etudes.axi.formation.cog.commune;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "T_COMMUNE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
		@NamedQuery(name = "findAllCommunes", query = "SELECT cc FROM CommuneComplete cc"),
		@NamedQuery(name = "findCommunesByDept", query = "SELECT cc FROM CommuneComplete cc WHERE codeDepartement = :pCodeDepartement"),
		@NamedQuery(name = "findCommune", query = "SELECT cc FROM CommuneComplete cc WHERE codeDepartement = :pCodeDepartement AND codeCommune = :pCodeCommune") })
public final class CommuneComplete extends Commune implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8789159459611939821L;

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
	 * <p>
	 * <strong>ACTUAL - Code actualité de la commune</strong>
	 * </p>
	 * <p>
	 * Code actualité de la commune à la date du fichier
	 * </p>
	 * <table>
	 * <caption>Code actualité de la commune à la date du fichier</caption>
	 * <tr>
	 * <td>1</td>
	 * <td>commune actuelle</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>commune "associée"</td>
	 * </tr>
	 * <tr>
	 * <td>3</td>
	 * <td>commune périmée</td>
	 * </tr>
	 * <tr>
	 * <td>4</td>
	 * <td>ancien code dû à un changement de département</td>
	 * </tr>
	 * <tr>
	 * <td>5</td>
	 * <td>arrondissement municipal</td>
	 * </tr>
	 * <tr>
	 * <td>6</td>
	 * <td>fraction cantonale</td>
	 * </tr>
	 * </table>
	 * <p>
	 * Pour les communes découpées en fractions cantonales, chaque fraction
	 * cantonale prend pour cette variable la modalité 6&nbsp;; pour
	 * l'observation "canton non précisé", cette variable prend la modalité 1.
	 * En sélectionnant ainsi la modalité 1 de ACTUAL, on obtient toutes les
	 * communes actuelles à la date de référence. Pour les communes périmées ou
	 * associées, les variables ayant trait à un zonage administratif (CHEFLIEU,
	 * CDC, RANG, ARR, CT) ne sont pas renseignées.
	 * </p>
	 */
	@Column(name = "ACTUAL")
	private String codeActualite;

	/**
	 * <p>
	 * <strong>CDC - Découpage de la commune en cantons</strong>
	 * </p>
	 * <p>
	 * Découpage de la commune en cantons
	 * </p>
	 * <table>
	 * <caption>Découpage de la commune en cantons</caption>
	 * <tr>
	 * <td>0</td>
	 * <td>commune non découpée en cantons</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>fraction cantonale</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>canton non précisé</td>
	 * </tr>
	 * </table>
	 */
	@Column(name = "CDC")
	private String estDecoupeEnCanton;

	/**
	 * <p>
	 * <strong>RANG - Nombre de fractions cantonales + 1 de la commune
	 * lorsqu'elle est multicantonale</strong>
	 * </p>
	 * <p>
	 * Nombre de fractions cantonales + 1 des communes découpées en cantons.
	 * </p>
	 * <p>
	 * Ce code n'est renseigné que pour les communes multicantonales (CDC
	 * supérieur à 0).
	 * </p>
	 * <p>
	 * Cette variable est renseignée pour toutes les observations d'une commune
	 * découpée en fractions cantonales.
	 * </p>
	 */
	@Column(name = "RANG", nullable = true)
	private Integer fractionCantonale;

	/**
	 * Code de l'arrondissement.
	 */
	@Column(name = "AR")
	private String codeArrondissement;

	/**
	 * <p>
	 * <strong>CT - Code canton</strong>
	 * </p>
	 * <p>
	 * Dans le cas des communes découpées en cantons, les différentes fractions
	 * cantonales de la commune figurent avec leur numéro de code dans la liste
	 * de la commune. Il est également renseigné pour ces communes un numéro de
	 * code pour les "cantons non précisés". Il est généralement utilisé lorsque
	 * l'on ne veut pas ou que l'on ne peut pas caractériser une fraction
	 * cantonale pour la commune. Le code de canton non précisé ne s'adresse
	 * donc qu'à des communes entières. A l'heure actuelle les valeurs des
	 * cantons non précisés sont comprises entre 84 et 99.
	 * </p>
	 */
	@Column(name = "CT")
	private String codeCanton;

	/**
	 * <p>
	 * <strong>MODIF - Indicateur de modification subie par la commune</strong>
	 * </p>
	 * <p>
	 * Indicateur de modification subie par la commune
	 * </p>
	 * <ul class="codes">
	 * <li>0 = commune non touchée par un événement</li>
	 * <li>1 = commune touchée par un événement</li>
	 * </ul>
	 * <p>
	 * Ces événements font référence aux événements contenus dans le nouveau
	 * fichier historique, décrit ci-après. Cela concerne les "événements"
	 * suivants&nbsp;: changement de nom, création, rétablissement, fusion,
	 * fusion-association, fusion-association se transformant en fusion simple,
	 * changement de département, d'arrondissement et de canton, transfert de
	 * chef-lieu de commune et échange de parcelles avec transfert de
	 * population.
	 * </p>
	 * <p>
	 * Les 6 premiers "événements" sont renseignés depuis 1943. Les autres ont
	 * été initialisés avec le nouveau répertoire, depuis 1994.
	 * </p>
	 */
	@Column(name = "MODIF")
	private String indicateurModification;

	/**
	 * <p>
	 * <strong>POLE - Code de la commune pôle de la commune fusionnée</strong>
	 * </p>
	 * <p>
	 * Code de la commune à laquelle s'est fusionnée la commune associée (ACTUAL
	 * = '2') ou la commune périmée (ACTUAL = '3'), ou nouveau code de la
	 * commune suite à son transfert de département, y compris la Corse et
	 * l'Île-de-France (ACTUAL ='4').
	 * </p>
	 * <p>
	 * Pour les arrondissements municipaux (ACTUAL = '5'), la variable POLE
	 * prend pour valeur le code de la commune auquel appartient
	 * l'arrondissement.
	 * </p>
	 * <p>
	 * Pour les autres valeurs de la variable ACTUAL, la variable POLE n'est pas
	 * renseignée.
	 * </p>
	 * <p>
	 * Le code de la commune pôle est renseigné sur 5 positions, les deux
	 * premiers caractérisant le département, les trois derniers donnant un
	 * numéro d'ordre dans le département.
	 * </p>
	 */
	@Column(name = "POLE")
	private String codeComPole;

	/**
	 * <p>
	 * <strong>ARTMAJ - Article (majuscules)</strong>
	 * </p>
	 * <p>
	 * L'article est décodé en fonction des modalités du code TNCC et encadré de
	 * parenthèses. ARTMAJ est en caractères majuscules et ARTMIN en caractères
	 * enrichis.
	 * </p>
	 */
	@Column(name = "ARTMAJ")
	private String articleMajuscule;

	/**
	 * Article du canton
	 */
	@Column(name = "ARTICLCT")
	private String articleCanton;

	/**
	 * <p>
	 * <strong>NCCCT - Nom en clair du canton (typographie riche)</strong>
	 * </p>
	 * <p>
	 * Libellé du canton auquel appartient la commune en typographie riche.
	 * </p>
	 * <p>
	 * Pour les cantons non précisés, NCCCT prend la valeur "canton non
	 * précisé".
	 * </p>
	 */
	@Column(name = "NCCCT")
	private String nomCanton;

	/**
	 * Default constructor
	 */
	public CommuneComplete() {
	}

	/**
	 * @param pCodeRegion,
	 *            le code région d'appartenance de la commune.
	 * @param pCodeDepartement,
	 *            le code du département d'appartenance de la commune.
	 * @param pChefLieu,
	 *            indicateur de chef-lieu.
	 * @param pTypeDeNomEnClair,
	 *            le type de nom en clair.
	 * @param pNomEnClair,
	 *            le nom en clair.
	 * @param pNomTypoEnrichie,
	 *            le nom (typographie enrichie).
	 * @param pCodeActualite,
	 *            le code actualité.
	 * @param pEstDecoupeEnCanton,
	 *            indicateur de découpage de la commune en cantons.
	 * @param pFractionCantonale,
	 *            la fraction cantonale.
	 * @param pCodeCommune,
	 *            le code de la commune.
	 * @param pCodeArrondissement,
	 *            le code de l'arrondissement dans la commune.
	 * @param pCodeCanton,
	 *            le code canton.
	 * @param pIndicateurModification,
	 *            l'indicateur de modification.
	 * @param pCodeComPole,
	 *            le code pôle.
	 * @param pArticleMajuscule,
	 *            l'article en majuscules.
	 * @param pArticleTypoEnrichie,
	 *            l'article (typographie enrichie).
	 * @param pArticleCanton,
	 *            l'article du canton.
	 * @param pNomCanton,
	 *            le nom du canton.
	 */
	public CommuneComplete(final String pCodeRegion,
			final String pCodeDepartement, final String pChefLieu,
			final String pTypeDeNomEnClair, final String pNomEnClair,
			final String pNomTypoEnrichie, final String pCodeActualite,
			final String pEstDecoupeEnCanton, final Integer pFractionCantonale,
			final String pCodeCommune, final String pCodeArrondissement,
			final String pCodeCanton, final String pIndicateurModification,
			final String pCodeComPole, final String pArticleMajuscule,
			final String pArticleTypoEnrichie, final String pArticleCanton,
			final String pNomCanton) {
		this.codeRegion = pCodeRegion;
		this.codeDepartement = pCodeDepartement;
		this.chefLieu = pChefLieu;
		this.typeDeNomEnClair = pTypeDeNomEnClair;
		this.nomEnClair = pNomEnClair;
		this.nomTypoEnrichie = pNomTypoEnrichie;
		this.codeActualite = pCodeActualite;
		this.estDecoupeEnCanton = pEstDecoupeEnCanton;
		this.fractionCantonale = pFractionCantonale;
		this.codeCommune = pCodeCommune;
		this.codeArrondissement = pCodeArrondissement;
		this.codeCanton = pCodeCanton;
		this.indicateurModification = pIndicateurModification;
		this.codeComPole = pCodeComPole;
		this.articleMajuscule = pArticleMajuscule;
		this.articleTypoEnrichie = pArticleTypoEnrichie;
		this.articleCanton = pArticleCanton;
		this.nomCanton = pNomCanton;
	}

	/**
	 * Constructor from superclass with instance.
	 * 
	 * @param communeAbregee,
	 *            la commune en version abrégée.
	 */
	public CommuneComplete(final CommuneAbregee communeAbregee) {
		super();
		this.codeDepartement = communeAbregee.getCodeDepartement();
		this.codeCommune = communeAbregee.getCodeCommune();
		this.articleTypoEnrichie = communeAbregee.getArticleTypoEnrichie();
		this.nomTypoEnrichie = communeAbregee.getNomTypoEnrichie();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commune [\n\tcodeRegion=").append(codeRegion)
				.append("\n\t, codeDepartement=").append(codeDepartement)
				.append("\n\t, chefLieu=").append(chefLieu)
				.append("\n\t, typeDeNomEnClair=").append(typeDeNomEnClair)
				.append("\n\t, nomEnClair=").append(nomEnClair)
				.append("\n\t, nomTypoEnrichie=").append(nomTypoEnrichie)
				.append("\n\t, codeActualite=").append(codeActualite)
				.append("\n\t, estDecoupeEnCanton=").append(estDecoupeEnCanton)
				.append("\n\t, fractionCantonale=").append(fractionCantonale)
				.append("\n\t, codeCommune=").append(codeCommune)
				.append("\n\t, codeArrondissement=").append(codeArrondissement)
				.append("\n\t, codeCanton=").append(codeCanton)
				.append("\n\t, indicateurModification=")
				.append(indicateurModification).append("\n\t, codeComPole=")
				.append(codeComPole).append("\n\t, articleMajuscule=")
				.append(articleMajuscule).append("\n\t, articleTypoEnrichie=")
				.append(articleTypoEnrichie).append("\n\t, articleCanton=")
				.append(articleCanton).append("\n\t, nomCanton=")
				.append(nomCanton).append("\n]");
		return builder.toString();
	}

	/**
	 * @return the codeDepartement
	 */
	@Override
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param pCodeDepartement
	 *            the codeDepartement to set
	 */
	@Override
	public void setCodeDepartement(final String pCodeDepartement) {
		this.codeDepartement = pCodeDepartement;
	}

	/**
	 * @return the chefLieu
	 */
	public String getChefLieu() {
		return chefLieu;
	}

	/**
	 * @param pChefLieu
	 *            the chefLieu to set
	 */
	public void setChefLieu(final String pChefLieu) {
		this.chefLieu = pChefLieu;
	}

	/**
	 * @return the typeDeNomEnClair
	 */
	public String getTypeDeNomEnClair() {
		return typeDeNomEnClair;
	}

	/**
	 * @param pTypeDeNomEnClair
	 *            the typeDeNomEnClair to set
	 */
	public void setTypeDeNomEnClair(final String pTypeDeNomEnClair) {
		this.typeDeNomEnClair = pTypeDeNomEnClair;
	}

	/**
	 * @return the nomEnClair
	 */
	public String getNomEnClair() {
		return nomEnClair;
	}

	/**
	 * @param pNomEnClair
	 *            the nomEnClair to set
	 */
	public void setNomEnClair(final String pNomEnClair) {
		this.nomEnClair = pNomEnClair;
	}

	/**
	 * @return the nomTypoEnrichie
	 */
	@Override
	public String getNomTypoEnrichie() {
		return nomTypoEnrichie;
	}

	/**
	 * @param pNomTypoEnrichie
	 *            the nomTypoEnrichie to set
	 */
	@Override
	public void setNomTypoEnrichie(final String pNomTypoEnrichie) {
		this.nomTypoEnrichie = pNomTypoEnrichie;
	}

	/**
	 * @return the codeActualite
	 */
	public String getCodeActualite() {
		return codeActualite;
	}

	/**
	 * @param pCodeActualite
	 *            the codeActualite to set
	 */
	public void setCodeActualite(final String pCodeActualite) {
		this.codeActualite = pCodeActualite;
	}

	/**
	 * @return the estDecoupeEnCanton
	 */
	public String getEstDecoupeEnCanton() {
		return estDecoupeEnCanton;
	}

	/**
	 * @param pEstDecoupeEnCanton
	 *            the estDecoupeEnCanton to set
	 */
	public void setEstDecoupeEnCanton(final String pEstDecoupeEnCanton) {
		this.estDecoupeEnCanton = pEstDecoupeEnCanton;
	}

	/**
	 * @return the fractionCantonale
	 */
	public Integer getFractionCantonale() {
		return fractionCantonale;
	}

	/**
	 * @param pFractionCantonale
	 *            the fractionCantonale to set
	 */
	public void setFractionCantonale(final Integer pFractionCantonale) {
		this.fractionCantonale = pFractionCantonale;
	}

	/**
	 * @return the codeCommune
	 */
	@Override
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * @param pCodeCommune
	 *            the codeCommune to set
	 */
	@Override
	public void setCodeCommune(final String pCodeCommune) {
		this.codeCommune = pCodeCommune;
	}

	/**
	 * @return the codeArrondissement
	 */
	public String getCodeArrondissement() {
		return codeArrondissement;
	}

	/**
	 * @param pCodeArrondissement
	 *            the codeArrondissement to set
	 */
	public void setCodeArrondissement(final String pCodeArrondissement) {
		this.codeArrondissement = pCodeArrondissement;
	}

	/**
	 * @return the codeCanton
	 */
	public String getCodeCanton() {
		return codeCanton;
	}

	/**
	 * @param pCodeCanton
	 *            the codeCanton to set
	 */
	public void setCodeCanton(final String pCodeCanton) {
		this.codeCanton = pCodeCanton;
	}

	/**
	 * @return the indicateurModification
	 */
	public String getIndicateurModification() {
		return indicateurModification;
	}

	/**
	 * @param pIndicateurModification
	 *            the indicateurModification to set
	 */
	public void setIndicateurModification(
			final String pIndicateurModification) {
		this.indicateurModification = pIndicateurModification;
	}

	/**
	 * @return the codeComPole
	 */
	public String getCodeComPole() {
		return codeComPole;
	}

	/**
	 * @param pCodeComPole
	 *            the codeComPole to set
	 */
	public void setCodeComPole(final String pCodeComPole) {
		this.codeComPole = pCodeComPole;
	}

	/**
	 * @return the articleMajuscule
	 */
	public String getArticleMajuscule() {
		return articleMajuscule;
	}

	/**
	 * @param pArticleMajuscule
	 *            the articleMajuscule to set
	 */
	public void setArticleMajuscule(final String pArticleMajuscule) {
		this.articleMajuscule = pArticleMajuscule;
	}

	/**
	 * @return the articleTypoEnrichie
	 */
	@Override
	public String getArticleTypoEnrichie() {
		return articleTypoEnrichie;
	}

	/**
	 * @param pArticleTypoEnrichie
	 *            the articleTypoEnrichie to set
	 */
	@Override
	public void setArticleTypoEnrichie(final String pArticleTypoEnrichie) {
		this.articleTypoEnrichie = pArticleTypoEnrichie;
	}

	/**
	 * @return the articleCanton
	 */
	public String getArticleCanton() {
		return articleCanton;
	}

	/**
	 * @param pArticleCanton
	 *            the articleCanton to set
	 */
	public void setArticleCanton(final String pArticleCanton) {
		this.articleCanton = pArticleCanton;
	}

	/**
	 * @return the nomCanton
	 */
	public String getNomCanton() {
		return nomCanton;
	}

	/**
	 * @param pNomCanton
	 *            the nomCanton to set
	 */
	public void setNomCanton(final String pNomCanton) {
		this.nomCanton = pNomCanton;
	}

}