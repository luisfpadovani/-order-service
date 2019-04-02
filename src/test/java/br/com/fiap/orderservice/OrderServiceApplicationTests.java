package br.com.fiap.orderservice;

import br.com.fiap.orderservice.Controller.OrderController;
import br.com.fiap.orderservice.Domain.Order;
import br.com.fiap.orderservice.Repository.OrderDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderServiceApplicationTests {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private OrderDao repository;

	@Test
	public void OrderFounded() throws Exception {
		int idOrder = 1;
		Order order = new Order();
		order.setIdOrder(1);
		when(this.repository.findById(idOrder)).thenReturn(order);
		mvc.perform(get("/order/findByid/" + idOrder)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(response -> {
					String json = response.getResponse().getContentAsString();
					Order orderFounded = new ObjectMapper().readValue(json, Order.class);
					assertThat(order.getIdOrder()).isEqualToComparingFieldByField(orderFounded.getIdOrder());
				});
	}

	@Test
	public void OrderNotFounded() throws Exception {
		int idOrder = 0;
		Order order = new Order();
		order.setIdOrder(1);
		when(this.repository.findById(idOrder)).thenReturn(order);
		mvc.perform(get("/order/findByid/" + idOrder)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

}
