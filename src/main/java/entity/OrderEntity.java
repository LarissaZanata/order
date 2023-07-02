package entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderProducts")
public class OrderEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long customerId;

    private String customerName;

    private Long productId;

    private BigDecimal orderValue;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
	}
	
	
	
}
