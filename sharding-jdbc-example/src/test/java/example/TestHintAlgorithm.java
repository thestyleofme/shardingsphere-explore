package example;

import java.util.List;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.City;
import com.github.thestyleofme.example.repository.CityRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-04 10:52
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestHintAlgorithm {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testHintDatabase() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(1L);
        List<City> list = cityRepository.findAll();
        Assert.assertNotNull(list);
        list.forEach(System.out::println);
    }
}
