package cloud.service.impl;


import cloud.dao.PaymentMapper;
import cloud.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazy.cloud.entity.Payment;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService extends ServiceImpl<PaymentMapper,Payment> implements IPaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentMapper.getPaymentById(id);
    }


}
