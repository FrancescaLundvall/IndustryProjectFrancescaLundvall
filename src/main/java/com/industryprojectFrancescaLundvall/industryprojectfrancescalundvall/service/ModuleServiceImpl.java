package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.ModuleNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Module saveModule(Module module){return moduleRepository.save(module);}

    @Override
    public void deleteModuleById(Long moduleId) { moduleRepository.deleteById(moduleId);    }

    @Override
    public Module updateModule(Long moduleId, Module module) {

        Module updatedModule = moduleRepository.findById(moduleId).get();

        if(Objects.nonNull(module.getModuleName()) && !"".equalsIgnoreCase(module.getModuleName()))
        {updatedModule.setModuleName(module.getModuleName());}

        if (Objects.nonNull(module.getEctCredits()))
        { updatedModule.setEctCredits(module.getEctCredits());}

       // if (Objects.nonNull(module.getStaff()))
        //{ updatedModule.setStaff(module.getStaff());}

        return moduleRepository.save(updatedModule);
    }

    @Override
    public List<Module> fetchModuleList() {
        return moduleRepository.findAll();
    }

    @Override
    public Module fetchModuleByName(String moduleName) {
        return moduleRepository.findModuleByModuleNameIgnoreCase(moduleName);
    }

    @Override
    public Module fetchModuleById(Long moduleId) throws ModuleNotFoundException {
        Optional<Module> module = moduleRepository.findById(moduleId);
        if(!module.isPresent()){
            throw new ModuleNotFoundException("Module not found");
        }
        return module.get();
    }

}

