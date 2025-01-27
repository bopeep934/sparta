package com.example.layered.Entity;

import com.example.layered.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
//@setter 클래스 전역에 setter 가 적용
public class Memo {

    @Setter//필드위에 setter는 필드만 setter가 적용
    private Long id;
    private String title;
    private String contents;

    public Memo(String title, String contents){
        this.title=title;
        this.contents=contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

}