package encountergenerator.controllers;

import encountergenerator.models.data.InterestsDao;
import encountergenerator.models.forms.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "interests")
public class InterestController {

    @Autowired
    private InterestsDao interestsDao;

    @RequestMapping(value = "")
    public String interests(Model model){
        model.addAttribute("interests", interestsDao.findAll());
        model.addAttribute("title", "Interest");
        return "/interests/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddCInterest(Model model){
        model.addAttribute(new Interest());
        model.addAttribute("title", "Add Point of Interest");
        return "interests/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddInterest(Model model, @ModelAttribute @Valid Interest interest, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Point of Interest");
            return "interest/add";
        }
        interestsDao.save(interest);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveInterest(Model model) {
        model.addAttribute("interests", interestsDao.findAll());
        model.addAttribute("title", "Remove Point of Interest");
        return "interests/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInterest(@RequestParam Integer[] interestIds) {

        for (Integer interestId : interestIds) {
            interestsDao.delete(interestId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{interestId}", method = RequestMethod.GET)
    public String displayEditInterest(Model model, @PathVariable Integer interestId) {
        Interest interest = interestsDao.findOne(interestId);
        if(interest !=null){
            model.addAttribute("title", "Edit - " + interest.getName());
            model.addAttribute("interest", interest);
            return "interest/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{interestId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Interest interest,
                                      @RequestParam Integer id, Errors errors) {
        if(interest ==null && errors.hasErrors()){
            return "interest/edit";
        }
        Interest updateInterest = interestsDao.findOne(id);
        updateInterest.setName(interest.getName());
        updateInterest.setDescription(interest.getDescription());
        updateInterest.setShared(interest.getShared());
        interestsDao.save(updateInterest);
        return "redirect:";
    }
}
