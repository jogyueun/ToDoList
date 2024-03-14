package com.todolist;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ToDoDTO {

    private Long Id;

    private String content;

    private boolean completed;

    private LocalDateTime createTime;


    public static ToDoDTO createDTO(ToDoEntity toDoEntity) {
        ToDoDTO toDoDTO = new ToDoDTO();

        toDoDTO.setId(toDoEntity.getId());

        toDoDTO.setContent(toDoEntity.getContent());

        toDoDTO.setCompleted(toDoEntity.getCompleted());

        toDoDTO.setCreateTime(toDoEntity.getCreateTime());


        return toDoDTO;
    }

}
