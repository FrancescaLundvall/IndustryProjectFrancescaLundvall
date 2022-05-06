package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.ModuleNotFoundException;

import java.util.List;

public interface ModuleService {
    Module saveModule(Module module);

    public void deleteModuleById(Long moduleId);

    public Module updateModule(Long moduleId, Module module);

    public List<Module> fetchModuleList();

    public Module fetchModuleByName (String moduleName);

    public Module fetchModuleById(Long moduleId) throws ModuleNotFoundException;

}
