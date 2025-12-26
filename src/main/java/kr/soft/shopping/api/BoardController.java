package kr.soft.shopping.api;

import kr.soft.shopping.dto.board.BoardListDTO;
import kr.soft.shopping.dto.board.BoardRegisterDTO;
import kr.soft.shopping.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/board")
public class BoardController {



    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<BoardListDTO> list() {
        return boardService.list();
    }

    @PostMapping("/register")
    public void register(@RequestBody BoardRegisterDTO boardRegisterDTO){
        System.out.println("data:"+boardRegisterDTO.toString());
        boardService.register(boardRegisterDTO);
    }

}
