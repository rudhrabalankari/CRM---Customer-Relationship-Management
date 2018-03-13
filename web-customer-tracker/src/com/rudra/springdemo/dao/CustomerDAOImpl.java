package com.rudra.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rudra.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the Hibernate Session Factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current session
		Session currentsession = sessionFactory.getCurrentSession();

		// create the query... sort the customers based on the last name
		Query<Customer> theQuery = currentsession.createQuery("from Customer order by lastName", Customer.class);

		// execute the query and get the result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// getting the current session
		Session currentSession = sessionFactory.getCurrentSession();

		// saving the customer to the data base using the hibernate
		currentSession.save(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {
		// getting the current session
		Session currentSession = sessionFactory.getCurrentSession();

		// reading the customer by using the Id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

}
