package com.works.services;

import com.works.configs.Rest;
import com.works.entities.Company;
import com.works.entities.Employee;
import com.works.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    final CompanyRepository companyRepository;

    public ResponseEntity save(Company company){
        try{
            companyRepository.save(company);
            Rest rest = new Rest(true,company);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity delete(Long cid){
        try{
            companyRepository.deleteById(cid);
            Rest rest = new Rest(true,cid);
            return new ResponseEntity(rest,HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity update(Company company){
        Optional<Company> optionalCompany = companyRepository.findById(company.getCid());
        if(optionalCompany.isPresent()){
            companyRepository.saveAndFlush(company);
            Rest rest = new Rest(true,company);
            return new ResponseEntity(rest,HttpStatus.OK);
        }
        Rest rest = new Rest(false,company);
        return new ResponseEntity(false,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity list(){
        List<Company> ls = companyRepository.findAll();
        Rest rest = new Rest(true,ls);
        return new ResponseEntity(rest,HttpStatus.OK);
    }
}
