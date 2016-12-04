package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.I18nStoreCountry;
import i18nstore.model.I18nStoreLocale;

@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {

    @GET
    public Set<I18nStoreCountry> getCountries() {
        return LocaleResource.locales
                .stream()
                .map(I18nStoreLocale::getCountry)
                .distinct()
                .collect(Collectors.toSet());
    }
}
