package com.works.restcontrollers;

import com.works.entities.Company;
import com.works.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyRestController {

    final CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Company company){
        return companyService.save(company);
    }

    @GetMapping("/delete/{cid}")
    public ResponseEntity delete(@PathVariable Long cid){
        return companyService.delete(cid);
    }

    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody Company company){
        return companyService.update(company);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return companyService.list();
    }
}
