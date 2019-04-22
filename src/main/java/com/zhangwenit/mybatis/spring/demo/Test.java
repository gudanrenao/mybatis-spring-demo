package com.zhangwenit.mybatis.spring.demo;

import com.zhangwenit.mybatis.spring.demo.mapper.PersonMapper;
import com.zhangwenit.mybatis.spring.demo.model.Person;
import com.zhangwenit.mybatis.spring.demo.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/22 11:01 AM
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
//        selectById();
//        transactionTemplate();
//        transactionStatus();
        selectUseSqlTemplate();
    }

    private static ClassPathXmlApplicationContext applicationContext(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        return applicationContext;
    }

    public static void transactionStatus() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DataSourceTransactionManager transactionManager = applicationContext.getBean(DataSourceTransactionManager.class);
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        PersonMapper personMapper = applicationContext.getBean(PersonMapper.class);
        try {
            personMapper.updatePersonUseSet(new Person(1L, 2, "2transactionStatus"));
            if (true) {
                throw new RuntimeException("rollback test");
            }
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
        transactionManager.commit(transactionStatus);
    }

    public static void transactionTemplate() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DataSourceTransactionManager transactionManager = applicationContext.getBean(DataSourceTransactionManager.class);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        Object personMapper = applicationContext.getBean("personMapper");
        PersonService personService = new PersonService((PersonMapper) personMapper);
        Object execute = transactionTemplate.execute(txStatus -> {
            return personService.getById(1L);
        });
        System.out.println(execute);
    }

    public static void selectById() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        PersonService personService = applicationContext.getBean(PersonService.class);
        personService.getById(1L);
    }

    public static void selectUseSqlTemplate(){
        PersonService personService = applicationContext().getBean(PersonService.class);
        personService.useSqlSessionTemplateExecuteSql();
    }
}