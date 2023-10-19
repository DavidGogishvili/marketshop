package ge.davidgogishvili.projects.marketshop.repositories;

import ge.davidgogishvili.projects.marketshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository <Product, Integer> {

    List <Product> findAllByEanCode (String EanCode);
}
