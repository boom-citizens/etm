package uz.boom.citizens.entity.task;

import uz.boom.citizens.entity.auth.AuthUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task_user")
public class TaskMember implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AuthUser user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    public Task getTask() {
        return task;
    }


    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}