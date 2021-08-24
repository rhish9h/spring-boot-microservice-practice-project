package in.rhish.department.service.service;

import in.rhish.department.service.entity.Department;
import in.rhish.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Saving department: " + department);
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        log.info("Fetching all departments");
        return (List<Department>) departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) throws Exception {
        log.info("Fetching department for id : " + departmentId);
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new Exception("Department with id : " + departmentId + " not found."));
    }
}
