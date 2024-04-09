package com.example.demo.Controllers;

import com.example.demo.Models.Role;
import com.example.demo.Models.Subdivision;
import com.example.demo.Models.User;
import com.example.demo.Repository.SubdivisionRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubdivisionRepository subdivisionRepository;

    @GetMapping("/")
    public String userView(Model model) {
        model.addAttribute("user_list", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String detailView(@PathVariable Long id, Model model) {
        Iterable<Subdivision> subdivisions = subdivisionRepository.findAll();
        model.addAttribute("subdivisions", subdivisions);
        model.addAttribute("user_object", userRepository.findById(id).orElseThrow());
        return "user/info";
    }

    @GetMapping("/{id}/update")
    public String updView(@PathVariable Long id, Model model) {
        Iterable<Subdivision> subdivisions = subdivisionRepository.findAll();
        model.addAttribute("user_object", userRepository.findById(id).orElseThrow());
        model.addAttribute("roles", Role.values());
        model.addAttribute("subdivisions", subdivisions);
        return "user/update";
    }

    @PostMapping("/{id}/update")
    public String update_user(@RequestParam String username,
                              @RequestParam String surname,
                              @RequestParam String name,
                              @RequestParam String middleName,
                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirthday,
                              @RequestParam String telephone,
                              @RequestParam(name = "roles[]", required = false) String[] roles,
                              @PathVariable Long id,
                              Model model) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);
        user.setSurname(surname);
        user.setName(name);
        user.setMiddleName(middleName);
        user.setDateOfBirthday(dateOfBirthday);
        user.setTelephone(telephone);

        user.getRoles().clear();
        if (roles != null) {
            for (String role:
                    roles) {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        Iterable<Subdivision> subdivisions = subdivisionRepository.findAll();
        model.addAttribute("subdivisions", subdivisions);
        user.setUID(id);
        userRepository.save(user);
        return "redirect:/admin/";
    }
}