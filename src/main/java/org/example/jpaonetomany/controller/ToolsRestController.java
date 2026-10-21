package org.example.jpaonetomany.controller;


import org.example.jpaonetomany.model.Region;
import org.example.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @GetMapping("getregioner")
    public List<Region> getRegioner() {
        return apiServiceGetRegioner.getRegioner();
    }

}
