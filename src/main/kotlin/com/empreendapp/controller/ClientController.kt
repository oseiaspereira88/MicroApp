package com.empreendapp.controller

import com.empreendapp.model.Client
import com.empreendapp.service.ClientService
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/clients")
class ClientController {

    @Inject
    private lateinit var service: ClientService

    @Get
    fun getAll(): HttpResponse<Any> {
        return HttpResponse.ok(service.getAllClients())
    }

    @Get("/{businessName}")
    fun getAllByBusinessName(@PathVariable businessName: String): HttpResponse<Any> {
        return HttpResponse.ok(service.getAllClientsByBusinessName(businessName))
    }

    @Get("/id/{id}")
    fun getById(@PathVariable id: String): HttpResponse<Any> {
        val client = service.getClientById(id.toLong())
        return if (client.isPresent) {
            HttpResponse.ok(client.get())
        } else {
            HttpResponse.notFound()
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/create")
    fun create(@Body client: Client, request: HttpRequest<String>): HttpResponse<Any> {

        println("Request body: ${request.body.get() ?: null}")
        println("Request formdata: ${request.body.get() ?: null}")

        return HttpResponse.created(service.addClient(client))
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/edit/{id}")
    fun edit(
        @PathVariable id: String,
        @Body updatedClient: Client
    ): HttpResponse<Any> {
        val oldClient = service.getClientById(id.toLong())
        return if (oldClient.isPresent) {
            updatedClient.id = oldClient.get().id
            HttpResponse.ok(service.updateClient(updatedClient))
        } else {
            HttpResponse.notFound()
        }
    }

    @Delete("/delete/{id}")
    fun delete(@PathVariable id: String): HttpResponse<Any> {
        val client = service.getClientById(id.toLong())
        return if (client.isPresent) {
            service.deleteClient(id.toLong())
            HttpResponse.ok()
        } else {
            HttpResponse.notFound()
        }
    }
}