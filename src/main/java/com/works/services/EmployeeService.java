package com.works.services;

import com.works.configs.Rest;
import com.works.entities.Employee;
import com.works.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public ResponseEntity save(Employee employee){
        try{
            employeeRepository.save(employee);
            Rest rest = new Rest(true,employee);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity delete(Long eid){
        try{
            employeeRepository.deleteById(eid);
            Rest rest = new Rest(true,eid);
            return new ResponseEntity(rest,HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity update(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEid());
        if(optionalEmployee.isPresent()){
            employeeRepository.saveAndFlush(employee);
            Rest rest = new Rest(true,employee);
            return new ResponseEntity(rest,HttpStatus.OK);
        }
        Rest rest = new Rest(false,employee);
        return new ResponseEntity(false,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity list(){
        List<Employee> ls = employeeRepository.findAll();
        Rest rest = new Rest(true,ls);
        return new ResponseEntity(rest,HttpStatus.OK);
    }
}
