package pizzeria.pizzeriavazquez.model

open class Product{
    var name:String="";
    var precio=0;
    var description:String="";

    constructor(name: String, precio: Int, description: String) {
        this.name = name
        this.precio = precio
        this.description = description
    }

    constructor();
}

class Pizza():Product(){
    var size:String="";
}

class Empanada():Product(){
    var cookingType:String="";
}

class Bebida():Product(){
}
