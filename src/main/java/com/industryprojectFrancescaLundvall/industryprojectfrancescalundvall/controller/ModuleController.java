package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.ModuleNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/modules")
    public Module saveModule(@Valid @RequestBody Module module){
        return moduleService.saveModule(module);
    }

    @DeleteMapping("/modules/{id}")
    public String deleteModuleById(@PathVariable("id") Long moduleId){
        moduleService.deleteModuleById(moduleId);
        return "Module " + moduleId + "has been deleted";
    }

    @PutMapping("/modules/{id}")
    public Module updateModule(@PathVariable("id") Long moduleId, @RequestBody Module module){
        return moduleService.updateModule(moduleId, module);
    }

    @GetMapping("/modules/{id}")
    public Module fetchModuleByID(@PathVariable("id") Long moduleId) throws ModuleNotFoundException {
        return moduleService.fetchModuleById(moduleId);
    }

    @GetMapping("/modules")
    public List<Module> fetchModuleList(){
        return moduleService.fetchModuleList();
    }

    @GetMapping("modules/name/{name}")
    public Module fetchModuleByName(@PathVariable("name") String moduleName){
        return moduleService.fetchModuleByName(moduleName);
    }

}
