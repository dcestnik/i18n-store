package i18nstore.model;

import java.io.Serializable;
import java.net.URI;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.glassfish.jersey.linking.InjectLink;

import i18nstore.resources.I18nStoreLocaleResource;

public class I18nStoreLocale implements Serializable {
    private static final long serialVersionUID = 1L;
    private I18nStoreCountry country;
    private I18nStoreLanguage language;
    @InjectLink(resource=I18nStoreLocaleResource.class)
    private URI self;

    public I18nStoreLocale() { }

    public I18nStoreLocale(I18nStoreCountry country, I18nStoreLanguage language) {
        this.country = country;
        this.language = language;
    }

    public I18nStoreCountry getCountry() {
        return country;
    }

    public I18nStoreLanguage getLanguage() {
        return language;
    }

    public URI getSelf() {
        return self;
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
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

        I18nStoreLocale other = (I18nStoreLocale) obj;

        return new EqualsBuilder()
                .append(getCountry(), other.getCountry())
                .append(getLanguage(), other.getLanguage())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append(getCountry())
                .append(getLanguage())
                .build();
    }
}
