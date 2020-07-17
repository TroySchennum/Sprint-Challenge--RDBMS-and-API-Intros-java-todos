package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    @Column(unique= true)
    private String description;

    @Transient
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "userid"
                )
    private User user;
    @JsonIgnoreProperties("todos")

    public Todos(String description, User user) {
        this.description = description;

        this.user = user;
    }

    public Todos()
    {
    }

    public Todos(User user, String description, User newUser) {
    }


    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
