package fr.isika.cda.amap_generation.model.amap;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Forum {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column (name = "NOMBRE_SUJETS")
private int numberOfSubjects;

@OneToMany @JoinColumn(name="FK_SUJETS")
private List<Subject> subjects;



public int getNumberOfSubjects() {
	return numberOfSubjects;
}

public void setNumberOfSubjects(int numberOfSubjects) {
	this.numberOfSubjects = numberOfSubjects;
}

public List<Subject> getSubject() {
	return subjects;
}

public void setSubject(List<Subject> subject) {
	subjects = subject;
}

public Long getId() {
	return id;
}

}
