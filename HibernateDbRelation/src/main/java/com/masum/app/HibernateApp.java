package com.masum.app;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.onetomany.Department;
import com.domain.onetomany.Employee;
import com.domain.onetoone.Stock;
import com.domain.onetoone.StockDetail;
import com.mastertheboss.util.HibernateUtilByXml;

public class HibernateApp {

    public static void main(String[] args) {

        Session session = HibernateUtilByXml.getSessionFactory().openSession();

        session.beginTransaction();

        Department department = new Department("java");
        Department department2 = new Department("ma");
        session.save(department);
        session.save(department2);

        session.save(new Employee("Jakab Gipsz",department));
        session.save(new Employee("Captain Nemo",department2));
       
		Stock stock = new Stock();

		stock.setStockCode("7052121");
		stock.setStockName("PADINIas");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();
     
        Query q = session.createQuery("From Employee ");

        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
        
        session.close();

    }

}