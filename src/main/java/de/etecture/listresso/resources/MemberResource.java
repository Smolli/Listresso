package de.etecture.listresso.resources;

import de.etecture.listresso.resources.dto.MemberDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberResource {

    @RequestMapping("/")
    public List<MemberDTO> listMember(){
        return null;
    }
}
