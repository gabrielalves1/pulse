package br.org.sesisc.sim.backend.controllers;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.sesisc.sim.backend.models.Company;
import br.org.sesisc.sim.backend.models.SignalResults;
import br.org.sesisc.sim.backend.repositories.CompanyRepository;
import br.org.sesisc.sim.backend.repositories.SignalResultsRepository;
import br.org.sesisc.sim.backend.responses.ErrorResponse;
import br.org.sesisc.sim.backend.responses.SuccessResponse;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Company company, Errors errors) {
            Company newCompany = null;
            newCompany = company;

            companyRepository.save(company);

        try {
            if (errors.hasErrors()){
                return ErrorResponse.handle(errors, HttpStatus.UNPROCESSABLE_ENTITY);
            }
            
            return SuccessResponse.handle(new String [] {"newCompany"}, new Object[]{
                newCompany
            }, HttpStatus.OK);

        } catch (Exception e){
            return ErrorResponse.handle("Erro na persistência de dados", e.getClass(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Company company, Errors errors) {

            Company newCompany = null;
            newCompany = company;
        company.setId((long) 7);
            companyRepository.updateCompanyById(company.getId(), company.getBusinessName(), company.getCnpj(), company.getAddress(), company.getLineOfBusiness());

        try {
            if (errors.hasErrors()){
                return ErrorResponse.handle(errors, HttpStatus.UNPROCESSABLE_ENTITY);
            }
            
            return SuccessResponse.handle(new String [] {"newCompany"}, new Object[]{
                newCompany
            }, HttpStatus.OK);

        } catch (Exception e){
            return ErrorResponse.handle("Erro na persistência de dados", e.getClass(), HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
            // Optional<Company> newCompany = this.companyRepository.findById(idLong);
        Company newCompany = new Company();
            companyRepository.removeCompanyById(id);

        try {

            
            return SuccessResponse.handle(new String [] {"newCompany"}, new Object[]{
                newCompany
            }, HttpStatus.OK);

        } catch (Exception e){
            return ErrorResponse.handle("Erro na persistência de dados", e.getClass(), HttpStatus.CONFLICT);
        }
    }


    @GetMapping
    public ResponseEntity<?> index() {
        Set<Company> companies = (Set<Company>) companyRepository.findAll();
        
        return SuccessResponse.handle(
            new String[] {"companies"},
            new Object[] {companies},
            HttpStatus.OK
        );
    }
    
}
