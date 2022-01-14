package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class APIController {
    public final ArrayList<Inscription> utilisateurs = new ArrayList<>();

    @PostMapping("api/inscription")
    void inscription(@RequestBody Inscription utilisateur) {
        if (!utilisateurs.contains(utilisateur)) {
            utilisateurs.add(utilisateur);
        }
    }

    @GetMapping("api/travels")
    ArrayList<Pays> afficherPays(@RequestParam String userName) {
        for (int i = 0; i < this.utilisateurs.size(); i++) {
            if (this.utilisateurs.get(i).userName().equals(userName)) {
                ArrayList<Pays> temp = new ArrayList<Pays>();
                temp.add(new Pays("Cameroon", 15));
                temp.add(new Pays("Germany", 15));
                return temp;
            }
        }
        return new ArrayList<Pays>();
    }


}
