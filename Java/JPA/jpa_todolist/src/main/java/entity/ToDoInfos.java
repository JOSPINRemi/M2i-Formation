package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todo_infos")
public class ToDoInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infos_todo")
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date echeance;
    @Column(nullable = false)
    private Integer priorite;
    @OneToOne(mappedBy = "infos")
    private ToDo toDo;

    public ToDoInfos() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "ToDoInfos{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", echeance=" + echeance +
                ", priorite=" + priorite +
                '}';
    }
}
