package com.designtech.client.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.designtech.client.domain.model.Client;
import com.designtech.client.domain.service.ClientService;
import com.designtech.client.resource.ClientResource;
import com.designtech.client.resource.SaveClientResource;



@RestController
@RequestMapping("/api")
public class ClientController {

	 	@Autowired
	    private ClientService clientService;

	    @Autowired
	    private ModelMapper mapper;

	    @Operation(summary="Get All Clients", description="Get All Clients", tags={"clients"})
	    @GetMapping("/clients")
	    public Page<ClientResource> getAllClients(Pageable pageable){
	        Page<Client> clientPage = clientService.getAllClients(pageable);
	        List<ClientResource> resources = clientPage.getContent()
	                .stream()
	                .map(this::convertToResource)
	                .collect(Collectors.toList());
	        return new PageImpl<>(resources, pageable, resources.size());
	    }

	    @Operation(summary="Create Clients", description="Create Clients", tags={"clients"})
	    @PostMapping("/clients")
	    public ClientResource createClient(@Valid @RequestBody SaveClientResource resource) {
	        Client client = convertToEntity(resource);
	        return convertToResource(clientService.createClient(client));
	    }

	    @Operation(summary="Delete Cliente By Id", description="Delete Cliente By Id", tags={"clients"})
	    @DeleteMapping("/clients/{clientId}")
	    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
	        return clientService.deleteClient(clientId);
	    }

	    private Client convertToEntity(SaveClientResource resource) {
	        return mapper.map(resource, Client.class);
	    }

	    private ClientResource convertToResource(Client entity)
	    {
	        return mapper.map(entity, ClientResource.class);
	    }
}
