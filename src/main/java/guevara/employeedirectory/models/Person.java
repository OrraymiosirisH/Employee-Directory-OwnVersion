package guevara.employeedirectory.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

@NotNull
@Size(min = 2)
private String firstname;

    @NotNull
    @Size(min = 2)
    private String lastname;

    @NotNull
    @Size(min = 2)
    private String cellphone;


    @NotNull
    @Size(min = 2)
    private String workphone;


private String position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deparment_id")
    private Department department;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }
    public String getPosition() {
       return position;
   }

   public void setPosition(String position) {
       this.position = position;
  }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
