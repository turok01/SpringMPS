package com.Igor.SpringMPS.controller;

import javax.validation.Valid;
import com.Igor.SpringMPS.ListTransformerSubst;
import com.Igor.SpringMPS.TempTransformerSubst;
import com.Igor.SpringMPS.data.TransformerRepository;
import com.Igor.SpringMPS.entities.TransformerSubst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/select")
//@SessionAttributes(types = TransformerSubst.class)
@SessionAttributes(value = "currentSubst")
@ConfigurationProperties(prefix="mps.substations")
public class SelectController {

    private int pageSize = 10;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @ModelAttribute("currentSubst")
    public TransformerSubst createSubst(){
        return new TransformerSubst();
    }

    private TransformerRepository transformerRepo;
    @Autowired
    public SelectController (TransformerRepository transformerRepo){
        this.transformerRepo = transformerRepo;
    }

    @GetMapping
    public String showSelectForm(@ModelAttribute("currentSubst") TransformerSubst tp, Model model){
        List<TransformerSubst> substs = new ArrayList<>();
        Pageable pageable =  PageRequest.of(0,pageSize);
        //transformerRepo.findAll().forEach(i->substs.add(i));


        Page<TransformerSubst> page = null;
        page = transformerRepo.findAll(pageable);
        substs = page.getContent();

        Integer i = 0;
        model.addAttribute("listsubst",substs);

        model.addAttribute("intSubst", i);

        //model.addAttribute("select",new BaseTransformerSubst());
        return "select";
    }
    @PostMapping(params = "edit")
    //public String processSelect( @ModelAttribute("currentSubst")  TransformerSubst tp,TempTransformerSubst tempTp){
    //public String processSelect( @ModelAttribute TransformerSubst tempTp){
    public String processSelect(TransformerSubst tempTp, Errors errors, Model model){
        if(tempTp.getId()==null)
            return "redirect:/select";
        log.info("Processing select: " + tempTp.toString());
        model.addAttribute("currentSubst",tempTp);
        model.addAttribute("id", tempTp.getId());

        return "redirect:/edit/current";
/*-
        public String getQuestion(ModelMap model, HttpServletRequest request) {
            String[] questions ={ "a","b", "c"};
            request.getSession().setAttribute("questions", questions);
            return "index";
        }
 */
    }
    @PostMapping(params="delete")
    public String deleteForm(TransformerSubst transformerSubst){
        if(transformerSubst.getId()==null)
            return "redirect:/select";
        transformerRepo.deleteById(transformerSubst.getId());
        return "successful";
    }
}
