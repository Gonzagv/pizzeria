package pizzeria.pizzeriavazquez.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pizzeria.pizzeriavazquez.model.Client
import pizzeria.pizzeriavazquez.repository.ClientRepository
import reactor.core.publisher.Mono
import kotlin.Exception

@Service
class ClientService {

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun findClientById(id:String):Mono<Client>{
        return clientRepository.findClientById(id)
    }

    fun existsClientById(id:String): Boolean {
        var clientMono:Mono<Boolean> = clientRepository.existsClientById(id)
        return clientMono.equals(true)
    }


}