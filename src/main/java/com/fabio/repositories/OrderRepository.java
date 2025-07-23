package com.fabio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
