package com.aula.Aula.mapper.custom;

import com.aula.Aula.data.vo.PersonVo;
import com.aula.Aula.model.Person;
import com.aula.Aula.vo.v2.PersonVov2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVov2 convertEntityToVo(Person person){
        PersonVov2 vo = new PersonVov2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(vo.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthDay(new Date());
        return vo;
    }
    public Person convertVoToEntity(PersonVo person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(entity.getFirstName());
        entity.setLastName(person.getLastName());
       // vo.setBirthDay(new Date());
        return entity;
    }
}
