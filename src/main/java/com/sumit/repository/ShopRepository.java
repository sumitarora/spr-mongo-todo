package com.sumit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
