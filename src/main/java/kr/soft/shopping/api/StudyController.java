package kr.soft.shopping.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.soft.shopping.dto.CalcDTO;
import kr.soft.shopping.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StudyController {

    @GetMapping("/test1")
    public String test1(){
        log.info("test1");
        return "hello world";
    }

    //데이터를 건네는 것 부터 해보자 (input 먼저)
    @GetMapping("/data1")
    public void data1(HttpServletRequest request){
        String data = request.getParameter("text");
        log.info("data:{}",data);
    }

    @GetMapping("/data2")
    public void data2(DataDTO dto){
        log.info("data2:{}",dto.toString());
    }

    @GetMapping("/data3")
    public void data3(CalcDTO calcDTO){
        log.info("plus: {}",calcDTO.getNum1()+calcDTO.getNum2());
        log.info("minus: {}",calcDTO.getNum1()-calcDTO.getNum2());
    }

    @PostMapping("/post1")
    public void post1(@RequestBody DataDTO dto){
        log.info("post1:{}",dto.toString());
    }

    @GetMapping("/res1")
    public DataDTO res1(HttpServletResponse response,DataDTO dto){
        response.setHeader("Access-Control-Allow-Origin","*");
        log.info("res1:{}",dto.toString());
        return dto;
    }

}
