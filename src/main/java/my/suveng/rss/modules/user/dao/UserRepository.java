package my.suveng.rss.modules.user.dao;

import my.suveng.rss.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/19
 * description:
 **/
public interface UserRepository extends JpaRepository<User,Long> {
}
