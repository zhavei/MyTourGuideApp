package com.example.mytourguideapp;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<DataModelGunung> getGunungList() {
        List<DataModelGunung> gunungList = new ArrayList<>();

        DataModelGunung gunungRinjani = new DataModelGunung();
        gunungRinjani.setNamaGunung("gunung rinjani");
        gunungRinjani.setTinggiGungung("175mdpl");
        gunungRinjani.setImageUrl("https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI");
        gunungRinjani.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        DataModelGunung gunungijen = new DataModelGunung();
        gunungijen.setNamaGunung("gunung ijen");
        gunungijen.setTinggiGungung("175mdpl");
        gunungijen.setImageUrl("https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI");
        gunungijen.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        DataModelGunung gunungPapua = new DataModelGunung();
        gunungPapua.setNamaGunung("gunung papua");
        gunungPapua.setTinggiGungung("175mdpl");
        gunungPapua.setImageUrl("https://i.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI");
        gunungPapua.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        gunungList.add(gunungijen);
        gunungList.add(gunungRinjani);
        gunungList.add(gunungPapua);

        return gunungList;
    }
}
