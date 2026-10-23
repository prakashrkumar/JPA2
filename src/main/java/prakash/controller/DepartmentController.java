package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prakash.model.Department;
import prakash.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @PostMapping
    public ResponseEntity<String>createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteDepart(@PathVariable Long id){
        departmentService.removeDepartment(id);
        return ResponseEntity.ok("OK");
    }

}
