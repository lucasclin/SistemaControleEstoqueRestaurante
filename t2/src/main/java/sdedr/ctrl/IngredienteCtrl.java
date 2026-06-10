package sdedr.ctrl;

import java.util.ArrayList;

import sdedr.dao.IngredienteDao;
import sdedr.model.Ingrediente;
import sdedr.model.Receita;

public class IngredienteCtrl {
    public boolean retornarIngredientesReceita(Receita receita, ArrayList<Ingrediente> ingredientesReceita) {
        IngredienteDao ingredienteDao = new IngredienteDao();
        try {
            return ingredienteDao.retornarIngredientesReceita(receita, ingredientesReceita);
        } catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
            return false;
        }
    }    
}
