package com.chloekarah.postservice.repository.mapper;

import com.chloekarah.postservice.model.PostObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements RowMapper<PostObject> {

    @Override
    public PostObject map(ResultSet rs, StatementContext ctx) throws SQLException {
        PostObject postObject = new PostObject();
        // TODO: fill in the rest
        postObject.setPost_name(rs.getString("post_name"));

        return postObject;
    }
}
