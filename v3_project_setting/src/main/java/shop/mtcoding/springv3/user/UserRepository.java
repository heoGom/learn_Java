package shop.mtcoding.springv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.username=:username")
    User findByUsername(@Param("username") String username);
}
