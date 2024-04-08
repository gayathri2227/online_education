//package com.exam.controller;
//
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exam.entity.Exam;
//import com.exam.service.ExamServiceImp;
//
//@RequestMapping("/exam")
//@RestController
//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}, maxAge = 3600L, exposedHeaders = "Access-Control-Allow-Origin")
//public class ExamController {
//	
//	@Autowired
//	private ExamServiceImp examServiceImp;
//	
//	@GetMapping("/getAllExams")
//	public List<Exam>  findAllExams(){
//		
//		return examServiceImp.getAllExams();
//	}
//	
//	@PostMapping("/save")
//	public Exam save(@RequestBody Exam exam)
//	{
//		return examServiceImp.saveDetails(exam);
//	}
//	@PutMapping("/update")
//	public Exam update(@RequestBody Exam exam)
//	{
//		return examServiceImp.update(exam);
//	}
//	@GetMapping("/get/{id}")
//	public Exam searchByExamId(@PathVariable("id") long id)
//	{
//		return examServiceImp.searchByExamID(id);
//	}
//	
//	
//	@GetMapping("question/{examId}")
//	public Set<String> takeExam(@PathVariable("examId") long examId)
//	{
//		return examServiceImp.takeExam(examId);
//	}
//	
//	@PostMapping("/{examId}/sumbit")
//	public int submitAnswer(@PathVariable("examid") long id)
//	{
//		return examServiceImp.submitAnswer(id, id, null);
//	}
//
//
//}
package com.exam.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.TestAnswerSubmit;
import com.exam.entity.Exam;
import com.exam.entity.TestPaper;
import com.exam.service.ExamServiceImp;

@RequestMapping("/exam")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}, maxAge = 3600L, exposedHeaders = "Access-Control-Allow-Origin")
public class ExamController {
    
    @Autowired
    private ExamServiceImp examServiceImp;
    
    @GetMapping("/getAllExams")
    public List<Exam>  findAllExams(){
        
        return examServiceImp.getAllExams();
    }
    
    @PostMapping("/save")
    public Exam save(@RequestBody Exam exam)
    {
        return examServiceImp.saveDetails(exam);
    }
    @PutMapping("/update")
    public Exam update(@RequestBody Exam exam)
    {
        return examServiceImp.update(exam);
    }
    @GetMapping("/get/{id}")
    public Exam searchByExamId(@PathVariable("id") long id)
    {
        return examServiceImp.searchByExamID(id);
    }
    
    
    @GetMapping("/question/{examId}")
    public Set<String> takeExam(@PathVariable("examId") long examId)
    {
        return examServiceImp.takeExam(examId);
    }
    
    @PostMapping("/submit-answer/{studentId}/{examId}")
    public int submitAnswer(@PathVariable("studentId") long studentId,@PathVariable("examId") long examId, @RequestBody List<TestAnswerSubmit> testAnswerSubmit) {
        // Assuming ExamService handles the logic
    	System.out.println(testAnswerSubmit);
        return examServiceImp.submitAnswer(studentId, examId, testAnswerSubmit);
    }
    
    @PostMapping("/getScore")
    public int getScore(@RequestBody TestPaper test)
    {   
    	
    	return examServiceImp.marks(test);
    }
    
    @PostMapping("/submitAnswer")
    public int submitAnswer(
            @RequestParam Long studentId,
            @RequestParam Long examId,
            @RequestBody List<TestPaper> answers
    ) {
        return examServiceImp.submitAnswer(studentId, examId, answers);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

