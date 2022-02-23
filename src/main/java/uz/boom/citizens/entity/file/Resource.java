package uz.boom.citizens.entity.file;

import lombok.Getter;
import lombok.Setter;
import uz.boom.citizens.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "uploads")
public class Resource extends Auditable {

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "generated_name")
    private String generatedName;

    private long size;

    @Column(name = "content_type")
    private String contentType;

    private String path;
}