package src.metro;

import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    Grafo metro = new Grafo();

    // Linea A
    Estacion vaulx_en_velin_A = new Estacion(
      "Vaulx-en-Velin La Soie",
      'A',
      45.761124560997,
      4.922221370456345
    );
    Estacion laurent_bonnevay_A = new Estacion(
      "Laurent Bonnevay",
      'A',
      45.76501875199019,
      4.908850195593299
    );
    Estacion cusset_A = new Estacion(
      "Cusset",
      'A',
      45.76573806795028,
      4.900279597442746
    );
    Estacion flachet_A = new Estacion(
      "Flachet",
      'A',
      45.76782353715553,
      4.889840837922116
    );
    Estacion gratte_ciel_A = new Estacion(
      "Gratte Ciel",
      'A',
      45.76920514933934,
      4.882478368607292
    );
    Estacion republique_villeurbanne_A = new Estacion(
      "République - Villeurbanne",
      'A',
      45.77079709254615,
      4.8736592711643665
    );
    Estacion charpennes_charles_hernu_A = new Estacion(
      "Charpennes Charles Hernu",
      'A',
      45.770644975669406,
      4.863087628128049
    );
    Estacion massena_A = new Estacion(
      "Masséna",
      'A',
      45.76942732597907,
      4.85303708210038
    );
    Estacion foch_A = new Estacion(
      "Foch",
      'A',
      45.76883360225932,
      4.844126037922232
    );
    Estacion hote_de_ville_A = new Estacion(
      "Hôtel de Ville L. Pradel",
      'A',
      45.767482296615775,
      4.83632072627848
    );
    Estacion cordeliers_A = new Estacion(
      "Cordeliers",
      'A',
      45.763345772122676,
      4.835713910935756
    );
    Estacion bellecour_A = new Estacion(
      "Bellecour",
      'A',
      45.75801630649413,
      4.833588037921758
    );
    Estacion ampere_victor_hugo_A = new Estacion(
      "Ampère - Victor Hugo",
      'A',
      45.753087123024336,
      4.829139268606585
    );
    Estacion perrache_A = new Estacion(
      "Perrache",
      'A',
      45.74874974429806,
      4.825743010935111
    );
    // Linea B
    Estacion garre_dOullins_B = new Estacion(
      "Gare d'Oullins",
      'B',
      45.71697050553781,
      4.814602019140676
    );
    Estacion stade_de_gerland_B = new Estacion(
      "Stade de Gerland - Le Lou",
      'B',
      45.727140576364334,
      4.8310003532619294
    );
    Estacion debourg_B = new Estacion(
      "Debourg",
      'B',
      45.731289626149554,
      4.8344342312780935
    );
    Estacion place_jean_jaures_B = new Estacion(
      "Place Jean Jaurès",
      'B',
      45.73819047297242,
      4.8375534704553536
    );
    Estacion jean_mace_B = new Estacion(
      "Jean Macé",
      'B',
      45.745923796261984,
      4.842322692115496
    );
    Estacion saxe_gambetta_B = new Estacion(
      "Saxe Gambetta",
      'B',
      45.753871722835314,
      4.8469861756322965
    );
    Estacion place_guichard_bourse_du_travail_B = new Estacion(
      "Place Guichard Bourse du Travail",
      'B',
      45.759486149295675,
      4.847622095593051
    );
    Estacion gare_partdieu_vmerle_B = new Estacion(
      "Gare Part-Dieu V.Merle",
      'B',
      45.761719457310384,
      4.857755626986203
    );
    Estacion brotteaux_B = new Estacion(
      "Brotteaux",
      'B',
      45.766972171109224,
      4.859352912785328
    );
    Estacion charpennes_charles_hernu_B = new Estacion(
      "Charpennes Charles Hernu",
      'B',
      45.770644975669406,
      4.863087628128049
    );
    // Linea C
    Estacion cuire_C = new Estacion(
      "Cuire",
      'C',
      45.78604340414825,
      4.833372955114947
    );
    Estacion henon_C = new Estacion(
      "Hénon",
      'C',
      45.77921972773108,
      4.827396993476692
    );
    Estacion croix_rousse_C = new Estacion(
      "Croix-Rousse",
      'C',
      45.774423201007664,
      4.831913833338751
    );
    Estacion croix_paquet_C = new Estacion(
      "Croix Paquet",
      'C',
      45.771152945435986,
      4.8362911985368
    );
    Estacion hote_de_ville_C = new Estacion(
      "Hôtel de Ville L. Pradel",
      'C',
      45.767482296615775,
      4.83632072627848
    );
    // Linea D
    Estacion gare_de_vaise_D = new Estacion(
      "Gare de Vaise",
      'D',
      45.78059809486491,
      4.805047971093982
    );
    Estacion valmy_D = new Estacion(
      "Valmy",
      'D',
      45.77473908803626,
      4.805509311043264
    );
    Estacion gorge_de_loup_D = new Estacion(
      "George de Loup",
      'D',
      45.76619266397072,
      4.805047971072226
    );
    Estacion vieux_lyon_D = new Estacion(
      "Vieux Lyon",
      'D',
      45.760159986169164,
      4.825722438126594
    );
    Estacion fourviere_D = new Estacion(
      "Fourvière",
      'D',
      45.76258789646761,
      4.8215764757643775
    );
    Estacion minime_theatres_romains_D = new Estacion(
      "Minimes Théatres Romains",
      'D',
      45.75858001925061,
      4.821243626278051
    );
    Estacion st_just_D = new Estacion(
      "St Just",
      'D',
      45.758520489969875,
      4.816433943469994
    );
    Estacion bellecour_D = new Estacion(
      "Bellecour",
      'D',
      45.75801630649413,
      4.833588037921758
    );
    Estacion guillotiere_D = new Estacion(
      "Guillotière Gabriel Péri",
      'D',
      45.75552461362028,
      4.842213392212922
    );
    Estacion saxe_gambetta_D = new Estacion(
      "Saxe Gambetta",
      'D',
      45.753871722835314,
      4.8469861756322965
    );
    Estacion garibaldi_D = new Estacion(
      "Garibaldi",
      'D',
      45.75166932520962,
      4.854015111809338
    );
    Estacion sans_souci_D = new Estacion(
      "Sans Souci",
      'D',
      45.748090780347745,
      4.86451864230611
    );
    Estacion monplaisir_lumiere_D = new Estacion(
      "Monplaisir - Lumière",
      'D',
      45.74566502532433,
      4.871267080176486
    );
    Estacion grange_blanche_D = new Estacion(
      "Grange Blanche",
      'D',
      45.74305197992176,
      4.878755807748202
    );
    Estacion laennec_D = new Estacion(
      "Laënnec",
      'D',
      45.73843003964004,
      4.886373471517267
    );
    Estacion mermoz_pinel_D = new Estacion(
      "Mermoz Pinel",
      'D',
      45.73097895157334,
      4.887221049658965
    );
    Estacion parilly_D = new Estacion(
      "Parilly",
      'D',
      45.7196244276459,
      4.887521457049011
    );
    Estacion gare_de_venissieux_D = new Estacion(
      "Gare de Vénissieux",
      'D',
      45.70585429585398,
      4.887714840222332
    );

    metro.agregarEstacion(vaulx_en_velin_A);
    metro.agregarEstacion(laurent_bonnevay_A);
    metro.agregarEstacion(cusset_A);
    metro.agregarEstacion(flachet_A);
    metro.agregarEstacion(gratte_ciel_A);
    metro.agregarEstacion(republique_villeurbanne_A);
    metro.agregarEstacion(charpennes_charles_hernu_A);
    metro.agregarEstacion(massena_A);
    metro.agregarEstacion(foch_A);
    metro.agregarEstacion(hote_de_ville_A);
    metro.agregarEstacion(cordeliers_A);
    metro.agregarEstacion(bellecour_A);
    metro.agregarEstacion(ampere_victor_hugo_A);
    metro.agregarEstacion(perrache_A);
    metro.agregarEstacion(garre_dOullins_B);
    metro.agregarEstacion(stade_de_gerland_B);
    metro.agregarEstacion(debourg_B);
    metro.agregarEstacion(place_jean_jaures_B);
    metro.agregarEstacion(jean_mace_B);
    metro.agregarEstacion(saxe_gambetta_B);
    metro.agregarEstacion(place_guichard_bourse_du_travail_B);
    metro.agregarEstacion(gare_partdieu_vmerle_B);
    metro.agregarEstacion(brotteaux_B);
    metro.agregarEstacion(charpennes_charles_hernu_B);
    metro.agregarEstacion(cuire_C);
    metro.agregarEstacion(henon_C);
    metro.agregarEstacion(croix_rousse_C);
    metro.agregarEstacion(croix_paquet_C);
    metro.agregarEstacion(hote_de_ville_C);
    metro.agregarEstacion(gare_de_vaise_D);
    metro.agregarEstacion(valmy_D);
    metro.agregarEstacion(gorge_de_loup_D);
    metro.agregarEstacion(vieux_lyon_D);
    metro.agregarEstacion(fourviere_D);
    metro.agregarEstacion(minime_theatres_romains_D);
    metro.agregarEstacion(st_just_D);
    metro.agregarEstacion(bellecour_D);
    metro.agregarEstacion(guillotiere_D);
    metro.agregarEstacion(saxe_gambetta_D);
    metro.agregarEstacion(garibaldi_D);
    metro.agregarEstacion(sans_souci_D);
    metro.agregarEstacion(monplaisir_lumiere_D);
    metro.agregarEstacion(grange_blanche_D);
    metro.agregarEstacion(laennec_D);
    metro.agregarEstacion(mermoz_pinel_D);
    metro.agregarEstacion(parilly_D);
    metro.agregarEstacion(gare_de_venissieux_D);

    metro.agregarConexion(vaulx_en_velin_A, laurent_bonnevay_A, 1);

    metro.agregarConexion(laurent_bonnevay_A, vaulx_en_velin_A, 2);
    metro.agregarConexion(laurent_bonnevay_A, cusset_A, 2);

    metro.agregarConexion(cusset_A, laurent_bonnevay_A, 1);
    metro.agregarConexion(cusset_A, flachet_A, 1);

    metro.agregarConexion(flachet_A, cusset_A, 2);
    metro.agregarConexion(flachet_A, gratte_ciel_A, 2);

    metro.agregarConexion(gratte_ciel_A, flachet_A, 2);
    metro.agregarConexion(gratte_ciel_A, republique_villeurbanne_A, 1);

    metro.agregarConexion(republique_villeurbanne_A, gratte_ciel_A, 1);
    metro.agregarConexion(republique_villeurbanne_A, charpennes_charles_hernu_A, 2);

    metro.agregarConexion(charpennes_charles_hernu_A, republique_villeurbanne_A, 2);
    metro.agregarConexion(charpennes_charles_hernu_A, charpennes_charles_hernu_B, 5);
    metro.agregarConexion(charpennes_charles_hernu_A, massena_A, 1);

    metro.agregarConexion(massena_A, charpennes_charles_hernu_A, 1);
    metro.agregarConexion(massena_A, foch_A, 2);

    metro.agregarConexion(foch_A, massena_A, 2);
    metro.agregarConexion(foch_A, hote_de_ville_A, 2);

    metro.agregarConexion(hote_de_ville_A, foch_A, 2);
    metro.agregarConexion(hote_de_ville_A, hote_de_ville_C, 5);
    metro.agregarConexion(hote_de_ville_A, cordeliers_A, 1);

    metro.agregarConexion(cordeliers_A, hote_de_ville_A, 2);
    metro.agregarConexion(cordeliers_A, bellecour_A, 1);
    
    metro.agregarConexion(bellecour_A, cordeliers_A, 1);
    metro.agregarConexion(bellecour_A, bellecour_D, 5);
    metro.agregarConexion(bellecour_A, ampere_victor_hugo_A, 2);

    metro.agregarConexion(ampere_victor_hugo_A, bellecour_A, 1);
    metro.agregarConexion(ampere_victor_hugo_A, perrache_A, 1);
    
    metro.agregarConexion(perrache_A, ampere_victor_hugo_A, 1);

    metro.agregarConexion(garre_dOullins_B, stade_de_gerland_B, 2);

    metro.agregarConexion(stade_de_gerland_B, garre_dOullins_B, 3);
    metro.agregarConexion(stade_de_gerland_B, debourg_B, 2);

    metro.agregarConexion(debourg_B, stade_de_gerland_B, 3);
    metro.agregarConexion(debourg_B, place_jean_jaures_B, 2);
    
    metro.agregarConexion(place_jean_jaures_B, debourg_B, 1);
    metro.agregarConexion(place_jean_jaures_B, jean_mace_B, 2);
    
    metro.agregarConexion(jean_mace_B, place_jean_jaures_B, 2);
    metro.agregarConexion(jean_mace_B, saxe_gambetta_B, 2);

    metro.agregarConexion(saxe_gambetta_B, jean_mace_B, 2);
    metro.agregarConexion(saxe_gambetta_B, saxe_gambetta_D, 3);
    metro.agregarConexion(saxe_gambetta_B, place_guichard_bourse_du_travail_B, 2);

    metro.agregarConexion(place_guichard_bourse_du_travail_B, saxe_gambetta_B, 2);
    metro.agregarConexion(place_guichard_bourse_du_travail_B, gare_partdieu_vmerle_B, 2);

    metro.agregarConexion(gare_partdieu_vmerle_B, place_guichard_bourse_du_travail_B, 2);
    metro.agregarConexion(gare_partdieu_vmerle_B, brotteaux_B, 1);
    
    metro.agregarConexion(brotteaux_B, gare_partdieu_vmerle_B, 2);
    metro.agregarConexion(brotteaux_B, charpennes_charles_hernu_B, 2);

    metro.agregarConexion(cuire_C, henon_C, 2);

    metro.agregarConexion(henon_C, cuire_C, 2);
    metro.agregarConexion(henon_C, croix_rousse_C, 3);
    
    metro.agregarConexion(croix_rousse_C, henon_C, 2);
    metro.agregarConexion(croix_rousse_C, croix_paquet_C, 2);
    
    metro.agregarConexion(croix_paquet_C, croix_rousse_C, 2);
    metro.agregarConexion(croix_paquet_C, hote_de_ville_C, 2);
    
    metro.agregarConexion(hote_de_ville_C, croix_paquet_C, 2);
    metro.agregarConexion(hote_de_ville_C, hote_de_ville_A, 8);

    metro.agregarConexion(gare_de_vaise_D, valmy_D, 1);
    
    metro.agregarConexion(valmy_D, gare_de_vaise_D, 1);
    metro.agregarConexion(valmy_D, gorge_de_loup_D, 2);
    
    metro.agregarConexion(gorge_de_loup_D, valmy_D, 1);
    metro.agregarConexion(gorge_de_loup_D, vieux_lyon_D, 3);
    
    metro.agregarConexion(vieux_lyon_D, gorge_de_loup_D, 3);
    metro.agregarConexion(vieux_lyon_D, fourviere_D, 3);
    metro.agregarConexion(fourviere_D, vieux_lyon_D, 3);
    metro.agregarConexion(vieux_lyon_D, minime_theatres_romains_D, 2);
    metro.agregarConexion(minime_theatres_romains_D, vieux_lyon_D, 2);
    metro.agregarConexion(minime_theatres_romains_D, st_just_D, 2);
    metro.agregarConexion(vieux_lyon_D, bellecour_D, 2);
    
    metro.agregarConexion(bellecour_D, vieux_lyon_D, 1);
    metro.agregarConexion(bellecour_D, bellecour_A, 3);
    metro.agregarConexion(bellecour_D, guillotiere_D, 2);

    metro.agregarConexion(guillotiere_D, bellecour_D, 1);
    metro.agregarConexion(guillotiere_D, saxe_gambetta_D, 1);
    
    metro.agregarConexion(saxe_gambetta_D, guillotiere_D, 1);
    metro.agregarConexion(saxe_gambetta_D, saxe_gambetta_B, 3);
    metro.agregarConexion(saxe_gambetta_D, garibaldi_D, 1);

    metro.agregarConexion(garibaldi_D, saxe_gambetta_D, 1);    
    metro.agregarConexion(garibaldi_D, sans_souci_D, 2);    
    
    metro.agregarConexion(sans_souci_D, garibaldi_D, 1);
    metro.agregarConexion(sans_souci_D, monplaisir_lumiere_D, 1);
    
    metro.agregarConexion(monplaisir_lumiere_D, sans_souci_D, 1);
    metro.agregarConexion(monplaisir_lumiere_D, grange_blanche_D, 1); 
    
    metro.agregarConexion(grange_blanche_D, monplaisir_lumiere_D, 1);
    metro.agregarConexion(grange_blanche_D, laennec_D, 2);
    
    metro.agregarConexion(laennec_D, grange_blanche_D, 1);
    metro.agregarConexion(laennec_D, mermoz_pinel_D, 1);
    
    metro.agregarConexion(mermoz_pinel_D, laennec_D, 1);
    metro.agregarConexion(mermoz_pinel_D, parilly_D, 2);
    
    metro.agregarConexion(parilly_D, mermoz_pinel_D, 2);
    metro.agregarConexion(parilly_D, gare_de_venissieux_D, 2);

    metro.agregarConexion(gare_de_venissieux_D, parilly_D, 3);

    metro.mostrarEstacionesYConexionesPorLinea();

    // AQUÍ ES DONDE SE COMPRUEBAN LOS RESULTADOS
    List<Estacion> resultado = metro.aStar(parilly_D, foch_A);
    
    printRuta(resultado);

    SwingUtilities.invokeLater(() -> {
        new MetroGUI(metro).setVisible(true);
    });
}
    private static void printRuta(List<Estacion> res) {
        System.out.println("---------------RUTA BEGIN----------------");
        for(Estacion estacion : res) {
            String infoEstacion = String.format("Estación: %s - Línea: %s", estacion.getNombre(), estacion.getLinea());
            System.out.println(infoEstacion);
        }
        System.out.println("------------------END--------------------");
    }

}
