package sof3as3a.harjoitustyo.treenipaivakirja.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.Treeni;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TreeniRepository;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.Tyyppi;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TyyppiRepository;

@Controller
public class TreenilistaController {

	@Autowired
	private TreeniRepository trepository;
	@Autowired
	private TyyppiRepository tyrepository;
	
	//Listing page for workouts
	@GetMapping("/treenipaivakirja")
	public String treeniLista(Model model) {
		model.addAttribute("treenit", trepository.findAll());
		model.addAttribute("tyypit", tyrepository.findAll());
		return "treenilista"; //.html
	}
	
	//Method to add workouts
	@GetMapping("/addtreeni")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addTreeni(Model model) {
		model.addAttribute("treeni", new Treeni());
		model.addAttribute("tyypit", tyrepository.findAll());
		return "addtreeni"; //.html
	}

	//Saving a workout
	@PostMapping("/savetreeni")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveTreeni(Treeni treeni) {
		trepository.save(treeni);
		return "redirect:treenipaivakirja";
	}
	
	//Saving a type
	@PostMapping("/savetyyppi")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveTreeni(Tyyppi tyyppi) {
		tyrepository.save(tyyppi);
		return "redirect:addtreeni";
	}
	
	//Editing a workout
	@GetMapping("edittreeni/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editTreeni(@PathVariable("id") Long id, Model model) {
		model.addAttribute("treeni", trepository.findById(id));
		model.addAttribute("tyypit", tyrepository.findAll());	
		return "/edittreeni"; //.html
	}

	//Deleting a workout
	@GetMapping("deletetreeni/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTreeni(@PathVariable("id") Long id, Model model) {
		trepository.deleteById(id);
		return "redirect:../treenipaivakirja";
	}
	
	//Checking the notes of a workout
	@GetMapping("tarkastelu/{id}")
	public String tarkasteleTreenia(@PathVariable("id") Long id, Model model) {
		trepository.findById(id).ifPresent(o -> model.addAttribute("treeni", o));
		return "treenitarkastelu";
	}
	
	//Adding a type
	@GetMapping("/addtyyppi")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addTyyppi(Model model, @Valid Tyyppi tyyppi) {
		model.addAttribute("tyyppi", new Tyyppi());
		model.addAttribute("tyypit", tyrepository.findAll());
		return "addtyyppi"; //.html
	}
	
	//REST
	
	//REST service that gets all books
	@GetMapping("/treenit")
	public @ResponseBody List<Treeni> treeniListRest(){
		return (List<Treeni>) trepository.findAll();
	}

	//REST service that returns one book by id
	@GetMapping("/treenit/{id}")
	public @ResponseBody Optional<Treeni> findTreeniRest(@PathVariable("id") Long id){
		return trepository.findById(id);
	}
	
}
