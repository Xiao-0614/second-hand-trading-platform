package com.chloekarah.postservice.repository;

import com.chloekarah.postservice.repository.mapper.PostMapper;
import com.chloekarah.postservice.model.PostObject;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

@Repository
public class PostRepository {
    private final String INSERT_POST_SQL =
            "INSERT INTO post (post_name, description) VALUES (:post_name, :description);";
    private final String SELECT_POST = "SELECT * FROM post WHERE uuid = :uuid";
    private final Jdbi jdbi;
    private final PostMapper postMapper;

    public PostRepository(Jdbi jdbi, PostMapper postMapper) {
        this.jdbi = jdbi;
        this.postMapper = postMapper;
    }

    public boolean addPost(PostObject post) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate(INSERT_POST_SQL)
                    .bind("name", post.getPost_name())
                    .bind("description", post.getDescription())
                    .execute();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<PostObject> getPost(String postUuid) {
        //
        try (Handle handle = jdbi.open()) {
            return handle.select(SELECT_POST)
                .bind("uuid", postUuid)
                .map(postMapper)
                .findFirst();
        }
    }



}
