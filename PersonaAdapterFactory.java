package com.pmp.javafx101;

import java.util.ArrayList;
import com.pmp.dao.Persona;


public class PersonaAdapterFactory {
    
    public static ArrayList<PersonaAdapter> getFromPersonaArrayList( ArrayList<Persona> Personas) {
        ArrayList<PersonaAdapter> PersonaAdapter = new ArrayList();
        Personas.forEach((Persona) -> PersonaAdapter.add(new PersonaAdapter(Persona)));
        return PersonaAdapter;
    }
}
