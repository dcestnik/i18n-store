package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.Country;
import i18nstore.model.Language;
import i18nstore.model.Locale;

@Path("/locales")
@Produces(MediaType.APPLICATION_JSON)
public class LocaleResource {
    static Set<Locale> locales = Stream.of(java.util.Locale.getAvailableLocales())
            .map(l -> new Locale(
                    new Country(l.getCountry(), l.getDisplayCountry(), l.getCountry(), l.getCountry()),
                    new Language(l.getLanguage(), l.getDisplayLanguage())))
            .collect(Collectors.toSet());

    @GET
    public Set<Locale> getLocale() {
        return locales;
    }
}
