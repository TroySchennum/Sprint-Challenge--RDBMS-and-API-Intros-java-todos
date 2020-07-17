package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "todoService")
public class TodosServiceImpl implements TodosService{
    @Autowired
    private TodosRepository todosrepos;

    @Transactional
    @Override
    public void markComplete(long todoid){
        todosrepos.markComplete();
    }



}
