package com.example.layered.repository;

import com.example.layered.Entity.Memo;
import com.example.layered.dto.MemoResponseDto;

import java.util.List;

public interface MemoRepository {

    Memo saveMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);

    void deleteMemo(Long id);
}
