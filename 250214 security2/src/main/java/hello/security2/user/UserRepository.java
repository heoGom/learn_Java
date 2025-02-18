package hello.security2.user;

import org.springframework.data.jpa.repository.JpaRepository;

//CRUD 함수를 JpaRepo가 들고있음
// @Repository 안붙혀도 Ioc 된다. 이유는 JpaRepo를 상속했기 때문에
public interface UserRepository extends JpaRepository<User, Integer> {
}
