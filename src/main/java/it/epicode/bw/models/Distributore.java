package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "distributori")
public class Distributore extends PuntoVendita{

	private StatoDistributore stato;
}
