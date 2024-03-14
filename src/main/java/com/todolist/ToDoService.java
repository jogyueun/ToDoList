package com.todolist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // 할 일 목록 조회
    public List<ToDoDTO> findAll() {
        List<ToDoEntity> list = toDoRepository.findAllNoDeleted();

        List<ToDoDTO> dtos = new ArrayList<>();

        for (ToDoEntity toDoEntity : list) {
            ToDoDTO dto = ToDoDTO.createDTO(toDoEntity);
            dtos.add(dto);
        }

        return dtos;
    }

    // 할 일 생성
    public void create(ToDoDTO dto) {
        ToDoEntity toDoEntity = ToDoEntity.toEntity(dto);
        toDoEntity.setDeleted(false);
        toDoEntity.setCompleted(false);
        toDoRepository.save(toDoEntity);
    }

    // 할 일 수정
    public boolean patch(Long id) {

        ToDoEntity toDoEntity = toDoRepository.findById(id).orElse(null);
        // 존재 여부 확인
        if (toDoEntity == null) {
            return false;
        }
        toDoEntity.patch(id);
        toDoRepository.save(toDoEntity);
        return true;
    }


    // 할 일 완료 체크
    public boolean complete(Long id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id).orElse(null);

        // 존재 여부 확인
        if (toDoEntity == null) {
            return false;
        }
        System.out.print(toDoEntity.getCompleted());
        // 완료 토글 기능
        if(!toDoEntity.getCompleted()){
            toDoEntity.complete(true);
        }
        else {
            toDoEntity.complete(false);
        }

        toDoRepository.save(toDoEntity);
        return true;
    }

    // 할 일 삭제
    public boolean delete(Long id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id).orElse(null);
        // 존재 여부 확인
        if (toDoEntity == null) {
            return false;
        }
        toDoEntity.delete(true);
        toDoRepository.save(toDoEntity);
        return true;
    }
}
