import com.yc.controller.OrderController;
import com.yc.po.Order;
import com.yc.zip.impl.OrderZipImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/23  15:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-bean.xml")
public class TestOrder {
    @Autowired
    private OrderZipImpl orderZip;
    OrderController controller = new OrderController();

    /**
     * 测试订单表的查询全部
     */
    @Test
    public void testFindAll() {
        int ostatus = 1;
        int uid = 2;
//        List<Object> list = orderZip.findAll(ostatus, uid);
//        System.out.println(list);
    }

    /**
     * 测试订单表的更新订单状态
     */
    @Test
    public void testUpdateStatus() {
        System.out.println(controller.updateStatus("14x15",2));
    }

    @Test
    public void testDelete(){
        int oid = 9 ;
        System.out.println(orderZip.delete(oid));
    }

}
