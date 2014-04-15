package com.windreaver.controller;

import com.windreaver.form.Operands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MyController {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(MyController.class);

    @RequestMapping(value = "/index")
    public String listContacts(Model model) {
        LOGGER.entry("listContacts");
        model.addAttribute("operands", new Operands());
        model.addAttribute("isIndex", true);
        return LOGGER.exit("pageview");
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String addContact(@Valid Operands operands, BindingResult result, Model model) {
        LOGGER.entry("Operation " + operands.getOperation());
        if (result.hasErrors()) {
            return LOGGER.exit("pageview");
        } else {
            model.addAttribute("result", operands.getFirstOperand() + operands.getSecondOperand());
            return LOGGER.exit("redirect:/index");
        }
    }

}
