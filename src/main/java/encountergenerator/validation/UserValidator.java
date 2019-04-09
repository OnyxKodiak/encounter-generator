package encountergenerator.validation;

import encountergenerator.models.forms.User;
import encountergenerator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass){
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (user.getName().length() < 3 || user.getName().length() > 32){
            errors.rejectValue("name", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getName()) != null){
            errors.rejectValue("name", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 255){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getVerify())){
            errors.rejectValue("verify", "Diff.UserForm.passwordConfirm");
        }
    }
}
