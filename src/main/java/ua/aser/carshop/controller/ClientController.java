package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "user_new";
    }
    @PostMapping("/newClient")
    public String newClient(@RequestParam String login,@RequestParam String email,
                              @RequestParam String password, Map<String, Object> model) {
        Client client = new Client(login, password, email);
        clientRepo.save(client);
        return "redirect:clients";
    }
    @GetMapping("/clients")
    public String getClients(Map<String, Object> model) {
        List<Client> clients = (List<Client>)clientRepo.findAll();
        model.put("clients", clients);
        return "user_list";
    }

    @GetMapping("/client")
    public String deleteById (@RequestParam String action, @RequestParam String id, Map<String, Object> model) {
        if (action.equals("delete")) {
            clientRepo.deleteById(Long.parseLong(id));
            return "redirect:clients";
        }
        return "redirect:clients";
    }
}
