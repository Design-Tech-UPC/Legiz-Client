package com.designtech.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.designtech.client.domain.model.Client;
import com.designtech.client.domain.repository.ClientRepository;
import com.designtech.client.domain.service.ClientService;
import com.designtech.client.exception.ResourceNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    
    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long clientId, Client clientRequest) {
    	Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client","Id",clientId));
    	client.setCivil_Status(clientRequest.getCivil_Status());
        return clientRepository.save(client);
    }

    @Override
    public ResponseEntity<?> deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client","Id",clientId));

        clientRepository.delete(client);
        return ResponseEntity.ok().build();
    }

	@Override
	public boolean existById(Long clientId) {
		return clientRepository.existsById(clientId);
	}

	@Override
	public Client findById(Long clientId) {
		Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client","Id",clientId));
		return client;
	}
}