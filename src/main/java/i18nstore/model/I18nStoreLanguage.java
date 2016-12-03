package i18nstore.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class I18nStoreLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String alpha2Code;
    private String name;

    public I18nStoreLanguage() {
    }

    public I18nStoreLanguage(String alpha2Code, String name) {
        this.alpha2Code = alpha2Code;
        this.name = name;
    }
    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getAlpha2Code())
                .append(getName())
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

        I18nStoreLanguage other = (I18nStoreLanguage) obj;
        return new EqualsBuilder()
                .append(getAlpha2Code(), other.getAlpha2Code())
                .append(getName(), other.getName())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append(getAlpha2Code())
                .append(getName())
                .build();
    }
}
