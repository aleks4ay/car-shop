package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.aser.carshop.model.Client;
import ua.aser.carshop.repository.ClientReposetories;

import java.util.List;
import java.util.Map;

@Controller
public class ClientController {
    @Autowired
    private ClientReposetories clientRepo;

    @GetMapping("/newClient")
    public String newClient(Map<String, Object> model) {
        model.put("client", new Client("", "", ""));
        return "user_new";
    }
    @PostMapping("/newClient")
    public String newClient(@ModelAttribute Client client, Map<String, Object> model) {
        clientRepo.save(client);
        return "redirect:clients";
    }
    @GetMapping("/clients")
    public String getClients(Map<String, Object> model) {
        List<Client> clients = (List<Client>)clientRepo.findAll();
        model.put("clients", clients);
        return "user_list";
    }

    @GetMapping("/client_del")
    public String deleteById (@RequestParam String id, Map<String, Object> model) {
        clientRepo.deleteById(Long.valueOf(id));
        return "redirect:clients";
    }
}
