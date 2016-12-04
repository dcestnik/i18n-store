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

import i18nstore.model.Language;
import i18nstore.model.Locale;

@Path("/languages")
@Produces(MediaType.APPLICATION_JSON)
public class LanguageResource {
    @GET
    public Set<Language> getLanguages(
            @MatrixParam("alpha2Code") Optional<String> alpha2Code,
            @MatrixParam("name") Optional<String> name) {
        return LocaleResource.locales
                .stream()
                .map(Locale::getLanguage)
                .filter(l -> !alpha2Code.isPresent() || l.getAlpha2Code().equals(alpha2Code.get()))
                .filter(l -> !name.isPresent() || l.getName().equals(name.get()))
                .distinct()
                .collect(Collectors.toSet());
    }

    @GET
    @Path("/{alpha2Code}")
    public Language getLanguage(@PathParam("alpha2Code") String alpha2Code) {
        return LocaleResource.locales
                .stream()
                .map(Locale::getLanguage)
                .filter(l -> l.getAlpha2Code().equals(alpha2Code))
                .findFirst()
                .orElse(null);
    }
}
