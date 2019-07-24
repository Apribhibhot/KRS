package com.apri.test.controller;

import com.apri.test.entity.MataKuliah;
import com.apri.test.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/matakuliah")

public class MataKuliahController {

    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping(path = "/create")
        public String viewCreate(Model model) {
        model.addAttribute("dataSets", new MataKuliah());
        return "/matakuliah/create";
    }

    @PostMapping(value = "/create")
        public String save(MataKuliah param) {
        MataKuliah data = mataKuliahService.save(param);
        if (data.getId() == 0) {
            return "redirect:/matakuliah/create?failed";
        } else {
            return "redirect:/matakuliah?usuccess"; //matakuliah/create?
        }
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", mataKuliahService.findById(id));
        return "/matakuliah/update";
    }

    @PutMapping(path = "/update")
    public String update(MataKuliah param) {
        MataKuliah data = mataKuliahService.update(param);
        if (data.getId() == 0) {
            return "redirect:/matakuliah?ufailed";
        } else {
            return "redirect:/matakuliah?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(MataKuliah param) {
        int data = mataKuliahService.delete(param);
        if (data == 0) {
            return "redirect:/matakuliah?dfailed";
        } else {
            return "redirect:/matakuliah?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mataKuliahService.findAll());
        } else {
            MataKuliah mataKuliah = new MataKuliah();
            mataKuliah.setMataKuliah(param);
            model.addAttribute("dataSets", mataKuliahService.findByMataKuliah(mataKuliah));
        }
        return "/matakuliah/list";
    }


}
