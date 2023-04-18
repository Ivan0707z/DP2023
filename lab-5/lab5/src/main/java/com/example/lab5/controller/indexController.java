package com.example.lab5.controller;

import com.example.lab5.entity.DeviceEntity;
import com.example.lab5.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/new")
    public String addNew(DeviceEntity device) {
        return "add-device";
    }
    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<DeviceEntity> deviceList = deviceRepository.findAll();
        model.addAttribute("deviceList", deviceList);

        return "index";
    }

    @PostMapping("/add-device")
    public String addGuitar(@Valid DeviceEntity device, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-device";
        }
        List<DeviceEntity> deviceList = deviceRepository.findAll();
        device.id = deviceList.size()+1;
        deviceRepository.save(device);
        model.addAttribute("customers", deviceRepository.findAll());

        List<DeviceEntity> updatedDeviceList = deviceRepository.findAll();
        model.addAttribute("deviceList", updatedDeviceList);
        return "redirect:/";
    }
}
