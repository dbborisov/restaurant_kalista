package bg.kalista.web.data.repository;

import bg.kalista.web.data.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details,Long> {

    Details findByDetailName(String name);

}
