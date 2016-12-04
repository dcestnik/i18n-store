package i18nstore.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Locale implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private Country country;
    private Language language;

    public Locale() { }

    public Locale(String code, Country country, Language language) {
        this.code = code;
        this.country = country;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public Country getCountry() {
        return country;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCode())
                .append(getCountry())
                .append(getLanguage())
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

        Locale other = (Locale) obj;

        return new EqualsBuilder()
                .append(getCode(), other.getCode())
                .append(getCountry(), other.getCountry())
                .append(getLanguage(), other.getLanguage())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append(getCode())
                .append(getCountry())
                .append(getLanguage())
                .build();
    }
}
