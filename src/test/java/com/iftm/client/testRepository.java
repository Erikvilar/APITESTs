package com.iftm.client;





import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;


@DataJpaTest
class testRepository {
    @Autowired
    private ClientRepository cRepository;
    

    @Test
     void testMethodAllRespository(){
        assertThat(cRepository).isNotNull();
    }

    @Test
    void testMethodFindByNameOnly(){
        Client client = cRepository.findByName("Jorge Amado");
        assertThat(client).isNotNull();
    }


    @Test
    void testMethodFindByNameNotexistent(){
        Client client = cRepository.findByName("Jobiscreuz");
        assertThat(client).isNotNull();
    }




    @Test
    void testMethodFindByName(){  
    List<Client> list = cRepository.findClientByNames("Jorge Amado");
    assertThat(list).isNotEmpty();
    }





    @Test
    void testMethodNotExistentName(){
    List<Client> list = cRepository.findClientByNames("testeNomeNaoexistente");
    assertThat(list).isEmpty();
    }

    @Test
    void testeMethodIfNamesExists(){
        List<Client> list = cRepository.findClientByNames("Jorge Amado");
        assertThat(list).isNotEmpty();
    }

    @Test
    void testMethodWithVoidParameter(){
        List<Client> list = cRepository.findClientByNames("");
        assertThat(list).isNotEmpty();
    }


    @Test
    void testMethodIncomeManyClient(){
        List <Client> list = cRepository.findClientByvalues(2500.00);
        assertThat(list).isNotEmpty();
    }
    @Test
    void testMethodIncomeValuePlus(){
        List <Client> list = cRepository.findClientByvaluePlus(2000.00);
        assertThat(list).isNotEmpty();
    }
    @Test
    void testMethodIncomeValueLow(){
        List <Client> list = cRepository.findClientByvalueLow(8000.00);
        assertThat(list).isNotEmpty();
    }
    @Test
    void testMethodIncomeValueBetween(){
        List <Client> list = cRepository.findClientByValueBetween(1000.00, 3000.00);
        assertThat(list).isNotEmpty();
    }
    @Test
    void testAllClientsBasedOnBirthDate(){
       List<Client> list = cRepository.findClientByBirthDateBetween(Instant.parse("2017-12-25T20:30:50Z"), Instant.now());
       assertThat(list).isNotEmpty();
    }

  
  


}
