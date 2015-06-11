package com.bigbox.b2csite.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bigbox.b2csite.common.DataAccessException;
import com.bigbox.b2csite.common.ServiceException;
import com.bigbox.b2csite.order.dao.OrderDao;
import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import com.bigbox.b2csite.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = null;
	private OrderEntityToOrderSummaryTransformer transformer = null;
	
	public void setOrderDao(final OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setTransformer(final OrderEntityToOrderSummaryTransformer transformer) {
		this.transformer = transformer;
	}
	
	@Override
	public List<OrderSummary> getOrderSummary(long customerId) throws ServiceException {
		List<OrderSummary> resultList = new ArrayList<>();
		try {
			List<OrderEntity> orderEntityList = orderDao.findOrdersByCustomer(customerId);
			for(OrderEntity currentOrderEntity : orderEntityList) {
				resultList.add(transformer.transform(currentOrderEntity));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
