package cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crazy.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;


public interface IPaymentService extends IService<Payment> {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
