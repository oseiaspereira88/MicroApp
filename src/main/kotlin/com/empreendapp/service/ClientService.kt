package com.empreendapp.service

import com.empreendapp.model.Client
import com.empreendapp.repository.ClientRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ClientService{

    @Inject
    private lateinit var repository: ClientRepository

    fun getClientById(id: Long): Optional<Client> {
        return repository.findById(id)
    }

    fun getAllClients(): MutableIterable<Client> {
        return repository.findAll()
    }

    fun getAllClientsByBusinessName(businessName: String): List<Client> {
        //return repository.findAllByBusinessName(businessName)
        return repository.findAll().filter { client -> client.businessName == businessName }
    }

    fun addClient(client: Client): Client {
        return repository.save(client)
    }

    fun updateClient(client: Client): Client {
        return repository.update(client)
    }

    fun deleteClient(id: Long) {
        repository.deleteById(id)
    }

}