package com.aula.Aula.services;

import com.aula.Aula.data.vo.PersonVo;
import com.aula.Aula.exceptions.ResourcenotfoundException;
import com.aula.Aula.mapper.DozzerMapper;
import com.aula.Aula.mapper.custom.PersonMapper;
import com.aula.Aula.model.Person;
import com.aula.Aula.repositories.Personrepositories;
import com.aula.Aula.vo.v2.PersonVov2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    Personrepositories repository;
    @Autowired
    PersonMapper mapper;
    public List<PersonVo> findAll() {

        logger.info("Finding all people!");
        return DozzerMapper.parseListObjects(repository.findAll() , PersonVo.class);
    }

    public PersonVo findById(Long id) {

        logger.info("Finding one person!");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourcenotfoundException("No record found for this ID!"));
        return DozzerMapper.parseObject(entity, PersonVo.class);



    }
    public PersonVo create(PersonVo person) {

        logger.info("Creating one person!");
        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }
    public PersonVov2 createv2(PersonVov2 person) {

        logger.info("Creating one person with v2!");
        var entity = DozzerMapper.parseObject(person, Person.class);
        var vo = DozzerMapper.parseObject(repository.save(entity), PersonVov2.class);
        return vo;
    }

    public PersonVo update(PersonVo person) {
        logger.info("Updating one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourcenotfoundException("No record found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozzerMapper.parseObject(repository.save(entity), PersonVo.class);
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourcenotfoundException("No record found for this ID!"));
        repository.delete(entity);
    }

}

