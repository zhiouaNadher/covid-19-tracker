package tn.itserv.covid19tracker.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	private String name;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	List<Patient> patients = new ArrayList<Patient>();
}
