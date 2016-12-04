package i18nstore.model;

import java.util.Objects;

import i18nstore.util.ObjectsUtil;

public class Message {
    private String key;
    private String value;

    public Message() { }

    public Message(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) -> Objects.equals(a.getKey(), b.getKey()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString(this, this::getKey, this::getValue);
    }

}
