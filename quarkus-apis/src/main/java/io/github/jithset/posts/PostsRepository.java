package io.github.jithset.posts;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class PostsRepository implements PanacheRepository<Posts> {

    public Uni<Posts> findByUUID(UUID uuid) {
        return find("postId", uuid).firstResult();
    }

    public Uni<Long> deleteByUUID(UUID postId) {
        return delete("postId", postId);
    }
}
