package xyz.clf.provider.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import xyz.clf.provider.dto.EmployeeDTO;

import java.util.List;

@RestController("providerController.v1")
@RequestMapping("/v1/{organizationId}/provider")
public class ProviderController {
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("organizationId") Long tenantId,@PathVariable("id") Long id) {
        System.out.println("tenantId:" + tenantId+",id:" + id);
        return "provider get id:" + id;
    }
    @PostMapping("/save")
    public String saveEmployee(@PathVariable("organizationId") Long tenantId,@RequestBody List<EmployeeDTO> employees) {
        System.out.println("tenantId:" + tenantId+",employees:"+ JSONObject.toJSONString(employees));
        return "provider post count:" + employees.size();
    }
}
