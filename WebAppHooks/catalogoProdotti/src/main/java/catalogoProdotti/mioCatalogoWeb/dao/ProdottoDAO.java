package catalogoProdotti.mioCatalogoWeb.dao;

import java.util.List;

import catalogoProdotti.mioCatalogoWeb.model.Prodotto;

public interface ProdottoDAO {

	public void add(Prodotto p);
	public void update(Prodotto p);
	public void delete(int id);
	public Prodotto getById(int id);
	public List<Prodotto> getAll();
	
}
