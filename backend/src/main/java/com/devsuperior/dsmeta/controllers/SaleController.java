package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private SaleService service;

    @GetMapping
        // na web usa string não LocalDate
    Page<SaleDTO> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                            @RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notitySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
