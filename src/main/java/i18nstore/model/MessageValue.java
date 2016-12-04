package i18nstore.model;


import java.util.Objects;

import i18nstore.util.ObjectsUtil;

public class MessageValue {
    private Locale locale;
    private String text;

    public MessageValue() { }

    public MessageValue(Locale locale, String text) {
        this.locale = locale;
        this.text = text;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) ->
                Objects.equals(a.getLocale(), b.getLocale())
                        && Objects.equals(a.getText(), b.getText()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocale(), getText());
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString(this, this::getLocale, this::getText);
    }

}
