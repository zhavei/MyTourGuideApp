package com.example.mytourguideapp;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<DataModelGunung> getGunungList() {
        List<DataModelGunung> gunungList = new ArrayList<>();

        DataModelGunung gunungRinjani = new DataModelGunung();
        gunungRinjani.setNamaGunung("gunung rinjani");
        gunungRinjani.setTinggiGungung("175mdpl");
        gunungRinjani.setImageUrl(R.drawable.ic_launcher_background);
        gunungRinjani.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        DataModelGunung gunungijen = new DataModelGunung();
        gunungijen.setNamaGunung("gunung ijen");
        gunungijen.setTinggiGungung("175mdpl");
        gunungijen.setImageUrl(R.drawable.ic_launcher_foreground);
        gunungijen.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        DataModelGunung gunungPapua = new DataModelGunung();
        gunungPapua.setNamaGunung("gunung papua");
        gunungPapua.setTinggiGungung("175mdpl");
        gunungPapua.setImageUrl(R.drawable.ic_launcher_background);
        gunungPapua.setDeskripsiGunung("Pulau Lombok di Nusa Tenggara Barat tidak hanya memiliki keindahan pantai eksotis ");

        gunungList.add(gunungijen);
        gunungList.add(gunungRinjani);
        gunungList.add(gunungPapua);

        return gunungList;
    }
}
