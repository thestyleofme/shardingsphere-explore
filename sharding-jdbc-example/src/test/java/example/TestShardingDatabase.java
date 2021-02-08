package example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.City;
import com.github.thestyleofme.example.entity.OrderB;
import com.github.thestyleofme.example.entity.Position;
import com.github.thestyleofme.example.entity.PositionDetail;
import com.github.thestyleofme.example.repository.CityRepository;
import com.github.thestyleofme.example.repository.OrderRepositoryB;
import com.github.thestyleofme.example.repository.PositionDetailRepository;
import com.github.thestyleofme.example.repository.PositionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
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
    @Autowired
    private PositionDetailRepository positionDetailRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private OrderRepositoryB orderRepositoryB;

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

    @Test
    public void testAdd2() {
        Position position;
        PositionDetail positionDetail;
        for (int i = 1; i <= 20; i++) {
            position = new Position();
            position.setCity("city" + i);
            position.setName("name" + i);
            position.setSalary("1000" + i);
            positionRepository.save(position);

            positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("desc" + i);
            positionDetailRepository.save(positionDetail);
        }
        Assert.assertTrue(positionDetailRepository.count() >= 20);
    }

    @Test
    public void testJoin() {
        Object obj = positionRepository.findPositionById(560846413353713665L);
        Assert.assertNotNull(obj);
        System.out.println("===============");
        Object[] objects = (Object[]) obj;
        Arrays.stream(objects).forEach(System.out::println);
        System.out.println("===============");
    }

    @Test
    public void testBroadcast() {
        City city = new City();
        city.setName("chengdu");
        city.setProvince("sichuan");
        cityRepository.save(city);
        Assert.assertNotNull(city.getId());
    }

    @Test
    @Repeat(20)
    public void testShardingOrder() {
        OrderB orderB = new OrderB();
        orderB.setIsDel(false);
        orderB.setCompanyId(ThreadLocalRandom.current().nextInt(10));
        orderB.setPositionId(232323L);
        orderB.setUserId(2222);
        orderB.setPublishUserId(1111);
        orderB.setResumeType(1);
        orderB.setStatus("AUTO");
        orderB.setCreateTime(LocalDateTime.now());
        orderB.setOperateTime(LocalDateTime.now());
        orderB.setWorkYear("2");
        orderB.setName("name1");
        orderB.setPositionName("JAVA");
        orderB.setResumeId(23232);
        orderRepositoryB.save(orderB);
        Assert.assertNotNull(orderB.getId());
    }

}
