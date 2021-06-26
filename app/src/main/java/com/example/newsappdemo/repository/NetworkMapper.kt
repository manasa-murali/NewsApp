package com.example.newsappdemo.repository

/**
 * Created by Manasa on 26,June,2021
 */
interface NetworkMapper<Domain, Entity> {
    fun mapFromEntity(entity: Entity): Domain

    fun mapToEntity(domain: Domain): Entity

}