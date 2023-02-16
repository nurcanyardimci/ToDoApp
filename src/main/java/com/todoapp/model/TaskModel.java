package com.todoapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tasks")
public class TaskModel {
    @Id
    @SequenceGenerator(name = "tasks_seq",
            sequenceName = "tasks_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "tasks_seq")


    private int id;
    private String password;
    private String name;
    private String description;
    private String management;



}
