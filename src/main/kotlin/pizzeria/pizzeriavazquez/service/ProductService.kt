package pizzeria.pizzeriavazquez.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pizzeria.pizzeriavazquez.model.*
import pizzeria.pizzeriavazquez.repository.ProductRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sun.invoke.empty.Empty

@Service
class ProductService {

    @Autowired
    lateinit var productRepository:ProductRepository

    fun findAllProducts(): Flux<Product> {
        return productRepository.findAll()
    }

    fun findProductById(id:String):Mono<Product>{
        return productRepository.findProductById(id)
    }

    fun deleteProductById(id:String):Mono<Empty>{
        return productRepository.deleteProductById(id)
    }

    fun existsProductById(id:String):Boolean{
        return productRepository.existsProductById(id)
    }

    fun findProductByType(type: TypeOfProduct):Flux<Product>{
        return productRepository.findProductByType(type)
    }
}

@Service
class BebidaService{

    @Autowired
    lateinit var productRepository: ProductRepository

    fun createBebida(bebida: Bebida):Mono<Bebida>{
        return productRepository.createBebida(bebida)
    }

}

@Service
class EmpanadaService{

    @Autowired
    lateinit var productRepository: ProductRepository

    fun createEmpanada(empanada:Empanada):Mono<Empanada>{
        return productRepository.createEmpanada(empanada)
    }
}

@Service
class PizzaService{

    @Autowired
    lateinit var productRepository: ProductRepository

    fun createPizza(pizza: Pizza):Mono<Pizza>{
        return productRepository.createPizza(pizza)
    }
}