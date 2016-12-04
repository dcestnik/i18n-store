package i18nstore.model;

import java.io.Serializable;
import java.util.Objects;

import i18nstore.util.ObjectsUtil;;

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private String alpha2Code;
    private String alpha3Code;
    private String code;
    private String name;

    public Country() { }

    public Country(String code, String name, String alpha2Code, String alpha3Code) {
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
        return Objects.hash(getCode(), getName(), getAlpha2Code(), getAlpha3Code());
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) ->
                Objects.equals(a.getCode(), b.getCode())
                        && Objects.equals(a.getName(), b.getName())
                        && Objects.equals(a.getAlpha2Code(), b.getAlpha2Code())
                        && Objects.equals(a.getAlpha3Code(), b.getAlpha3Code()));
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString( this, this::getCode, this::getAlpha2Code, this::getAlpha3Code, this::getName);
    }
}
