package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
                    l.toString(),
                    new Country( l.getDisplayCountry(), l.getCountry(), l.getCountry()),
                    new Language(l.getLanguage(), l.getDisplayLanguage())))
            .collect(Collectors.toSet());

    @GET
    public Set<Locale> getLocales() {
        return locales;
    }

    @GET
    @Path("{code}")
    public Locale getLocale(@PathParam("code") String code) {
        return locales.stream()
                .filter(l -> l.getCode().equals(code))
                .findFirst().orElse(null);
    }

    @GET
    @Path("{code}/country")
    public Country getLocaleCountry(@PathParam("code") String code) {
        return locales.stream()
                .filter(l -> l.getCode().equals(code))
                .map(Locale::getCountry)
                .findFirst()
                .orElse(null);
    }

    @GET
    @Path("{code}/language")
    public Language getLocaleLanguage(@PathParam("code") String code) {
        return locales.stream()
                .filter(l -> l.getCode().equals(code))
                .map(Locale::getLanguage)
                .findFirst()
                .orElse(null);
    }
}
