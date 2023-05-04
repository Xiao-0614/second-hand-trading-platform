package com.chloekarah.postservice;

import java.util.UUID;

public class PostObject {
    private UUID uuid;
    private String post_name;
    private String item_name;
    private String description;
    private long postAt;
    private boolean status;

    private PostObject(Builder builder) {
        setUuid(builder.uuid);
        setPost_name(builder.post_name);
        setItem_name(builder.item_name);
        setDescription(builder.description);
        setStatus(builder.status);
        setPostAt(builder.postAt);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public static String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPostAt() {
        return postAt;
    }

    public void setPostAt(long postAt) {
        this.postAt = postAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public static PostObject fromFibDto(PostDto postDto) {
        return PostObject.Builder.newBuilder()
                .withPostName(postDto.getPost_name())
                .withItemName(postDto.getItem_name())
                .withDescription(postDto.getDescription())
                .withStatus((postDto.isStatus()))
                .build();
    }



    public static final class Builder {

        private UUID uuid;
        private String post_name;
        private String item_name;
        private String description;
        private long postAt;
        private boolean status;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withId(UUID val) {
            uuid = val;
            return this;
        }

        public Builder withPostName(String val) {
            post_name = val;
            return this;
        }

        public Builder withItemName(String val) {
            item_name = val;
            return this;
        }

        public Builder withPostAt(long val) {
            postAt = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withStatus(boolean val) {
            status = val;
            return this;
        }

        public PostObject build() {
            return new PostObject(this);
        }


    }


}
