package i18nstore.model;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import i18nstore.resources.LanguageResource;
import i18nstore.util.ObjectsUtil;;

public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    private String alpha2Code;
    private String name;
    @InjectLink(resource = LanguageResource.class, style = Style.ABSOLUTE, method = "getLanguage")
    private URI self;

    public Language() { }

    public Language(String alpha2Code, String name) {
        this.alpha2Code = alpha2Code;
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getName() {
        return name;
    }

    public URI getSelf() {
        return self;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlpha2Code(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) ->
                Objects.equals(a.getAlpha2Code(), b.getAlpha2Code())
                        && Objects.equals(a.getName(), b.getName()));
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString(this, this::getAlpha2Code, this::getName);
    }
}
