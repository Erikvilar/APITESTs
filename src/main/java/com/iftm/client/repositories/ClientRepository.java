package com.iftm.client.repositories;

import java.time.Instant;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iftm.client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Teste com Query nativo nao funcional 
    @Query(value=" SELECT client FROM  tb_client WHERE LOWER (name) = LOWER (:name) ", nativeQuery=true)
    Client findByName(String name);

    @Query(value="SELECT c FROM  Client c  where c.name LIKE CONCAT ('%',:name,'%' )")
    List<Client> findClientByNames(@Param("name")String name);

    @Query(value="SELECT c FROM Client c where c.income >= :income")
    List<Client> findClientByvaluePlus(@Param("income") Double income);

    @Query(value="SELECT c FROM  Client c where c.income < :income")
    List<Client> findClientByvalueLow(@Param("income") Double income);

    @Query(value="SELECT c FROM Client c where c.income = :income")
    List<Client> findClientByvalues(@Param("income") Double income);


    @Query(value="SELECT c FROM Client where c.income BETWEEN :incomePrimaryValue AND :incomeSecondaryValue")
    List<Client> findClientByValueBetween(@Param("incomePrimaryValue") Double incomePrimaryValue, @Param(" incomeSecondaryValue") Double incomeSecondaryValue);
    
    List<Client> findClientByBirthDateBetween(Instant DataInicio, Instant DataTermino);
   

}
