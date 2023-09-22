package com.empreendapp.model

import com.empreendapp.listeners.ClientListener
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GenerationType

@Entity
@EntityListeners(ClientListener::class)
data class Client(

    @javax.persistence.Id
    @javax.persistence.Column(name = "id", nullable = false)
    @javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @javax.persistence.Column(name = "name", nullable = false)
    var name: String? = null,

    @javax.persistence.Column(name = "image_src", nullable = false)
    var imageSrc: String? = null,

    @javax.persistence.Column(name = "business_name", nullable = false)
    var businessName: String? = null,

)