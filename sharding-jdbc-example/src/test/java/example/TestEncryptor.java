package example;

import java.util.List;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.UserC;
import com.github.thestyleofme.example.repository.UserRepositoryC;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-08 23:36
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestEncryptor {

    @Autowired
    private UserRepositoryC userRepositoryC;

    @Test
    public void testAdd() {
        UserC userC = new UserC();
        userC.setName("thestyleofme");
        userC.setPwd("abc");
        userRepositoryC.save(userC);
        Assert.assertNotNull(userC.getId());
    }

    @Test
    public void testFind() {
        List<UserC> list = userRepositoryC.findByPwd("abc");
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        list.forEach(System.out::println);
    }
}
