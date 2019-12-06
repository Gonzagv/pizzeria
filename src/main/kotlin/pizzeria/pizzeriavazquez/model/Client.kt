package pizzeria.pizzeriavazquez.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document(collection = "Clients")
class Client {
    @Id
    var id:String="";
    var name:String="";
    var apellido:String="";
    var telefono:String="";
    var direccion = object{
        var calleYNumero:String="";
        var piso=0;
        var departamento:String="";
        var codigoPostal=0;
    }
    var fechaDeAlta= LocalDateTime.now();

    constructor()

    constructor(id: String, name: String, apellido: String, telefono: String, direccion: Any, fechaDeAlta: LocalDateTime?) {
        this.id = id
        this.name = name
        this.apellido = apellido
        this.telefono = telefono
        this.direccion = direccion
        this.fechaDeAlta = fechaDeAlta
    }
}