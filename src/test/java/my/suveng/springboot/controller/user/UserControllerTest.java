package my.suveng.springboot.controller.user;

import my.suveng.rss.controller.user.UserController;
import my.suveng.springboot.RssServerApplicationTests;
import my.suveng.rss.modules.user.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/19
 * description:
 **/
public class UserControllerTest extends RssServerApplicationTests {
    @Autowired
    UserController userController;

    @Test
    public void add() {
        int i = 0;
        while (i < 1000) {
            User user = new User();
            user.setRegTime(RandomStringUtils.randomAscii(5));
            user.setEmail(RandomStringUtils.randomAscii(5));
            user.setNickname(RandomStringUtils.randomAscii(5));
            user.setPassword(RandomStringUtils.randomAscii(5));
            user.setUsername(RandomStringUtils.randomAscii(5));
            userController.add(user);
            i++;
        }
    }
}
