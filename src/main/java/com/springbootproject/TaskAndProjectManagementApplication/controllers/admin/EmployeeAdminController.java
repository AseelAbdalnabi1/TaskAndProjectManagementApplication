package com.springbootproject.TaskAndProjectManagementApplication.controllers.admin;

import com.springbootproject.TaskAndProjectManagementApplication.models.Employee;
import com.springbootproject.TaskAndProjectManagementApplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/employees")
public class EmployeeAdminController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeAdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> findAllEmployeeS(){
        return employeeService.findAllEmployees();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);
    }
    @PutMapping("/{id}/attach/tasks/{task-id}")//the (attach) word added to differentiate between attachTaskToEmployee path &  discardTaskFromEmployee path --need to be discussed
    @ResponseStatus(code = HttpStatus.OK)
    public Employee attachTaskToEmployee(@PathVariable String id, @PathVariable(name = "task-id") String taskId) throws Exception {
        return employeeService.attachTaskToEmployee(id,taskId);

    }
    @PutMapping("/{id}/discard/tasks/{task-id}")//the (discard) word added to differentiate between attachTaskToEmployee path &  discardTaskFromEmployee path --need to be discussed
    @ResponseStatus(code = HttpStatus.OK)
    public Employee discardTaskFromEmployee(@PathVariable String id,@PathVariable("task-id") String task_id) throws Exception{
        return employeeService.discardTaskFromEmployee(id,task_id);
    }
}
