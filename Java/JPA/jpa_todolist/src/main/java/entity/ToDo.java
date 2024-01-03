package entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_todo")
    private Long id;
    private String label;
    @Enumerated(EnumType.STRING)
    private ToDoStatus status;
    @OneToOne
    @JoinColumn(name = "todo_infos_id", referencedColumnName = "id_infos_todo")
    private ToDoInfos infos;

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

    public ToDoInfos getInfos() {
        return infos;
    }

    public void setInfos(ToDoInfos infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", status=" + status +
                ", infos=" + infos +
                '}';
    }
}
