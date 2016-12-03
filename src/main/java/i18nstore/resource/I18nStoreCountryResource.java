package i18nstore.resource;

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
public class I18nStoreCountryResource {

    @GET
    public Set<I18nStoreCountry> getCountries() {
        return I18nStoreLocaleResource.locales
                .stream()
                .map(I18nStoreLocale::getCountry)
                .distinct()
                .collect(Collectors.toSet());
    }
}
