package pizzeria.pizzeriavazquez.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.stereotype.Component
import pizzeria.pizzeriavazquez.model.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sun.invoke.empty.Empty

@Component
@EnableReactiveMongoRepositories
interface ProductRepository: ReactiveMongoRepository<Product, String> {
    fun findProductById(id:String): Mono<Product>
    fun deleteProductById(id:String):Mono<Empty>
    fun findProductByType(type:TypeOfProduct):Flux<Product>
    fun createBebida(bebida: Bebida):Mono<Bebida>
    fun existsProductById(id:String):Boolean
    fun createEmpanada(empanada:Empanada):Mono<Empanada>
    fun createPizza(pizza: Pizza):Mono<Pizza>
}