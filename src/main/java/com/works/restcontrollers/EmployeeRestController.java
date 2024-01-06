package com.works.restcontrollers;

import com.works.entities.Employee;
import com.works.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeRestController {

    final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/delete/{eid}")
    public ResponseEntity delete(@PathVariable Long eid){
        return employeeService.delete(eid);
    }

    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return employeeService.list();
    }

}
