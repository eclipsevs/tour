import com.yc.po.Spot;
import com.yc.zip.impl.SpotZipImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2020/3/10  10:49
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-bean.xml")
public class TestSpot {
    @Autowired
    SpotZipImpl spotZip;
    @Test
    public void testFindAll(){
        HttpServletRequest request = null;
        List<Spot> list = new ArrayList<>();
        list = spotZip.findAll(null);
        System.out.println(list);
    }
}
