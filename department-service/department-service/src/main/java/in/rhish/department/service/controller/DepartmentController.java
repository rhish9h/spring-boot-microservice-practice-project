package in.rhish.department.service.controller;

import in.rhish.department.service.entity.Department;
import in.rhish.department.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws Exception {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
