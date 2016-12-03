package i18nstore.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class I18nStoreCountry implements Serializable {
    private static final long serialVersionUID = 1L;
    private String alpha2Code;
    private String alpha3Code;
    private String code;
    private String name;

    public I18nStoreCountry() { }

    public I18nStoreCountry(String code, String name, String alpha2Code, String alpha3Code) {
        this.code = code;
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCode())
                .append(getName())
                .append(getAlpha2Code())
                .append(getAlpha3Code())
                .toHashCode();
    }

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

        I18nStoreCountry other = (I18nStoreCountry) obj;
        return new EqualsBuilder()
                .append(getCode(), other.getCode())
                .append(getName(), other.getName())
                .append(getAlpha2Code(), other.getAlpha2Code())
                .append(getAlpha3Code(), other.getAlpha3Code())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append(getCode())
                .append(getName())
                .append(getAlpha2Code())
                .append(getAlpha3Code())
                .build();
    }
}
