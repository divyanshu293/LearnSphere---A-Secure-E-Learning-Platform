package com.hashedin.huspark.service;


import com.hashedin.huspark.Exception.NotFoundException;
import com.hashedin.huspark.model.SubModule;
import com.hashedin.huspark.model.Module;
import com.hashedin.huspark.repository.ModuleRepository;
import com.hashedin.huspark.repository.SubModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class SubModuleService {
    @Autowired
    private SubModuleRepository subModuleRepository;


    @Autowired
    private ModuleRepository moduleRepository;


    public SubModule addSubModule(SubModule subModule) {
        return subModuleRepository.save(subModule);
    }


    public SubModule editSubModule(int subModuleId, SubModule updatedSubModule) {
        SubModule subModule = subModuleRepository.findById(subModuleId)
                .orElseThrow(()-> new NotFoundException("Sub module not found"));
        subModule.setTitle(updatedSubModule.getTitle());
        return subModuleRepository.save(subModule);
    }


    public boolean deleteSubModule(int subModuleId) {
        if (subModuleRepository.existsById(subModuleId)) {
            subModuleRepository.deleteById(subModuleId);
            return true;
        }
        return false;
    }


    public List<SubModule> getSubModules() {
        return subModuleRepository.findAll();
    }


    public SubModule getSubModule(int subModuleId) {
        return subModuleRepository.findById(subModuleId).orElse(null);
    }


    public SubModule assignSubModuleToModule(int subModuleId, int moduleId) {
        SubModule subModule = subModuleRepository.findById(subModuleId)
                .orElseThrow(()-> new NotFoundException("Not Found SubModule"));
        Module module = moduleRepository.findById(moduleId).orElseThrow(()-> new NotFoundException("Module not found"));
        subModule.setModule(module);
        return subModuleRepository.save(subModule);
    }
}
