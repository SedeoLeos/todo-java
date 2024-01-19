package com.example.slaega.service;

import com.example.slaega.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo create(Todo todo);
    List<Todo> find();
    Optional<Todo> findOne(Long id);
    Todo update(Long id,Todo todo );
    Todo remove(Long id);
}
