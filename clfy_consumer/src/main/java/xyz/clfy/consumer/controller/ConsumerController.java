package xyz.clfy.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.clfy.consumer.dto.EmployeeDTO;
import xyz.clfy.consumer.infra.maskant.ProviderAdaptor;

import java.util.List;

@RestController("consumerController.v1")
@RequestMapping("/v1/{organizationId}/consumer")
public class ConsumerController {

    @Autowired
    private ProviderAdaptor providerAdaptor;
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("organizationId") Long tenantId, @PathVariable("id") Long id) {
        System.out.println("tenantId:" + tenantId+",id:" + id);
        String result = providerAdaptor.getEmployeeById(tenantId,id);
        return result;
    }
    @PostMapping("/save")
    public String postRequest(@PathVariable("organizationId") Long tenantId, @RequestBody List<EmployeeDTO> employees) {
        System.out.println("tenantId:" + tenantId+",employeeDTO:" + JSONObject.toJSONString(employees));
        String result = providerAdaptor.saveEmployee(tenantId,employees);
        return result;
    }
}
