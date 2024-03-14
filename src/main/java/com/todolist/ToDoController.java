package com.todolist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private final ToDoService toDoService;


    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/show")
    public ResponseEntity<List<ToDoDTO>> show() {

        // 투두리스트 전체 조회하기
        List<ToDoDTO> dtos = toDoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/create")
    public ResponseEntity<ToDoDTO> create(@RequestBody ToDoDTO toDoDTO) {

        // 투두리스트 생성하기
        toDoService.create(toDoDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<ToDoDTO> patch(@PathVariable(name = "id") Long id) {

        // 투두리스트 수정하기
        if (toDoService.patch(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/complete/{id}")
    public ResponseEntity<ToDoDTO> complete(@PathVariable(name = "id") Long id) {
        if(toDoService.complete(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<ToDoDTO> delete(@PathVariable(name = "id") Long id) {
        if(toDoService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
