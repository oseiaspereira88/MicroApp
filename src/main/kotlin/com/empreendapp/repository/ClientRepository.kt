package com.empreendapp.repository

import com.empreendapp.model.Client
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.annotation.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long>{
    fun findAllByBusinessName(businessName: String): List<Client>
}