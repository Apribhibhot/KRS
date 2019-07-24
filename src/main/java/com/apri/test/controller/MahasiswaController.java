package com.apri.test.controller;


import com.apri.test.entity.Krs;
import com.apri.test.entity.Mahasiswa;
import com.apri.test.service.KrsService;
import com.apri.test.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private KrsService krsService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Mahasiswa());
        return "/mahasiswa/create";
    }

    @PostMapping(value = "/create")
    public String save(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.save(param);
        if (data.getNim() == 0) {
            return "redirect:/mahasiswa/create?failed";
        } else {
            return "redirect:/mahasiswa/create?success";
        }
    }

    @GetMapping(path = "/update/{nim}")
    public String viewUpdate(Model model, @PathVariable(value = "nim") int nim) {
        model.addAttribute("dataSets", mahasiswaService.findByNim(nim));
        return "/mahasiswa/update";
    }

    @PutMapping(path = "/update")
    public String update(Mahasiswa param) {
        Mahasiswa data = mahasiswaService.update(param);
        if (data.getNim() == 0) {
            return "redirect:/mahasiswa?ufailed";
        } else {
            return "redirect:/mahasiswa?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Mahasiswa param) {
        int data = mahasiswaService.delete(param);
        if (data == 0) {
            return "redirect:/mahasiswa?dfailed";
        } else {
            return "redirect:/mahasiswa?dsuccess";
        }
    }

    @GetMapping(path = "/krs/{nim}")
    public String viewKrs(Model model, @PathVariable(value = "nim") int nim) {
        model.addAttribute("dataSets", krsService.findByNim(nim));
        model.addAttribute("dataMahasiswas", mahasiswaService.findByNim(nim));
        return "/mahasiswa/krslist";
    }

    @GetMapping(path = "/krscreate/{nim}")
    public String viewKrsCreate(Model model, @PathVariable(value = "nim") int nim)
    {
        model.addAttribute("dataSets2", krsService.findByNim2(nim));
        model.addAttribute("dataSets", krsService.findByNim(nim));
        model.addAttribute("dataKrs", krsService.findAllKrs(nim));
        model.addAttribute("dataMahasiswas",mahasiswaService.findByNim(nim));
        model.addAttribute("sumSks",krsService.findByNimSks(nim));

        return "/mahasiswa/krscreate";
    }

    @RequestMapping(value = "/savekrs", method = RequestMethod.GET)
    public String createKrs(Krs param,  @RequestParam(value = "nim") int nim){

        //jika sum(sks) >= maks where nim=?
        List<Krs> totalSks = krsService.findByNimSks(nim);//total sks yang telah diambil
        Krs total = totalSks.get(0);
        Krs maks = krsService.findMaksByNim(nim); //ambil maks sks dari tiap mahasiswa

        if (maks.getMaks() <= total.getSks()){
            System.out.println("maks :"+maks.getMaks());
            System.out.println("total :"+total.getSks());
            return "redirect:/mahasiswa/krscreate/"+nim+"?fail";
        }else {
            System.out.println("maks :"+maks.getMaks());
            System.out.println("total :"+total.getSks());
            krsService.createKrs(param);
            return "redirect:/mahasiswa/krscreate/"+nim;
        }
    }

    @RequestMapping(path = "/deletekrs", method = RequestMethod.GET)
    public String deleteKrs(@RequestParam(value = "id") int id,
                            @RequestParam(value = "nim") String nim,
                            @RequestParam(value = "idkrs") int idkrs){

        System.out.println("id :"+id);
        System.out.println("nim :"+nim);
        System.out.println("id KRS :"+idkrs);

        krsService.deleteById(idkrs);


        return "redirect:/mahasiswa/krscreate/"+nim;
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mahasiswaService.findAll());
        } else {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setMahasiswa(param);
            model.addAttribute("dataSets", mahasiswaService.findByMahasiswa(mahasiswa));
        }
        return "/mahasiswa/list";
    }


    //laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

    @GetMapping(path = "/test/{nim}")
    public String viewTest(Model model, @PathVariable(value = "nim") int nim)
    {
        model.addAttribute("dataSets2", krsService.findByNim2(nim));
        model.addAttribute("dataSets", krsService.findByNim(nim));
        return "/mahasiswa/test";
    }

    @PostMapping(value = "/saveTest")
    public String createTest(Krs param) {

        param.cetak();
        System.out.println(param.getId());
        System.out.println(param.getMatakuliah());

//        krsService.createKrs(param);

        return "/mahasiswa/test/";

    }



}
