package com.thi_module4.controller;

import com.thi_module4.model.OrderProduct;
import com.thi_module4.service.orderProduct.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order-products")
public class OrderProductController {

    @Autowired
    private IOrderProductService orderProductService;

    @GetMapping
    public String listOrders(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int size,
                             Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Iterable<OrderProduct> orders = orderProductService.findAll(pageable);
        model.addAttribute("orders", orders);
        return "orderProduct/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional orderProduct = orderProductService.findById(id);
        model.addAttribute("orderProduct", orderProduct);
        return "orderProduct/edit";

    }

    @PostMapping("/update")
    public String updateOrder(@ModelAttribute("orderProduct") OrderProduct orderProduct) {
        orderProductService.save(orderProduct);
        return "redirect:/order-products";
    }
}
