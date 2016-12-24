package i18nstore.model;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import i18nstore.resources.LocaleResource;
import i18nstore.util.ObjectsUtil;

public class Locale implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private Country country;
    private Language language;
    @InjectLink(resource = LocaleResource.class, style = Style.ABSOLUTE, method = "getLocale")
    private URI self;

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

    public URI getSelf() {
        return self;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getCountry(), getLanguage());
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) ->
                Objects.equals(a.getCode(), b.getCode())
                        && Objects.equals(a.getCountry(), b.getCountry())
                        && Objects.equals(a.getLanguage(), b.getLanguage()));
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString(this, this::getCode, this::getCountry, this::getLanguage);
    }
}
