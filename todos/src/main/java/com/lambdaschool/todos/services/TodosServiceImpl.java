package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService{
    @Autowired
    private TodosRepository todosrepos;

    public Todos findTodosById(long id) throws EntityNotFoundException{
        return todosrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("todos not found"));
    }

    @Transactional
    @Override
    public Todos markComplete(long id){
        Todos currentTodos = todosrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("todos not found"));
        currentTodos.setCompleted(true);

        return todosrepos.save(currentTodos);



    }



}
