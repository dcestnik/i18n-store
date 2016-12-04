package i18nstore.util;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ObjectsUtil {
    private ObjectsUtil() { }

    public static <T, U> boolean isEqual(T obj, Object obj2, BiFunction<T, T, Boolean> f) {
        if (obj == obj2) {
            return true;
        }

        if ((obj2 == null) || (obj.getClass() != obj2.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked")
        T other = (T) obj2;
        return f.apply(obj, other);
    }

    @SafeVarargs
    public static <T> String toJSonString(T obj, Supplier<T>... suppliers) {
        ToStringBuilder toStringBuilder = new ToStringBuilder(obj, JSON_STYLE);
        Stream.of(suppliers).forEach(toStringBuilder::append);
        return toStringBuilder.build();
    }
}
