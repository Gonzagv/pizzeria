package pizzeria.pizzeriavazquez.model

import java.time.LocalDateTime
import javax.persistence.Id

class Order{
    @Id
    var id:String="";
    var productosSolicitados=Array(2){
        var idProduct:String="";
        var cantidad:String="";
    }
    var estado:Estado=Estado.NUEVO;
    var fechaAlta = LocalDateTime.now()
    var fechaActualizacion=LocalDateTime.now();
    var formaDePago:FormaDePago=FormaDePago.EFECTIVO;

    constructor()

    constructor(id: String, productosSolicitados: Array<Unit>, estado: Estado, fechaAlta: LocalDateTime?, fechaActualizacion: LocalDateTime?, formaDePago: FormaDePago) {
        this.id = id
        this.productosSolicitados = productosSolicitados
        this.estado = estado
        this.fechaAlta = fechaAlta
        this.fechaActualizacion = fechaActualizacion
        this.formaDePago = formaDePago
    }

}
enum class Estado(val text:String){
    NUEVO("nuevo"),
    EMPEZADO("empezado"),
    EN_PROCESO("en proceso"),
    ENTREGADO("entregado")
}

enum class FormaDePago{
    EFECTIVO,TARJETA_DE_CREDITO
}

