package tpExamen;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.tpDevops.Produit;
import com.tpDevops.ProduitService;

public class ProduitTest {

    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() {
        Produit produit = new Produit();
        produit.setId(1L);
        produit.setNom("ProduitTest");
        produit.setPrix(100.0);
        produit.setQuantite(10);

        produitService.ajouterProduit(produit);

        Produit produitRetrouve = produitService.lireProduit(1L);
        assertNotNull("Le produit n'a pas été ajouté.", produitRetrouve);
        assertEquals("Le nom du produit ne correspond pas.", "ProduitTest", produitRetrouve.getNom());
    }
}
