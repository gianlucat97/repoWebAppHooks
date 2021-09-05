package catalogoProdotti.mioCatalogoWeb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import catalogoProdotti.mioCatalogoWeb.model.Prodotto;

public class ProdottoDAOimpl implements ProdottoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Prodotto p) {
		em.persist(p);
	}

	@Override
	@Transactional
	public void update(Prodotto p) {
		em.merge(p);
	}

	@Override
	@Transactional
	public void delete(int id) {
		em.remove(getById(id));
	}

	@Override
	public Prodotto getById(int id) {
		return em.find(Prodotto.class, id);
	}

	@Override
	public List<Prodotto> getAll() {
		Query q = em.createQuery("SELECT p FROM Prodotto p");
		return q.getResultList();
	}


	

}
