package encountergenerator.controllers;

import encountergenerator.models.data.InterestsDao;
import encountergenerator.models.forms.Interests;
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
        model.addAttribute("title", "Interests");
        return "/interests/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddCInterest(Model model){
        model.addAttribute(new Interests());
        model.addAttribute("title", "Add Point of Interest");
        return "interests/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddInterest(Model model, @ModelAttribute @Valid Interests interests, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Point of Interest");
            return "interests/add";
        }
        interestsDao.save(interests);
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
        Interests interests = interestsDao.findOne(interestId);
        if(interests!=null){
            model.addAttribute("title", "Edit - " + interests.getName());
            model.addAttribute("interests", interests);
            return "interests/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{interestId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Interests interests,
                                      @RequestParam Integer id, Errors errors) {
        if(interests==null && errors.hasErrors()){
            return "interests/edit";
        }
        Interests updateInterests = interestsDao.findOne(id);
        updateInterests.setName(interests.getName());
        updateInterests.setDescription(interests.getDescription());
        updateInterests.setShared(interests.getShared());
        interestsDao.save(updateInterests);
        return "redirect:";
    }
}
