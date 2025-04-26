package com.crud.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.api.Model.ProductList;

@Repository
public interface ProductRepository extends JpaRepository<ProductList,Long>{


}
