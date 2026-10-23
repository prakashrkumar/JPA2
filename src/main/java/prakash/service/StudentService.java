package prakash.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prakash.model.Department;
import prakash.model.Profile;
import prakash.model.Student;
import prakash.repository.DepartmentRepository;
import prakash.repository.ProfileRepository;
import prakash.repository.StudentRepository;


@Service

public class StudentService {
    StudentRepository studentRepository;
DepartmentRepository departmentRepository;
ProfileRepository profileRepository;
    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository,ProfileRepository profileRepository){
        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;
        this.profileRepository=profileRepository;
    }
    @Transactional
    public  void createStudent(Student student){
        Department department=new Department();
        department.setName("CSE");

        Profile profile=new Profile();
        profile.setBio("Simple Bio");

        student.setDepartment(department);
        student.setProfile(profile);
        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);


    }
    @Transactional
    public Student fetchStudentById(Long id){
      Student s1 = studentRepository.findById(id);
        System.out.println("Lazy fetched student");
        Department d1= s1.getDepartment();
        System.out.println("lazy fetched Department");

        Profile p1=s1.getProfile();
        System.out.println("lazy fetched Profile");

        return s1;



    }
}
