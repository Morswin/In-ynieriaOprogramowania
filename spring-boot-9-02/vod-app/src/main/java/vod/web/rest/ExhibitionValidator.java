package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Exhibition;
import vod.service.ExhibitionService;

@Component
@RequiredArgsConstructor
public class ExhibitionValidator implements Validator {
    private final ExhibitionService exhibitionService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Exhibition.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Exhibition validatedExhibition = (Exhibition) target;

        boolean duplicated = exhibitionService.getAllExhibitions().stream()
                .anyMatch(exhibition->exhibition.getName().equalsIgnoreCase(validatedExhibition.getName()));
        if (duplicated) {
            errors.rejectValue("name", "exhibition.name.duplicated");
        }
    }
}
