package guevara.employeedirectory.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

private String departname;

    public String getDeparthead()
    {
        return departhead;
    }

    public void setDeparthead(String departhead)
    {
        this.departhead = departhead;
    }

    private String departhead;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Person> persons;

    public Department(){
        setPersons(new HashSet<Person>());

    }

    public void set(String name) {
        this.departname = name;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

public void addPerson(Person pers) {
 pers.setDepartment(this);
    this.persons.add(pers);

}

}
