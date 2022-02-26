package uz.boom.citizens.services.task;

import org.springframework.stereotype.Service;
import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.task.TaskCreateDto;
import uz.boom.citizens.dto.task.TaskDto;
import uz.boom.citizens.dto.task.TaskUpdateDto;
import uz.boom.citizens.entity.task.Task;
import uz.boom.citizens.mapper.task.TaskMapper;
import uz.boom.citizens.reposiroty.task.TaskRepository;
import uz.boom.citizens.services.AbstractService;
import uz.boom.citizens.utils.BaseUtils;
import uz.boom.citizens.utils.validators.task.TaskValidator;

import java.io.IOException;
import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper, TaskValidator> implements TaskService {
    protected TaskServiceImpl(TaskRepository repository, TaskMapper mapper, TaskValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(TaskCreateDto createDto) throws IOException {
        Task task = mapper.fromCreateDto(createDto);
        repository.save(task);
        return task.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public Void update(TaskUpdateDto updateDto) throws IOException {
        Task updateTask = repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Task Not found");
        });
        Task task = mapper.fromUpdateDto(updateDto, updateTask);
        repository.save(task);
        return null;
    }

    @Override
    public List<TaskDto> getAllById(GenericCriteria criteria, Long id) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TaskDto get(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        return mapper.toDto(task);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
