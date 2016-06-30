package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alerta")
public class Alerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public Double valor;
}
