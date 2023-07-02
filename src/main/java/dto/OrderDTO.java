package dto;

import java.math.BigDecimal;

import lombok.extern.jackson.Jacksonized;

@Jacksonized
public class OrderDTO {

	
	private Long customerId;
	
	private String customerName;
	
	private Long productId;
	
	private BigDecimal orderValue;

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
