package guevara.employeedirectory.controller;


import guevara.employeedirectory.models.Department;
import guevara.employeedirectory.models.Person;
import guevara.employeedirectory.repositories.DepartmentRepo;
import guevara.employeedirectory.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    PersonRepo personRepo;



    @GetMapping("/")
        public String loadDepart(Model model){
            model.addAttribute("department", new Department());


            Iterable<Department> depalist;
            ArrayList<Department> toadd = new ArrayList<>();

            Department newDepa1 = new Department();
            newDepa1.set("Operations");

            Department newDepa2 = new Department();
            newDepa2.set("Accounting");


            Department newDepa3 = new Department();
            newDepa3.set("Human Resources");

            toadd.add(newDepa1);
            toadd.add(newDepa2);
            toadd.add(newDepa3);


            depalist = toadd;

            departmentRepo.save(depalist);

            return "menu";
            }


    @RequestMapping("/adddeparment")
    public String listDepart(Model model)
    {
        Iterable<Department> depalist = departmentRepo.findAll();
        model.addAttribute("depalist", depalist);

        return "adddeparment";
    }

    @RequestMapping("/addpersons/{id}")
    public String loadPerson(@PathVariable("id") long id, Model model) {
        model.addAttribute("department", departmentRepo.findOne(id));
        Person person=new Person();
        person.setDepartment(departmentRepo.findOne(id));
        person.setPosition("General Labor");
        model.addAttribute("person", person);
        return "addperson";

    }


    @PostMapping("/addperson")
        public String addPerson(@Valid @ModelAttribute("person") Person person,@ModelAttribute("department") Department department, BindingResult Result) {


        System.out.println(Result.toString());
        if (Result.hasErrors()) {
            return "addperson";
        }

        System.out.println("no errors");

        // Save the person to the database
        personRepo.save(person);

        return "redirect:/adddeparment";

    }

    @RequestMapping("/addhead")
public String loadnewDep(Model model){
            model.addAttribute("department", new Department());

            return "addhead";


    }


    @PostMapping("/addhead")
    public String processContact(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) {

        System.out.println(bindingResult.toString());

        if (bindingResult.hasErrors()) {
            return "addhead";
        }


        departmentRepo.save(department);
        return "redirect:/adddeparment";


    }

    @RequestMapping("/listdep")

    public String displayall(Model model)
    {
        model.addAttribute("alldep", departmentRepo.findAll());
        return "listdep";


    }

    @GetMapping("/detailperson/{id}")
    public String showPerson(@PathVariable("id") long id, Model model)
    {

        model.addAttribute("deplist", departmentRepo.findDepartmentById(id));

        return "detailperson";
    }

//    @RequestMapping("/placehead")
//
//    public String displayallemp(Model model)
//    {
//        model.addAttribute("allemp", personRepo.findAll());
//        return "listdep";
//
//
//    }


    @RequestMapping("/placehead/{id}")
    public String updateDep(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("department", departmentRepo.findOne(id));
        return "placehead";

    }

    @PostMapping("/placehead")
    public String processCdep(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult)
    {

        System.out.println(bindingResult.toString());

        if (bindingResult.hasErrors()) {
            return "placehead";
        }


        departmentRepo.save(department);
        return "redirect:/listdep";

    }


//








//
//    @GetMapping("/adddepart")
//    public String addDepart(@Valid @ModelAttribute("department") Department department, BindingResult Result)
//    {
//
//
//        if (Result.hasErrors()) {
//            return "adddeparment";
//        }
//
//        departmentRepo.save(department);
//
//        return "departresult";
//    }
//
//
//    @PostMapping("/assignhead")
//    public String postHead(@Valid @ModelAttribute("person") Person person,
//                           @ModelAttribute("department") Department department, BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors()){
//            return"addhead";
//        }
//
//        personRepo.save(person);
//        department.setDeparthead(person.getFirstname());
//        departmentRepo.save(department);
//        System.out.println(person.getFirstname());
//        System.out.println(person.getDepartment().getId());
//        return "headresult";
//    }
//
//


}
