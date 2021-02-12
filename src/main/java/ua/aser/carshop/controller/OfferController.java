package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.aser.carshop.model.Description;
import ua.aser.carshop.model.Offer;
import ua.aser.carshop.model.Product;
import ua.aser.carshop.repository.DescriptionReposetories;
import ua.aser.carshop.repository.ProductReposetories;

import java.util.Map;

@Controller
public class OfferController {
    @Autowired
    private DescriptionReposetories descriptionRepo;
    @Autowired
    private ProductReposetories productRepo;

    @GetMapping("/newDescr")
    public String newClient(Map<String, Object> model) {
        Product product = new Product();
        Description description = new Description(0, 0d, product);
        model.put("description", description);
        return "offer_new";
    }
    @PostMapping("/newDescr")
    public String newClient(@ModelAttribute Description description, Map<String, Object> model) {
        description.getProduct().setPrice(description.getCorrectPrice());
        Offer offer = new Offer();
        offer.addDescriptions(description);
        description.setOffer(offer);
        descriptionRepo.save(description);
        return "redirect:clients";
    }


    @GetMapping("/bb")
    public String testB(Map<String, Object> model) {
        Offer offer = new Offer();
        Product p1 = productRepo.findById(15L).orElse(null);
        Product p2 = productRepo.findById(22L).orElse(null);
        Description d1 = new Description(1, 234, p1);
        Description d2 = new Description(1, 1234, p2);
        d1.setOffer(offer);
        d2.setOffer(offer);
        descriptionRepo.save(d1);
        descriptionRepo.save(d2);
        return "redirect:clients";
    }

    @GetMapping("/aa")
    public String testA(Map<String, Object> model) {
        Product p1 = productRepo.findById(15L).orElse(null);
        Product p2 = productRepo.findById(22L).orElse(null);
        Description d1 = new Description(0, 0d, p1);
        Description d2 = new Description(0, 0d, p2);
        model.put("description", d1);
        return "redirect:clients";
    }
}
