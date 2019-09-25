import com.yc.po.Orderitems;
import com.yc.zip.impl.OrderItemZipImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/24  10:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-bean.xml")
public class TestOrderItem {
    @Autowired
    OrderItemZipImpl orderItemZip;

    @Test
    public void testInsert(){
        Orderitems orderitems = new Orderitems();
        List<Orderitems> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orderitems.setOid(i);
            orderitems.setOtcid("2");
            list.add(orderitems);
        }
        System.out.println(orderItemZip.insert(list));
    }
}
