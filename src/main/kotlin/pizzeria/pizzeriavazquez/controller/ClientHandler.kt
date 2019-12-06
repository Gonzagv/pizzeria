package pizzeria.pizzeriavazquez.controller

import jdk.nashorn.internal.runtime.logging.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import pizzeria.pizzeriavazquez.model.Client
import pizzeria.pizzeriavazquez.service.ClientService
import reactor.core.publisher.Mono

@Controller
@Logger
@RequestMapping("/v1/api")
class ClientHandler {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping(value = ["/clients/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findClientById(@PathVariable("{id}")id:String):ResponseEntity<Mono<Client>>{
        try {
            return if(!clientService.existsClientById(id)) {
                ResponseEntity(clientService.findClientById(id), HttpStatus.OK)
            }else{
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        }catch (exception:Exception){
            throw Exception("Service unavailable.")
        }
    }
}