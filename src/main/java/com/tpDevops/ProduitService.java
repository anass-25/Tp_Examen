package com.tpDevops;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProduitService {
	
	private Map<Long, Produit> produits = new HashMap<>();
	
	public void ajouterProduit(Produit produit) {
	    if (produits.containsKey(produit.getId()) || produitExisteParNom(produit.getNom())) {
	        throw new IllegalArgumentException("Produit déjà existant.");
	    }
	    validerProduit(produit);
	    produits.put(produit.getId(), produit);
	}

	private boolean produitExisteParNom(String nom) {
	    return produits.values().stream()
	            .anyMatch(produit -> produit.getNom().equalsIgnoreCase(nom));
	}

	private void validerProduit(Produit produit) {
	    if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
	        throw new IllegalArgumentException("Prix ou quantité invalides.");
	    }
	}
	
	public void mettreAJourProduit(Long id, Produit produit) {
	    if (!produits.containsKey(id)) {
	        throw new NoSuchElementException("Produit non trouvé pour l'ID : " + id);
	    }
	    validerProduit(produit);
	    produits.put(id, produit);
	}

	public void supprimerProduit(Long id) {
	    if (!produits.containsKey(id)) {
	        throw new NoSuchElementException("Produit non trouvé pour l'ID : " + id);
	    }
	    produits.remove(id);
	}
	
	public Produit lireProduit(Long id) {
	    if (!produits.containsKey(id)) {
	        throw new NoSuchElementException("Produit non trouvé pour l'ID : " + id);
	    }
	    return produits.get(id);
	}
}
