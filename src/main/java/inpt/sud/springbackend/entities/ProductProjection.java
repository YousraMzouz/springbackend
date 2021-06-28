package inpt.sud.springbackend.entities;

import inpt.sud.springbackend.model.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1" , types = Product.class)
public interface ProductProjection {
    public double getCurrentPrice();
}

