package io.github.jithset.posts;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/api/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostsResources {

    @Inject
    PostsService postsService;

    @POST
    public Uni<Posts> create(@Valid Posts post) {
        return postsService.create(post);
    }
    @GET
    public Uni<List<Posts>> getAll() {
        return postsService.getAll();
    }
    @GET
    @Path("/{uuid}")
    public Uni<Posts> get(@RestPath UUID uuid) {
        return postsService.get(uuid);
    }

    @DELETE
    @Path("/{uuid}")
    public Uni<Long> delete(@RestPath UUID uuid) {
        return postsService.delete(uuid);
    }

    @PATCH
    public Uni<Posts> update(Posts posts) {
        return postsService.update(posts);
    }
}
