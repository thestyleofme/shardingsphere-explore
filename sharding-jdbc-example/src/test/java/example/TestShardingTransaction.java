package example;

import com.github.thestyleofme.example.ExampleApplication;
import com.github.thestyleofme.example.entity.Position;
import com.github.thestyleofme.example.entity.PositionDetail;
import com.github.thestyleofme.example.repository.PositionDetailRepository;
import com.github.thestyleofme.example.repository.PositionRepository;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * description
 * </p>
 *
 * @author thestyleofme 2021-02-10 00:44
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestShardingTransaction {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PositionDetailRepository positionDetailRepository;

    @Test
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void test1() {
        // 方法上面的@ShardingTransactionType(TransactionType.XA)跟下面方法效果一致
        // TransactionTypeHolder.set(TransactionType.XA);
        for (int i = 1; i <= 3; i++) {
            Position position = new Position();
            position.setCity("chengdu" + i);
            position.setName("root" + i);
            position.setSalary("18000" + i);
            positionRepository.save(position);

            if (i == 3) {
                throw new IllegalStateException("模仿异常");
            }

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("root" + i);
            positionDetailRepository.save(positionDetail);
        }
        Assert.assertTrue(positionDetailRepository.count() >= 3);
    }
}
