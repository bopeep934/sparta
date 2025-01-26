package com.example.memo.dto;

import com.example.memo.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    //응답은 id도 포함(요청은 id 미포함)

    private long id;
    private String title;
    private String contents;

    public MemoResponseDto(Memo memo){
        this.id=memo.getId();
        this.title=memo.getTitle();
        this.contents =memo.getContents();

    }
}
