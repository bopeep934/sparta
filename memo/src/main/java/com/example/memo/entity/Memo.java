package com.example.memo.entity;

import com.example.memo.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    private long id;//int보다 범위가 크고, null도 가능
    //id는 서버에서 관리하므로 요청에 필요없음
    private String title;
    private String contents;

    public void update(MemoRequestDto dto){
        this.title=dto.getTitle();
        this.contents=dto.getContents();
    }
    public void updateTitle(MemoRequestDto dto){
        this.title=dto.getTitle();
    }
}
