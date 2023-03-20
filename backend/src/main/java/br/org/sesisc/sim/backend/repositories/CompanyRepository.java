package br.org.sesisc.sim.backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.org.sesisc.sim.backend.models.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    
    Set<Company> findAll();

      Optional<Company> findById(Long id);

      @Query(value="DELETE FROM companies WHERE companies.id = :id", nativeQuery = true)
      List<Object> removeCompanyById(@Param("id") Long id);

      
      @Query(value="UPDATE companies SET `business_name` = :businessName, `cnpj` = :cnpj, `address` = :address, `line_of_business` = :lineOfBusiness WHERE `companies`.`id` = :id", nativeQuery = true)
      List<Object> updateCompanyById(@Param("id") Long id, @Param("businessName") String businessName, @Param("cnpj") String cnpj, @Param("address") String address, @Param("lineOfBusiness") String lineOfBusiness );

}


