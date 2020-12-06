package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.NewElement;
import net.javaguides.springboot.repository.NewElementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/collectionItems")
public class NewElementController {

    private final NewElementRepository newElementRepository;

    public NewElementController(NewElementRepository newElementRepository) {
        this.newElementRepository = newElementRepository;
    }

    @GetMapping
    public List<NewElement> getNewElements() {
        return this.newElementRepository.findAll();
    }

    @GetMapping("/{id}")
    public NewElement get(@PathVariable Long id) throws Exception {
        //Thread.sleep(5000);
        Optional<NewElement> newElement = this.newElementRepository.findById(id);
        return newElement.orElseThrow(  Exception::new);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.newElementRepository.deleteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public NewElement createOrUpdate(@RequestBody NewElement newElement) {
        return  this.newElementRepository.save(newElement);
       // return null;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public NewElement update(@RequestBody NewElement newElement, @PathVariable int id) {
        return this.newElementRepository.save(newElement);
    }
}