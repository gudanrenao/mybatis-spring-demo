package com.zhangwenit.mybatis.spring.demo.service;

import com.zhangwenit.mybatis.spring.demo.mapper.PersonMapper;
import com.zhangwenit.mybatis.spring.demo.model.Person;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/22 10:53 AM
 * @Version 1.0
 **/
@Service
public class PersonService extends SqlSessionDaoSupport {

    private final PersonMapper personMapper;

    public PersonService(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public Person getById(Long id) {
        Person person = personMapper.selectById(id);
        System.out.println(person);
        return person;
    }

    public void useSqlSessionTemplateExecuteSql() {
        Map<Object, Object> map = getSqlSessionTemplate().selectMap("com.zhangwenit.mybatis.spring.demo.mapper.PersonMapper.selectAllUseMap", "id");
        System.out.println(map);
    }
}