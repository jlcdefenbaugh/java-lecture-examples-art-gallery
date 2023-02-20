package com.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    public static final List<String> artCollection = new ArrayList<>(
//            Arrays.asList(
//                    "Girl with a Pearl Earring",
//                    "Mona Lisa",
//                    "The Birth of Venus"
//            )
    );

    // TODO: Convert this to use a template, collection.html
    // TODO: Pass list, artCollection, to template
    // Corresponds to http://localhost:8080/collection
    @GetMapping("")
    public String displayCollectionPage(Model model) {

        System.out.println("\n*** Collection page content requested");
        Collections.sort(artCollection);
        model.addAttribute("collection", artCollection);
        return "collection/index";
    }

    // TODO: Convert this to use a template, add-art-form.html
    // Corresponds to http://localhost:8080/collection/add
    @GetMapping("/add")
    public String displayAddArtForm() {
        System.out.println("\n*** GET request submitted for form content");
        return "collection/add-art-form";
    }

    // TODO: Create a POST handler for /add
    // Should add name of artwork to collection list
    // Then should redirect to /collection

    @PostMapping("/add")
    public String processAddArtForm(@RequestParam String artwork) {
        artCollection.add(artwork);
        return "redirect:/collection";

    }

}
