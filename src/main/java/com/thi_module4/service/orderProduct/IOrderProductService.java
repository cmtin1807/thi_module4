package com.thi_module4.service.orderProduct;

import com.thi_module4.model.OrderProduct;
import com.thi_module4.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderProductService extends IGenerateService<OrderProduct> {
    Page<OrderProduct> findAll(Pageable pageable);


}
