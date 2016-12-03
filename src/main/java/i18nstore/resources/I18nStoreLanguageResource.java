package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.I18nStoreLanguage;
import i18nstore.model.I18nStoreLocale;

@Path("/languages")
@Produces(MediaType.APPLICATION_JSON)
public class I18nStoreLanguageResource {

    @GET
    public Set<I18nStoreLanguage> getLanguages() {
        return I18nStoreLocaleResource.locales
                .stream()
                .map(I18nStoreLocale::getLanguage)
                .distinct()
                .collect(Collectors.toSet());
    }
}
