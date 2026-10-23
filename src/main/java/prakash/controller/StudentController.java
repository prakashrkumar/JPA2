package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prakash.model.Student;
import prakash.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
   private final StudentService studentService;

   public StudentController(StudentService studentService){
       this.studentService=studentService;
   }

   @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student){
       studentService.createStudent(student);
       return ResponseEntity.ok("DONE");
   }
   @GetMapping("/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){
       Student student=studentService.fetchStudentById(id);
       return ResponseEntity.ok(student);

   }

}
