package uz.boom.citizens.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.citizens.entity.organization.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

}
