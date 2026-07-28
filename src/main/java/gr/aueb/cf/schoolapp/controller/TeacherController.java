package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dto.RegionReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.IRegionService;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final ITeacherService teacherService;
    private final IRegionService regionService;
//    private final TeacherInsertValidator teacherInsertValidator;

//    @Autowired
//    public TeacherController(ITeacherService teacherService, IRegionService regionService) {
//        this.teacherService = teacherService;
//        this.regionService = regionService;
//    }

    @GetMapping("/insert")
    public String getTeacherForm(Model model) {
        model.addAttribute("teacherInsertDTO", TeacherInsertDTO.empty());
//        model.addAttribute("regionsReadOnlyDTO", regions());
        return "teacher-insert";
    }

    @PostMapping("/insert")
    public String teacherInsert(@Valid @ModelAttribute("teacherInsertDTO") TeacherInsertDTO teacherInsertDTO,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes) {

//        teacherInsertValidator.validate(teacherInsertDTO, bindingResult);

        if (bindingResult.hasErrors()) {
//            model.addAttribute("regionsReadOnlyDTO", regions());
            return "teacher-insert";
        }

        try {
            // save τον teacher
            // επιστρέψει ένα success page
        } catch () {

        }
    }


    @ModelAttribute("regionsReadOnlyDTO")       // εκτελείται πριν από κάθε request handler
    public List<RegionReadOnlyDTO> regions() {
//        return regionService.findAllRegionsSortedByName();

        return List.of(
                new RegionReadOnlyDTO(1L, "Αθήνα"),
                new RegionReadOnlyDTO(2L, "Βόλος"),
                new RegionReadOnlyDTO(3L, "Θεσσαλονίκη")
        );
    }


}
