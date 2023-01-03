package com.empreendapp.model

import com.empreendapp.listeners.PortifolioListener
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "portifolio")
@EntityListeners(PortifolioListener::class)
data class Portifolio(

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    val id: Long? = null,

    @javax.persistence.Column(name = "nome", nullable = false)
    val name: String? = null,

    @javax.persistence.Column(name = "descricao", nullable = false)
    val description: String? = null,

    @javax.persistence.Column(name = "imagem", nullable = false)
    val image: String? = null,

    @javax.persistence.Column(name = "link", nullable = false)
    val link: String? = null,

    @javax.persistence.Column(name = "ativo", nullable = false)
    val technologies: String? = null,

    @javax.persistence.Column(name = "tecnologias", nullable = false)
    val type: String? = null

)
