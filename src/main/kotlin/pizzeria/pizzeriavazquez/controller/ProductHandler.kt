package pizzeria.pizzeriavazquez.controller

import jdk.nashorn.internal.runtime.logging.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import pizzeria.pizzeriavazquez.model.*
import pizzeria.pizzeriavazquez.service.BebidaService
import pizzeria.pizzeriavazquez.service.EmpanadaService
import pizzeria.pizzeriavazquez.service.PizzaService
import pizzeria.pizzeriavazquez.service.ProductService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import sun.invoke.empty.Empty
import javax.xml.ws.Response

@Controller
@Logger
@RequestMapping("/v1/api")
class ProductHandler {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping(value=["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findProducts(): ResponseEntity<Flux<Product>>{
        var productos:Flux<Product> = productService.findAllProducts();
        return ResponseEntity(productos, HttpStatus.OK)
    }

    @GetMapping(value = ["/product/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findProductById(@PathVariable("{id}")id:String): ResponseEntity<Mono<Product>>{
        try {
            return if(!productService.existsProductById(id)) {
                var product: Mono<Product> = productService.findProductById(id)
                ResponseEntity(product, HttpStatus.OK)
            }else{
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        }catch (exception:Exception){
            throw Exception("Service unavailable.")
        }
    }

    @DeleteMapping(value = ["/product/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteProductById(@PathVariable("{id}")id:String):ResponseEntity<Mono<Empty>>{
        return ResponseEntity(productService.deleteProductById(id),HttpStatus.OK)
    }

    @GetMapping(value=["/bebidas"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findBebidas(type:TypeOfProduct):ResponseEntity<Flux<Product>>{
        var products:Flux<Product> = productService.findProductByType(type)
        return ResponseEntity(products, HttpStatus.OK)
    }
}

@Controller
@RequestMapping("/v1/api/products")
class BebidaHandler{

    @Autowired
    lateinit var bebidaService: BebidaService
    @Autowired
    lateinit var productService: ProductService

    @PostMapping(value = ["/bebidas"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createBebida(@RequestBody bebida: Bebida):ResponseEntity<Mono<Bebida>>{
        try {
            return if(!productService.existsProductById(bebida.id)) {
                ResponseEntity(bebidaService.createBebida(bebida), HttpStatus.CREATED)
            }else{
                ResponseEntity(HttpStatus.CONFLICT)
            }
        }catch (exception:Exception){
            throw Exception("Unexpected Error")
        }
    }

@Controller
@RequestMapping(value = ["/empanadas"],produces = [MediaType.APPLICATION_JSON_VALUE])
class EmpanadaHandler{

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var empanadaService: EmpanadaService

    @PostMapping(value = ["/empanadas"],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createEmpanada(@RequestBody empanada:Empanada):ResponseEntity<Mono<Empanada>>{
        try {
            return if(!productService.existsProductById(empanada.id)){
                ResponseEntity(empanadaService.createEmpanada(empanada),HttpStatus.CREATED)
            }else{
                ResponseEntity(HttpStatus.CONFLICT)
            }
        }catch (exception:Exception){
            throw Exception("Unexpected Error")
        }
    }
}

@Controller
@RequestMapping(value=["/pizzas"],produces = [MediaType.APPLICATION_JSON_VALUE])
class PizzaHandler{

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var pizzaService: PizzaService

    fun createPizza(@RequestBody pizza: Pizza):ResponseEntity<Mono<Pizza>>{
        try {
            return if(!productService.existsProductById(pizza.id)){
                ResponseEntity(pizzaService.createPizza(pizza),HttpStatus.CREATED)
            }else{
                ResponseEntity(HttpStatus.CONFLICT)
            }
        }catch (exception:Exception){
            throw Exception("Unexpected Error")
        }
    }
}

}