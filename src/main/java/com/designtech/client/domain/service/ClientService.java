package com.designtech.client.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.designtech.client.domain.model.Client;

public interface ClientService {
	Page<Client> getAllClients(Pageable pageable);
    Client createClient(Client client);
    Client updateClient(Long clientId, Client clientRequest);
    ResponseEntity<?> deleteClient(Long clientId);
    boolean existById(Long clientId);
    Client findById(Long clientId);
}
