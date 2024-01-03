package entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @Enumerated(EnumType.STRING)
    private ToDoStatus status;

    public ToDo() {
    }

    public ToDo(String label, ToDoStatus status) {
        this.label = label;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ToDoStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", status=" + status +
                '}';
    }
}
