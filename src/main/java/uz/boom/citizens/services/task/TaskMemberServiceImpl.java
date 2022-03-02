package uz.boom.citizens.services.task;

import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.entity.auth.AuthUser;
import uz.boom.citizens.entity.task.TaskMember;
import uz.boom.citizens.mapper.auth.AuthUserMapper;
import uz.boom.citizens.mapper.task.TaskMemberMapper;
import uz.boom.citizens.reposiroty.auth.AuthUserRepository;
import uz.boom.citizens.reposiroty.project.ProjectRepository;
import uz.boom.citizens.reposiroty.task.TaskMemberRepository;
import uz.boom.citizens.reposiroty.task.TaskRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.task.TaskValidator;

import java.util.ArrayList;
import java.util.List;

public class TaskMemberServiceImpl extends AbstractService<TaskMemberRepository, TaskMemberMapper, TaskValidator> {
    private final AuthUserRepository authUserRepository;
    private final AuthUserMapper authUserMapper;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;


    protected TaskMemberServiceImpl(TaskMemberRepository repository, TaskMemberMapper mapper, TaskValidator validator, BaseUtils baseUtils, AuthUserRepository authUserRepository, AuthUserMapper authUserMapper, ProjectRepository projectRepository, TaskRepository taskRepository) {
        super(repository, mapper, validator, baseUtils);
        this.authUserRepository = authUserRepository;
        this.authUserMapper = authUserMapper;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }


    public List<AuthUserDto> getMembers(Long id) {
        List<TaskMember> taskMember1 = repository.findAllByTaskId(id);
        List<AuthUser> authUsers=new ArrayList<>();
        for (TaskMember taskMember : taskMember1) {
            authUsers.add(taskMember.getUser());
        }
        return authUserMapper.toDto(authUsers);
    }

}
