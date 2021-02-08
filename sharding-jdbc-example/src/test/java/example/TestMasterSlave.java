package example;

import java.util.List;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.City;
import com.github.thestyleofme.example.repository.CityRepository;
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
 * @author thestyleofme 2021-01-28 10:44:12
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestMasterSlave {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testAdd() {
        City city = new City();
        city.setName("beijing");
        city.setProvince("beijing");
        cityRepository.save(city);
        Assert.assertNotNull(city.getId());
    }

    @Test
    public void testFind() {
        List<City> list = cityRepository.findAll();
        Assert.assertNotNull(list);
        list.forEach(System.out::println);
    }

}
