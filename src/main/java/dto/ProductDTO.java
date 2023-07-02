package dto;


import java.math.BigDecimal;

import lombok.extern.jackson.Jacksonized;

@Jacksonized
public class ProductDTO {

	private String description;
	
	private String category;
	
	private String model;
	
	private BigDecimal price;
}
