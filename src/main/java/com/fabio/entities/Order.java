package com.fabio.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fabio.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;

	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private Integer orderStatus;
	

	public Order() {
	}

	public Order(Long id, Instant date, OrderStatus orderStatus, User client) {
		this.id = id;
		this.date = date;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	// ✅ Getters
	public Long getId() {
		return id;
	}

	public Instant getDate() {
		return date;
	}

	public User getClient() {
		return client;
	}

	// ✅ Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null)
		this.orderStatus = orderStatus.getCode();
	}
}
