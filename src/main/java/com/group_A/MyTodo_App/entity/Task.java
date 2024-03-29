package com.group_A.MyTodo_App.entity;

import com.group_A.MyTodo_App.enums.PriorityLevel;
import com.group_A.MyTodo_App.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private PriorityLevel priorityLevel;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
}
