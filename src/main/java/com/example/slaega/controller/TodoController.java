package com.example.slaega.controller;

import com.example.slaega.dto.TodoDto;
import com.example.slaega.model.Todo;
import com.example.slaega.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {
    private final TodoService service;
    private final ModelMapper modelMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@Valid  @RequestBody TodoDto todoDto){
        Todo todo = modelMapper.map(todoDto, Todo.class);
        return service.create(todo);
    }
    @GetMapping
    public List<Todo> find(){
        return service.find();
    }

    @GetMapping("/{id}")

    public Todo findOne(@PathVariable Long id){
        Optional<Todo> data = service.findOne(id);
        if(data.isPresent()){
            return data.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"sgkog");
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo update(@PathVariable Long id,@RequestBody Todo todo){
        return service.update(id, todo);
    }
    @DeleteMapping("/{id}")
    public Todo remove(@PathVariable Long id){
        return service.remove(id);
    }
}
