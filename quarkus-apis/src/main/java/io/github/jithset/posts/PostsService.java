package io.github.jithset.posts;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class PostsService {

    @Inject
    PostsRepository postsRepository;

    public Uni<Posts> create(@Valid Posts post) {
        return postsRepository.persistAndFlush(post).map(t -> post);
    }
    public Uni<Posts> get(UUID uuid) {
        return postsRepository.findByUUID(uuid);
    }

    public Uni<List<Posts>> getAll() {
        return postsRepository.listAll();
    }

    public Uni<Posts> update(@Valid Posts post) {
        return postsRepository.findByUUID(post.getPostId()).onItem().ifNotNull()
                .transform(original -> {
                    original.setUpdatedDate(LocalDateTime.now());
                    original.setDescription(post.getDescription());
                    original.setTitle(post.getTitle());
                    log.info("Updated Value "+ original);
                    return original;
                })
                .chain(t -> postsRepository.persist(t).chain(postsRepository::flush).map(y -> t));
    }

    public Uni<Long> delete(UUID postId) {
        return postsRepository.deleteByUUID(postId);
    }

}
