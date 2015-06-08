package com.bigbox.b2csite.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bigbox.b2csite.order.dao.OrderDao;
import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;

public class OrderServiceImplTest {
	
	public static final int CUSTOMER_ID = 1;
	
	@Test
	public void test_getOrderSummary_success() throws Exception {
		// Setup
		// 1. instantiate the class under test
		OrderServiceImpl target = new OrderServiceImpl();
		
		// 2. instantiate the mocks for the dependencies using mockito
		OrderDao mockOrderDao = Mockito.mock(OrderDao.class);
		
		// 3. set the mock to the instance of CUT 
		target.setOrderDao(mockOrderDao);
		
		OrderEntityToOrderSummaryTransformer mockTransformer = Mockito.mock(OrderEntityToOrderSummaryTransformer.class);
		target.setTransformer(mockTransformer);
		
		OrderEntity orderEntityFixture = new OrderEntity();
		List<OrderEntity> orderEntityListFixture = new ArrayList<>();
		orderEntityListFixture.add(orderEntityFixture);
		
		// Setup the data to be returned by mock call for the method stubbing.
		Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID)).thenReturn(orderEntityListFixture);
		
		OrderSummary orderSummaryFixture = new OrderSummary();
		Mockito.when(mockTransformer.transform(orderEntityFixture)).thenReturn(orderSummaryFixture);
		
		// Execution
		List<OrderSummary> result = target.getOrderSummary(CUSTOMER_ID);
		
		// Verify the mock interaction
		Mockito.verify(mockOrderDao).findOrdersByCustomer(CUSTOMER_ID);
		Mockito.verify(mockTransformer).transform(orderEntityFixture);
		
		// Verify the result
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}
}
