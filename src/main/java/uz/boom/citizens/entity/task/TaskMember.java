package uz.boom.citizens.entity.task;

import uz.boom.citizens.entity.auth.AuthUser;

import javax.persistence.*;

@Entity
@Table(name = "task_user")
public class TaskMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private AuthUser user;
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}