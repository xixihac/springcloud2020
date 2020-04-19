import com.study.springcloud.entities.Payment;
import com.study.springcloud.mapper.PaymentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperTest {

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    public void test1(){
        Payment paymentById = paymentMapper.getPaymentById( 1);
        System.out.println(paymentById.getSerial());
    }
}
