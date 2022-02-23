package uz.boom.citizens.services.project;

import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.project.ProjectCreateDto;
import uz.boom.citizens.dto.project.ProjectDto;
import uz.boom.citizens.dto.project.ProjectUpdateDto;
import uz.boom.citizens.entity.project.Project;
import uz.boom.citizens.services.GenericCrudService;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:33
 * Project : library_boom
 */
public interface ProjectService extends GenericCrudService<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long
        > {
}
