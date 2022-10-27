package br.com.clients.Repository;

import br.com.clients.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select  p from Product p join p.client c where upper(c.name) like upper(:name) and FUNCTION('MONTH',p.data)= :mes ")
    List<Product> findByNameAndMes(@Param("name") String name, @Param("mes") Integer mes);
}
