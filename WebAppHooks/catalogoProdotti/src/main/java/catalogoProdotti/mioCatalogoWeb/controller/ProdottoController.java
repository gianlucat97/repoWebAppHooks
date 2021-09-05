package catalogoProdotti.mioCatalogoWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import catalogoProdotti.mioCatalogoWeb.dao.ProdottoDAO;
import catalogoProdotti.mioCatalogoWeb.model.Prodotto;

@Controller
@RequestMapping("/")
public class ProdottoController {

	@Autowired
	private ProdottoDAO service;
	
	
	//Risponde al url: "http://localhost:8080/catalogoProdotti/prodotti"
	@GetMapping("/prodotti")
	public ModelAndView index(@RequestParam(required = false) String id, ModelMap mm) {
		if(id != null) {
			mm.addAttribute("prodottoDaModificare",service.getById(Integer.parseInt(id)));
		}
		
		List<Prodotto> prodotti = service.getAll();
		
		return new ModelAndView("index", "listaProdotti", prodotti);
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("datiProdotto") Prodotto p) {
		service.add(p);
		return "redirect:/prodotti";
	}
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute("datiProdotto") Prodotto p) {
		service.update(p);
		return "redirect:/prodotti";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String idProdotto) {
		if(idProdotto != null)
			service.delete(Integer.parseInt(idProdotto));
		
		return "redirect:/prodotti";
	}
	
}
