package com.todoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class Tasks {
    @Id
    @SequenceGenerator(name = "tasks_seq",
            sequenceName = "tasks_sequence",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "tasks_seq")


    public int id;
    public String password;
    public String name;
    public String description;
    public String management;




}
