package me.sungbin.photoapp.api.post;

import lombok.*;


@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Content {
    private String contentId;
    private String title;
    private String body;
    private String writerNickName;
    private PostImage attachImage;
}
