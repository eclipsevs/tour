import com.yc.controller.HotelController;
import com.yc.po.Hotel;
import com.yc.zip.impl.HotelBizImpl;
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
 * @date 2019/9/28  18:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-bean.xml")
public class TestHotel {
    @Autowired
    private HotelBizImpl hotelBiz;

    @Test
    public void find(){
        System.out.println(hotelBiz.findAll());
    }

    @Test
    public void findById(){
        System.out.println(hotelBiz.findById(1));
    }


}
