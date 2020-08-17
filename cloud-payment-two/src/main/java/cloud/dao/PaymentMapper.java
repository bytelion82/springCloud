package cloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazy.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
