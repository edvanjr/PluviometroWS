package controllers;

import java.util.List;

import models.Alerta;
import models.Medida;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
    public static Result medidas() {
    	List<Medida> medidas = JPA.em().createQuery("FROM Medida").getResultList();
        return ok(Json.toJson(medidas));
    }
    
    @Transactional
    public static Result alerta() {
    	Alerta alerta = (Alerta) JPA.em().createQuery("FROM Alerta").getResultList().get(0);
        return ok(Json.toJson(alerta));
    }
    
    @Transactional
    public static Result alterarAlerta(Double valor) {
    	Alerta alerta = JPA.em().find(Alerta.class, 1);
    	alerta.valor = valor;
        return ok(Json.toJson("Alerta alterado para " + valor));
    }
    
    @Transactional
    public static Result criarAlerta() {
    	
    	List<Alerta> alertas = JPA.em().createQuery("FROM Alerta").getResultList();
    	
    	if(alertas.size() > 0){
    		return ok(Json.toJson("Alerta já foi criado. Você agora pode apenas alterar."));
    	}
    	
    	Alerta alerta = new Alerta();
    	alerta.valor = 10.0;
    	JPA.em().persist(alerta);
        return ok(Json.toJson("Alerta criado!"));
    }
  
}
