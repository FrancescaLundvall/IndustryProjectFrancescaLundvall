package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.ModuleNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RequestMapping maps all HTTPS Module requests to /modules
@RestController
@RequestMapping("/modules")
public class ModuleController {

    //This injects a ModuleService bean from the application context container
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/save")
    public Module saveModule(@Valid @RequestBody Module module){
        return moduleService.saveModule(module);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteModuleById(@PathVariable("id") Long moduleId){
        moduleService.deleteModuleById(moduleId);
        return "Module " + moduleId + " has been deleted";
    }

    @PutMapping("/update/{id}")
    public Module updateModule(@PathVariable("id") Long moduleId, @RequestBody Module module){
        return moduleService.updateModule(moduleId, module);
    }

    @GetMapping("/display/{id}")
    public Module fetchModuleByID(@PathVariable("id") Long moduleId) throws ModuleNotFoundException {
        return moduleService.fetchModuleById(moduleId);
    }

    @GetMapping("/display")
    public List<Module> fetchModuleList(){
        return moduleService.fetchModuleList();
    }

    @GetMapping("display/name/{name}")
    public Module fetchModuleByName(@PathVariable("name") String moduleName){
        return moduleService.fetchModuleByName(moduleName);
    }
    //This requests list of all modules which are taught by a particular staff member
    @GetMapping("/display/staffId/{staffId}")
    List<Module> fetchByStaffId(Long staffId){
        return moduleService.fetchByStaffId(staffId);
    }

    //This requests list of all modules which are offered by a particular course
    @GetMapping("/display/courseId/{courseId}")
    List<Module> fetchByCourseId(Long courseId){
        return moduleService.fetchByCourseId(courseId);
    }

}
