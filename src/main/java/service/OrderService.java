package service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import client.CustomerClient;
import client.ProductClient;
import dto.CustomerDTO;
import dto.OrderDTO;
import entity.OrderEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import repository.OrderRepository;

@ApplicationScoped
public class OrderService {
	
	@Inject
	private OrderRepository orderRepository;
	
	@Inject
	@RestClient
	private CustomerClient customerClient;
	
	@Inject
	@RestClient
	private ProductClient productClient;
	
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> entities = new ArrayList<OrderDTO>();
		orderRepository.findAll().stream().forEach(item -> {
			entities.add(mapOrderEntityToDTO(item));
		});
		return entities;
	}
	
	public void creatOrder(OrderDTO orderDTO) {
		CustomerDTO customerDTO = customerClient.getCustomerById(orderDTO.getCustomerId());
		
		if(customerDTO.getName().equals(orderDTO.getCustomerName())  
			&& productClient.getProductById(orderDTO.getProductId()) != null) {
			orderRepository.persist(orderDtoToEntity(orderDTO));
		} else {
			throw new NotFoundException();
		}
	}
	
	
	private OrderDTO mapOrderEntityToDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setCustomerId(entity.getCustomerId());
		dto.setCustomerName(entity.getCustomerName());
		dto.setProductId(entity.getProductId());
		dto.setOrderValue(entity.getOrderValue());
		return dto;
	}
	
	
	private OrderEntity orderDtoToEntity(OrderDTO orderDTO) {
		OrderEntity entity = new OrderEntity();
		entity.setCustomerId(orderDTO.getCustomerId());
		entity.setCustomerName(orderDTO.getCustomerName());
		entity.setProductId(orderDTO.getProductId());
		entity.setOrderValue(orderDTO.getOrderValue());
		return entity;
	}

}
