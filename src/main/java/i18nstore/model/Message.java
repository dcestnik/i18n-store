package i18nstore.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import i18nstore.util.ObjectsUtil;

public class Message {
    private String key;
    private Set<MessageValue> values;

    public Message() { }

    public Message(String key, Set<MessageValue> values) {
        this.key = key;
        this.values = values;
    }

    public String getKey() {
        return key;
    }

    public Set<MessageValue> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        return ObjectsUtil.isEqual(this, obj, (a, b) ->
                Objects.equals(a.getKey(), b.getKey())
                && Objects.equals(a.getValues(), b.getValues()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValues());
    }

    @Override
    public String toString() {
        return ObjectsUtil.toJSonString(this, this::getKey, this::getValues);
    }

}
