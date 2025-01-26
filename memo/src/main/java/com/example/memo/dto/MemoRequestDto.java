package com.example.memo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {

    private String title;
    private String contents;

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
