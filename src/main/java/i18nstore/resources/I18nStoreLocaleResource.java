package i18nstore.resources;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.I18nStoreCountry;
import i18nstore.model.I18nStoreLanguage;
import i18nstore.model.I18nStoreLocale;

@Path("/locales")
@Produces(MediaType.APPLICATION_JSON)
public class I18nStoreLocaleResource {
    static Set<I18nStoreLocale> locales = Stream.of(Locale.getAvailableLocales())
            .map(l -> new I18nStoreLocale(
                    new I18nStoreCountry(l.getCountry(), l.getDisplayCountry(), l.getCountry(), l.getCountry()),
                    new I18nStoreLanguage(l.getLanguage(), l.getDisplayLanguage())))
            .collect(Collectors.toSet());

    @GET
    public Set<I18nStoreLocale> getLocale() {
        return locales;
    }
}
