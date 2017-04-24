package nc.gouv.dtsi.etudes.axi.formation.cog.commune.population;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "popcom")
@IdClass(PopulationCommunaleId.class)
public class PopulationCommunale {

    @Column(name = "code_region")
    @Id
    private String codeRegion;

    @Column(name = "nom_region")
    private String nomRegion;

    @Column(name = "code_departement")
    @Id
    private String codeDepartement;

    @Column(name = "code_arrondissement")
    private String codeArrondissement;

    @Column(name = "code_canton")
    private String codeCanton;

    @Column(name = "code_commune")
    @Id
    private String codeCommune;

    @Column(name = "nom_commune")
    private String nomCommune;

    @Column(name = "pop_municipale")
    private String popMunicipale;

    @Column(name = "pop_a_part")
    private String popAPart;

    @Column(name = "pop_totale")
    private String popTotale;

    /**
     * @param codeRegion
     * @param nomRegion
     * @param codeDepartement
     * @param codeArrondissement
     * @param codeCanton
     * @param codeCommune
     * @param nomCommune
     * @param popMunicipale
     * @param popAPart
     * @param popTotale
     */
    public PopulationCommunale(String codeRegion, String nomRegion,
            String codeDepartement, String codeArrondissement,
            String codeCanton, String codeCommune, String nomCommune,
            String popMunicipale, String popAPart, String popTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeArrondissement = codeArrondissement;
        this.codeCanton = codeCanton;
        this.codeCommune = codeCommune;
        this.nomCommune = nomCommune;
        this.popMunicipale = popMunicipale;
        this.popAPart = popAPart;
        this.popTotale = popTotale;
    }

    /**
     * 
     */
    public PopulationCommunale() {
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
     * @return the nomRegion
     */
    public String getNomRegion() {
        return nomRegion;
    }

    /**
     * @param nomRegion
     *            the nomRegion to set
     */
    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
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
     * @return the codeArrondissement
     */
    public String getCodeArrondissement() {
        return codeArrondissement;
    }

    /**
     * @param codeArrondissement
     *            the codeArrondissement to set
     */
    public void setCodeArrondissement(String codeArrondissement) {
        this.codeArrondissement = codeArrondissement;
    }

    /**
     * @return the codeCanton
     */
    public String getCodeCanton() {
        return codeCanton;
    }

    /**
     * @param codeCanton
     *            the codeCanton to set
     */
    public void setCodeCanton(String codeCanton) {
        this.codeCanton = codeCanton;
    }

    /**
     * @return the codeCommune
     */
    public String getCodeCommune() {
        return codeCommune;
    }

    /**
     * @param codeCommune
     *            the codeCommune to set
     */
    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    /**
     * @return the nomCommune
     */
    public String getNomCommune() {
        return nomCommune;
    }

    /**
     * @param nomCommune
     *            the nomCommune to set
     */
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    /**
     * @return the popMunicipale
     */
    public String getPopMunicipale() {
        return popMunicipale;
    }

    /**
     * @param popMunicipale
     *            the popMunicipale to set
     */
    public void setPopMunicipale(String popMunicipale) {
        this.popMunicipale = popMunicipale;
    }

    /**
     * @return the popAPart
     */
    public String getPopAPart() {
        return popAPart;
    }

    /**
     * @param popAPart
     *            the popAPart to set
     */
    public void setPopAPart(String popAPart) {
        this.popAPart = popAPart;
    }

    /**
     * @return the popTotale
     */
    public String getPopTotale() {
        return popTotale;
    }

    /**
     * @param popTotale
     *            the popTotale to set
     */
    public void setPopTotale(String popTotale) {
        this.popTotale = popTotale;
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
                + ((codeCommune == null) ? 0 : codeCommune.hashCode());
        result = prime * result
                + ((codeDepartement == null) ? 0 : codeDepartement.hashCode());
        result = prime * result
                + ((codeRegion == null) ? 0 : codeRegion.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PopulationCommunale other = (PopulationCommunale) obj;
        if (codeCommune == null) {
            if (other.codeCommune != null)
                return false;
        } else if (!codeCommune.equals(other.codeCommune))
            return false;
        if (codeDepartement == null) {
            if (other.codeDepartement != null)
                return false;
        } else if (!codeDepartement.equals(other.codeDepartement))
            return false;
        if (codeRegion == null) {
            if (other.codeRegion != null)
                return false;
        } else if (!codeRegion.equals(other.codeRegion))
            return false;
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
        builder.append("PopulationCommunale [");
        if (codeRegion != null) {
            builder.append("\n\tcodeRegion=");
            builder.append(codeRegion);
            builder.append(", ");
        }
        if (nomRegion != null) {
            builder.append("\n\tnomRegion=");
            builder.append(nomRegion);
            builder.append(", ");
        }
        if (codeDepartement != null) {
            builder.append("\n\tcodeDepartement=");
            builder.append(codeDepartement);
            builder.append(", ");
        }
        if (codeArrondissement != null) {
            builder.append("\n\tcodeArrondissement=");
            builder.append(codeArrondissement);
            builder.append(", ");
        }
        if (codeCanton != null) {
            builder.append("\n\tcodeCanton=");
            builder.append(codeCanton);
            builder.append(", ");
        }
        if (codeCommune != null) {
            builder.append("\n\tcodeCommune=");
            builder.append(codeCommune);
            builder.append(", ");
        }
        if (nomCommune != null) {
            builder.append("\n\tnomCommune=");
            builder.append(nomCommune);
            builder.append(", ");
        }
        if (popMunicipale != null) {
            builder.append("\n\tpopMunicipale=");
            builder.append(popMunicipale);
            builder.append(", ");
        }
        if (popAPart != null) {
            builder.append("\n\tpopAPart=");
            builder.append(popAPart);
            builder.append(", ");
        }
        if (popTotale != null) {
            builder.append("\n\tpopTotale=");
            builder.append(popTotale);
        }
        builder.append("\n]");
        return builder.toString();
    }

}