package uz.boom.citizens.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.organization.Organization;
import uz.boom.citizens.reposiroty.AbstractRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

}
