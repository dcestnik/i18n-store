package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.I18nStoreLanguage;
import i18nstore.model.I18nStoreLocale;

@Path("/languages")
@Produces(MediaType.APPLICATION_JSON)
public class LanguageResource {
    @GET
    public Set<I18nStoreLanguage> getLanguages() {
        return LocaleResource.locales
                .stream()
                .map(I18nStoreLocale::getLanguage)
                .distinct()
                .collect(Collectors.toSet());
    }

    @GET
    @Path("/{alpha2Code}")
    public I18nStoreLanguage getLanguage(@PathParam("alpha2Code") String alpha2Code) {
        return LocaleResource.locales
                .stream()
                .map(I18nStoreLocale::getLanguage)
                .filter(l -> l.getAlpha2Code().equals(alpha2Code))
                .findFirst()
                .orElse(null);
    }
}
