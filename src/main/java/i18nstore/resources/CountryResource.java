package i18nstore.resources;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.Country;
import i18nstore.model.Locale;

@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {
    @GET
    public Set<Country> getCountries(
            @MatrixParam("alpha2Code") Optional<String> alpha2Code,
            @MatrixParam("alpha3Code") Optional<String> alpha3Code,
            @MatrixParam("name") Optional<String> name) {
        return LocaleResource.locales
                .stream()
                .map(Locale::getCountry)
                .filter(c -> !alpha2Code.isPresent() || c.getAlpha2Code().equals(alpha2Code.get()))
                .filter(c -> !alpha3Code.isPresent() || c.getAlpha3Code().equals(alpha3Code.get()))
                .filter(c -> !name.isPresent() || c.getName().equals(name.get()))
                .distinct()
                .collect(Collectors.toSet());
    }

    @GET
    @Path("{alpha2Code}")
    public Country getCountry(@PathParam("alpha2Code") String alpha2Code) {
        return LocaleResource.locales
                .stream()
                .map(Locale::getCountry)
                .filter(l -> l.getAlpha2Code().equals(alpha2Code))
                .findFirst()
                .orElse(null);
    }
}
