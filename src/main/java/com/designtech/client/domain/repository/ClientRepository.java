package com.designtech.client.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.designtech.client.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public Page<Client> findById(Long Id, Pageable pageable);
}