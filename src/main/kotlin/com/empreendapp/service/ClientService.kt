package com.empreendapp.service

import com.empreendapp.model.BusinessClient
import com.empreendapp.repository.ClientRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ClientService{

    @Inject
    private lateinit var repository: ClientRepository

    fun getClientById(id: Long): Optional<BusinessClient> {
        return repository.findById(id)
    }

    fun getAllClients(): MutableIterable<BusinessClient> {
        return repository.findAll()
    }

    fun getAllClientsByBusinessName(businessName: String): List<BusinessClient> {
        //return repository.findAllByBusinessName(businessName)
        return repository.findAll().filter { client -> client.businessName == businessName }
    }

    fun addClient(businessClient: BusinessClient): BusinessClient {
        return repository.save(businessClient)
    }

    fun updateClient(businessClient: BusinessClient): BusinessClient {
        return repository.update(businessClient)
    }

    fun deleteClient(id: Long) {
        repository.deleteById(id)
    }

}