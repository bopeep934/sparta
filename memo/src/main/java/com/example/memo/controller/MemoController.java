package com.example.memo.controller;

import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController//json형태
@RequestMapping("/memos")
public class MemoController {

    private final Map<Long, Memo> memoList= new HashMap<>();

    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto){
        //식별자가 1씩 증가하도록 만듬
        Long memoId = memoList.isEmpty()? 1: Collections.max(memoList.keySet()) +1;

        //요청 받은 데이터로 Memo  객체 생성
        Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

        memoList.put(memoId, memo);

        return new ResponseEntity<>(new MemoResponseDto(memo),HttpStatus.CREATED);
//ctrl+클래스명 누르면 메소드 사용 가능.

        //Inmemory DB에 Memo 메모
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id){

        Memo memo = memoList.get(id);

        if(memo==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemoId( @PathVariable Long id,
                                         @RequestBody MemoRequestDto dto){

        Memo memo= memoList.get(id);

        if(memo==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(dto.getTitle()==null||dto.getContents()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.update(dto);

        return new ResponseEntity<>(new MemoResponseDto(memo),HttpStatus.OK);


    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody MemoRequestDto dto
    ){
        Memo memo= memoList.get(id);

        //NPE 방지
        if(memo==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(dto.getTitle()==null||dto.getContents() !=null){//제목만 수정해야하므로 contents는 null이 아니어야함.
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.updateTitle(dto);

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);

    }

    @GetMapping
    public List<MemoResponseDto> findAllMemos(){

        List<MemoResponseDto> responseList= new ArrayList<>();

        for(Memo memo: memoList.values()){
            MemoResponseDto responseDto=new MemoResponseDto(memo);
            responseList.add(responseDto);
        }

        //Map to List 동일한 스트림문
//        responseList=memoList.values().stream().map(MemoResponseDto::new).toList();

        return responseList;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id){


        if(memoList.containsKey(id)){
            memoList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
