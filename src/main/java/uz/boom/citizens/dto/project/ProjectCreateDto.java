package uz.boom.citizens.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.dto.Dto;
import uz.boom.citizens.entity.organization.Organization;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:14
 * Project : library_boom
 */
@Getter
@Setter
@Builder
public class ProjectCreateDto implements Dto {

    private String name;
    private String tzPath;
    private Organization organization;

    public ProjectCreateDto(String name, String tzPath, Organization organization) {
        this.name = name;
        this.tzPath = tzPath;
        this.organization = organization;
    }
}
