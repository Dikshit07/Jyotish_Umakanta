package saktishadana.saktisadana.maincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import saktishadana.saktisadana.Emailsending.emailapi;


@Controller
public class MainController {
    
    @GetMapping("/")
    public String Index(RedirectAttributes redirectAttributes ,Model m) {
        System.out.println(m.containsAttribute("sucess"));
        
        System.out.println("index is fired");
        return "index";
    }
    @GetMapping("/emailsending")
    public String EmailSending(@RequestParam( name="email") String email,
                                @RequestParam(name="message") String message,
                                @RequestParam(name="name") String Name,RedirectAttributes redirectAttributes) {
                               emailapi ei= new emailapi(message, "Message from Portfolio from "+Name, "javadeveloper9610@gmail.com",email );
                               emailapi e2 = new emailapi("hi "+Name+", I have got your message and reply soon", "Message from Jyotish umakanta", email,"javadeveloper9610@gmail.com");
                              redirectAttributes.addFlashAttribute("sucess","sucess");
                               
                                
                                

        return "redirect:/";
    }
    
    
}
