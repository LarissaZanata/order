package controller;

import java.util.List;

import dto.OrderDTO;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.OrderService;

@Path("/api")
public class OrderController {

	@Inject
	private OrderService orderService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDTO> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	
	@POST
	@Transactional
	public Response saveNewOrder(OrderDTO orderDTO) {
		try {
			orderService.creatOrder(orderDTO);
			return Response.ok().build(); 
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
