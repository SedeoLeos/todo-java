package com.example.slaega.service;

import com.example.slaega.model.Todo;
import com.example.slaega.repository.TodoRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoServiceImpl  implements  TodoService{

    private TodoRepository repository;
    private static final String message = "Tache non trouvé";
    @Override
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public List<Todo> find() {
        return repository.findAll();
    }

    @Override
    public Optional<Todo> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Todo update(Long id, Todo todo) {
        return repository.findById(id).map(p->{
            p.setDescription(todo.getDescription());
            p.setName(todo.getName());
            return repository.save(p);
        }).orElseThrow(()-> new RuntimeException(message));
    }

    @Override
    public Todo remove(Long id) {
        return repository.findById(id).map(p->{
            repository.deleteById(id);
            return p;
        }).orElseThrow(()-> new RuntimeException(message));
    }
}
