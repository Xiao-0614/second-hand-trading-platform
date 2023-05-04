package com.chloekarah.postservice;

import org.springframework.stereotype.Repository;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import com.chloekarah.postservice.PostObject;
import com.chloekarah.postservice.PostDto;
import com.chloekarah.postservice.PostMapper;

@Repository
public class PostRepository {
    private final String INSERT_POST_SQL =
            "INSERT INTO post (post_name, description) VALUES (:post_name, :description);";
    private Jdbi jdbi;
    private PostMapper postMapper;

    public PostRepository(Jdbi jdbi, PostMapper postMapper) {
        this.jdbi = jdbi;
        this.postMapper = postMapper;
    }

    public boolean addPost(PostObject post) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate(INSERT_POST_SQL)
                    .bind("name", PostObject.getPost_name())
                    .bind("description", PostObject.getDescription())
                    .execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }



}
