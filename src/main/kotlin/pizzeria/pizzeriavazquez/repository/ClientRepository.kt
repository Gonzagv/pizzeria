package pizzeria.pizzeriavazquez.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import pizzeria.pizzeriavazquez.model.Client
import reactor.core.publisher.Mono

interface ClientRepository : ReactiveMongoRepository<Client,String>{
    fun findClientById(id:String): Mono<Client>
    fun existsClientById(id:String):Mono<Boolean>
}