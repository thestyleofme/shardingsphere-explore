package example;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.Position;
import com.github.thestyleofme.example.repository.PositionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description
 *
 * @author thestyleofme 2021/01/25 4:15 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestShardingDatabase {

    @Autowired
    private PositionRepository positionRepository;

    @Test
    public void testAdd() {
        Position position;
        for (int i = 1; i <= 20; i++) {
            position = new Position();
            // position.setId((long) i);
            position.setCity("city" + i);
            position.setName("name" + i);
            position.setSalary("1000" + i);
            positionRepository.save(position);
        }
        Assert.assertTrue(positionRepository.count() >= 20);
    }

}
