package i18nstore.resources;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.Message;
import i18nstore.model.MessageValue;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResource {
    @GET
    public Set<Message> getMessages() {
        return Stream.of(
                new Message("foo", Stream.of(new MessageValue(LocaleResource.locales.stream().findAny().orElse(null), "bar")).collect(Collectors.toSet())),
                new Message("foo2", Stream.of(new MessageValue(LocaleResource.locales.stream().findAny().orElse(null), "bar2")).collect(Collectors.toSet())),
                new Message("foo3", Stream.of(new MessageValue(LocaleResource.locales.stream().findAny().orElse(null), "bar3")).collect(Collectors.toSet())))
                .collect(Collectors.toSet());
    }

    @GET
    @Path("{key}")
    public Message getMessage(@PathParam("key") String key) {
        return new Message("foo",
                Stream.of(new MessageValue(LocaleResource.locales.stream().findAny().orElse(null), "bar"))
                        .collect(Collectors.toSet()));
    }

    @GET
    @Path("{key}/values")
    public Set<MessageValue> getMessageValue(@PathParam("key") String key, @MatrixParam("locale") Optional<String> locale) {
        return new Message("foo",
                Stream.of(new MessageValue(LocaleResource.locales.stream().filter(l -> !locale.isPresent() || l.getCode().equals(locale.get())).findAny().orElse(null), "bar"))
                        .collect(Collectors.toSet())).getValues();
    }
}
