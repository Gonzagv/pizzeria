package pizzeria.pizzeriavazquez.model

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document(collection = "products")
open class Product {
    @Id
    var id:String=""
    var name:String=""
    var precio=0
    var description:String=""
    var typeOfProduct:TypeOfProduct= TypeOfProduct.DEFAULT

}

class Pizza():Product(){
    var size:String=""
}

class Empanada():Product(){
    var cookingType:String=""
}

class Bebida():Product(){
}

enum class TypeOfProduct(text:String){
    BEBIDA("bebida"),
    PIZZA("pizza"),
    EMPANADA("empanada"),
    DEFAULT("default")
}
