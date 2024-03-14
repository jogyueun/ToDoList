package com.todolist;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String content;

    @Column
    @UpdateTimestamp
    private LocalDateTime createTime;

    @Column
    private Boolean deleted;

    @Column
    private Boolean completed;

    public static ToDoEntity toEntity(ToDoDTO dto) {
        return new ToDoEntity().builder()
                .Id(null)
                .content(dto.getContent())
                .createTime(null)
                .deleted(null)
                .completed(null)
                .build();
    }

    public void patch(Long id) {
        this.Id = id;
    }

    public void delete(boolean deleted) {
        this.deleted = deleted;
    }

    public void complete(boolean completed) {
        this.completed = completed;
    }


}
