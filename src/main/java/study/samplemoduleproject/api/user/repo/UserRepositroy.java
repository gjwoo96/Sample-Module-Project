package study.samplemoduleproject.api.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.samplemoduleproject.api.user.domain.User;

@Repository
public interface UserRepositroy extends CrudRepository<User, Long> {
    User findByLoginId(String loginId);
}
