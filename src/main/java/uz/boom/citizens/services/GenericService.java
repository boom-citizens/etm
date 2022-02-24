package uz.boom.citizens.services;

import uz.boom.citizens.criteria.GenericCriteria;
import uz.boom.citizens.dto.GenericDto;
import uz.boom.citizens.dto.auth.AuthUserDto;
import uz.boom.citizens.entity.auth.AuthUser;

import java.io.Serializable;
import java.util.List;


/**
 * @param <D> -> Dto
 * @param <K> -> class that defines the primary key for your pojo class
 * @param <C> -> Criteria (For Filtering Request)
 */
public interface GenericService<
        D extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends BaseService {

    List<D> getAll(C criteria);

    D get(K id);

    Long totalCount(C criteria);
}
