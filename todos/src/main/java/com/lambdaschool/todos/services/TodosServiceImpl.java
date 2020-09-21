package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todosService")
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodoRepository todorepos;

    @Override
    public void markComplete(long todoid) {
        Todo completedTodo =
                todorepos.findById(todoid).orElseThrow(()-> new EntityNotFoundException("Todo Id :" + todoid + " Not Valid!"));
        completedTodo.setCompleted(true);
    }

    @Override
    public Todo save(Todo todo) {
        return todorepos.save(todo);
    }
}
