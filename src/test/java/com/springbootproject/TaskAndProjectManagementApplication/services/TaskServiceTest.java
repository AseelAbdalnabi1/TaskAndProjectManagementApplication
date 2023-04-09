package com.springbootproject.TaskAndProjectManagementApplication.services;

import com.springbootproject.TaskAndProjectManagementApplication.models.Task;
import com.springbootproject.TaskAndProjectManagementApplication.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TaskServiceTest{
    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAllTasks() {
        List<Task> tasks1= Arrays.asList(new Task());

        when(taskRepository.findAll()).thenReturn(tasks1);
        List<Task> tasks2=taskService.findAllTasks();
        assertNotNull(tasks2);
        assertEquals(tasks1.size(),tasks2.size());
    }

    @Test
    void findTaskById() {
        Task task= new Task();
        task.setDescription("task1 description");
        task.setName("task1");
        task.setId("0ab2f2be-30b8-45be-a6c7-d2c260c6e1d1");
        when(taskRepository.findById(anyString())).thenReturn(Optional.of(Optional.of(task).get()));
        Task task1= taskService.findTaskById("0ab2f2be-30b8-45be-a6c7-d2c260c6e1d1");
        assertNotNull(task1);
        assertEquals(task.getName(),task1.getName());
        assertEquals(task.getId(),task1.getId());
        assertEquals(task.getDescription(),task1.getDescription());

    }

    @Test
    void findTaskByName() {
        List<Task> tasks1=new ArrayList<>();
        tasks1.add(new Task());
        tasks1.add(new Task());
        when(taskRepository.findByName(anyString())).thenReturn(tasks1);
        List<Task> tasks2=taskService.findTaskByName("task2");
        assertNotNull(tasks2);
        assertEquals(tasks1.size(),tasks2.size());
    }

    @Test
    void createTask(){
        Task task1 =new Task();
        task1.setName("task1");
        task1.setDescription("task1 description");
        task1.setId("12");
        when(taskRepository.save(task1)).thenReturn(task1);
        Task task2 =taskService.createTask(task1);
        assertNotNull(task2);
        assertEquals(task1.getName(),task2.getName());
        assertEquals(task1.getId(),task2.getId());
        assertEquals(task1.getDescription(),task2.getDescription());
    }

    @Test
    void updateTask(){
        Task task1 =new Task();
        task1.setName("task1");
        task1.setDescription("task1 description");
        task1.setId("12");
        when(taskRepository.save(any())).thenReturn(task1);
        when(taskRepository.existsById(task1.getId())).thenReturn(true);
        Task task2=taskService.updateTask(task1,task1.getId());
        assertNotNull(task2);
        assertEquals(task1.getName(),task2.getName());
        assertEquals(task1.getId(),task2.getId());
        assertEquals(task1.getDescription(),task2.getDescription());
    }
    @Test
    void deleteTaskById_NotFoundCase() {
        doThrow(new IllegalArgumentException()).when(taskRepository).deleteById(anyString());
        assertThrows(IllegalStateException.class,()-> {taskService.deleteTaskById("12");});
    }
    @Test
    void deleteTaskById() {
        doNothing().when(taskRepository).deleteById(anyString());
        when(taskRepository.existsById(anyString())).thenReturn(true);
        try {
            taskService.deleteTaskById("125");

        } catch(Exception e) {
            fail();
        }
    }
}