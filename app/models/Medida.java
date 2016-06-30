package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medidas")
public class Medida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column(name = "data_medida")
	public Timestamp dataMedida;
	public Double altura;
	public Double volume;
	public Double litros;
	public String pluviometro;
}
