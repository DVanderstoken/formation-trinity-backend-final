package nc.gouv.dtsi.etudes.axi.formation.cog.commune.population;

import java.io.Serializable;

public class PopulationCommunaleId implements Serializable {

    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = 1792544664613086746L;
    private String codeRegion;
    private String codeDepartement;
    private String codeCommune;

    /**
     * 
     */
    public PopulationCommunaleId() {
    }

    /**
     * @param codeRegion
     * @param codeDepartement
     * @param codeCommune
     */
    public PopulationCommunaleId(String codeRegion, String codeDepartement,
            String codeCommune) {
        this.codeRegion = codeRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommune = codeCommune;
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
        PopulationCommunaleId other = (PopulationCommunaleId) obj;
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
        builder.append("PopulationCommunaleId [");
        if (codeRegion != null) {
            builder.append("\n\tcodeRegion=");
            builder.append(codeRegion);
            builder.append(", ");
        }
        if (codeDepartement != null) {
            builder.append("\n\tcodeDepartement=");
            builder.append(codeDepartement);
            builder.append(", ");
        }
        if (codeCommune != null) {
            builder.append("\n\tcodeCommune=");
            builder.append(codeCommune);
        }
        builder.append("\n]");
        return builder.toString();
    }

}
