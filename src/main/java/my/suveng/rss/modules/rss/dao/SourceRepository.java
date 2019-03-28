package my.suveng.rss.modules.rss.dao;

import my.suveng.rss.modules.rss.entity.Source;
import my.suveng.rss.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/19
 * description:
 **/
public interface SourceRepository extends JpaRepository<Source,Long> {

}
