package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prakash.model.Department;
import prakash.model.Student;
import prakash.repository.DepartmentRepository;
import prakash.repository.StudentRepository;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,StudentRepository studentRepository){
        this.departmentRepository=departmentRepository;
        this.studentRepository=studentRepository;

    }
    @Transactional
    public void createDepartment(Department department){
        Student s1=new Student();
        s1.setName("prakash kumar");
        s1.setDepartment(department);

        Student s2=new Student();
        s2.setName("Ramesh kumar");
        s2.setDepartment(department);

        Student s3=new Student();
        s3.setName("Priyanka kumari");
        s3.setDepartment(department);

        Student s4=new Student();
        s4.setName("Pooja Bhushan");
        s4.setDepartment(department);

   department.getStudents().addAll(List.of(s1,s2,s3,s4));
   // not use for use cascad
//   departmentRepository.save(department);
//      studentRepository.save(s1);
//        studentRepository.save(s2);
//        studentRepository.save(s3);
//        studentRepository.save(s4);


        departmentRepository.save(department);
    }
    @Transactional
    public void removeDepartment(Long deptId){
        Department department=departmentRepository.findById(deptId);
        if (department == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department not found with id: " + deptId
            );
        }
        departmentRepository.removeDepartment(department);

    }
}
