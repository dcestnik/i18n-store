package i18nstore.resources;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import i18nstore.model.Message;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResource {
    @GET
    public Set<Message> getMessages() {
        return Stream.of(new Message("foo", "bar"), new Message("foo1", "bar1"), new Message("foo2", "bar2"))
                .collect(Collectors.toSet());
    }

    @GET
    @Path("{key}")
    public Message getMessage(@PathParam("key") String key) {
        return new Message("foo", "bar");
    }
}
