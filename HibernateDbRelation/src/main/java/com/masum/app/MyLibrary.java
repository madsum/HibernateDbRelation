package com.masum.app;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;
import com.masum.domain.Address;
import com.masum.domain.Author;
import com.masum.domain.Book;
import com.masum.domain.Category;
import com.masum.domain.Publisher;


public class MyLibrary {
	 
    public static void main(String[] args) {
        
        Book book=new Book();
        book.setIsbn("81-7808-137-7");
        book.setTitle("Fundamentals of Database System");
        
        Publisher pub=new Publisher();
        pub.setPublisherName("Pearson");
        
        Address add=new Address();
        add.setStreet("123 ABC Street");
        add.setProvince("XYZ");
        add.setPhone("9282736446");
        add.setEmail("info@pearson.com");
        add.setZip("1010101");
        
        pub.setPublisheAddress(add);
        
        book.setPublisher(pub);
        
        Author a1=new Author();
        a1.setAuthorName("Elmasri");
        a1.setBio("bio not available");
        
        Author a2=new Author();
        a2.setAuthorName("Navathe");
        a2.setBio("bio not available");
        
        book.getAuthors().add(a1);
        book.getAuthors().add(a2);
        
        Category c1=new Category();        
        c1.setCategoryName("Database");
        c1.setDescription("not Available");
        
        Category c2=new Category();
        c2.setCategoryName("Computer");
        c2.setDescription("not Available");
        
        book.getCategories().add(c1);
        book.getCategories().add(c2);
                
        
        Session session=HibernateUtil.openSession();
        session.beginTransaction();
        try {
        	 session.save(pub);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("couse ex: "+e.getCause());
			System.out.printf("ex: "+e.getMessage());
		}
        session.save(pub);
        session.save(a1);
        session.save(a2);
        session.save(c1);
        session.save(c2);
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
    
}