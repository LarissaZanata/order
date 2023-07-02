package client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dto.ProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/products")
@RegisterRestClient(baseUri="http://localhost:8081/api/")
@ApplicationScoped
public interface ProductClient {

	@GET
	@Path("/{id}")
	ProductDTO getProductById(@PathParam("id") Long id);
}
