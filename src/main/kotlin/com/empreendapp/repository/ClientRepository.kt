package com.empreendapp.repository

import com.empreendapp.model.BusinessClient
import io.micronaut.data.jpa.repository.JpaRepository

@io.micronaut.data.annotation.Repository
interface ClientRepository : JpaRepository<BusinessClient, Long>{
    fun findAllByBusinessName(businessName: String): List<BusinessClient>
}