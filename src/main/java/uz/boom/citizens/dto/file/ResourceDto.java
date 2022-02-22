package uz.boom.citizens.dto.file;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResourceDto {
    private String originalName;
    private String generatedName;
    private long size;
    private String contentType;
    private String path;
}
