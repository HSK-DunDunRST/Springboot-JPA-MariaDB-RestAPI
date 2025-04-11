package com.hsk.restapi.HSKSite.data.dtoSet;

import lombok.Getter;

@Getter
public class PostResponseDTO {
    private String boardTableName;
    private String postTitle;
    private String postContent;
    private String postWriter;
    private int postViewCount;
    private Boolean isNotice;
}
