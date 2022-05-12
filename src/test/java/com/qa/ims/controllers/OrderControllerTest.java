package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customerId = 1L;
		final Long orderId = 2L;
		final Long itemId = 1L;
		final Order created = new Order(orderId,customerId);
		final String newItem = "yes";
		final String moreItems = "no";
		final Order created2 = new Order(orderId, itemId);
		final Item item2 = new Item(1L, "apple", 1.5);
		//Order item6 = orderDAO.addItem(orderId, itemId);
		
		//Mockito.when(utils.getLong()).thenReturn(customerId);
		//Mockito.when(this.utils.getLong()).thenReturn(orderId);
		
		
		//Mockito.when(utils.getString()).thenReturn(newItem);
		Mockito.when(this.utils.getLong()).thenReturn(orderId);
		Mockito.when(this.utils.getLong()).thenReturn(itemId);
		//Mockito.when(utils.getString()).thenReturn(moreItems);
		
		assertEquals(null, controller.addItem(newItem));
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created2);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
