package com.ibrahimcakir.kokteyltarifleri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ibrahimcakir.kokteyltarifleri.Adapter.CustomViewPager;
import com.ibrahimcakir.kokteyltarifleri.Fragments.HistoryFragment;
import com.ibrahimcakir.kokteyltarifleri.Fragments.HomeFragment;
import com.ibrahimcakir.kokteyltarifleri.Fragments.NoteFragment;
import com.ibrahimcakir.kokteyltarifleri.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList AdapterArrayList;
    private ActivityMainBinding binding;
    private String myString = "hello";





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //example();

        AdapterArrayList = new ArrayList<>();



        Cocktail margarita = new Cocktail("margarita", "1.Kokteyl bardaklarının ağız kısmına limon sürüp tuza bulayın.\n" +
                " 2.Shaker'da tekila, portakal likörü, limon suyu ve buz parçalarını iyice çalkalayın.\n" +
                "3.buz küpleri ile dolu bir shakera 50ml tekila ve 20ml cointreau veya triple sec dökün.\n" +
                "4.15 ml limon suyu ekleyin.\n" +
                "5.iyice çalkalayın ve bir margarita bardağına süzün",
                "margarita bir klasiktir ve Amerika Birleşik Devletleri'ndeki en popüler tekila bazlı kokteyldir.", R.drawable.margarita,"history moruk");

        Cocktail irishCoffee = new Cocktail("irish coffee", "1.Öncelikle kadehi sıcak suyla doldurup önden ısıtıyoruz.\n" +
                "2.kadehe 300ml filtre kahve koyun.\n" +
                "3.50ml viski ekleyin ve bir çay kaşığı şeker veya 5ml şeker şurubu ekleyin. şeker eriyene kadar karıştırın.\n" +
                "4.kremayı dikkatlice üstüne dökün", "Bu kokteylin efsanelerinden birine göre, orijinal tarifi Joseph Sheridan tarafından 1940 yılında" +
                " bir İrlanda havalimanına gelen bir grup yolcunun kahveye viski ekleyerek onları ısıtmaya çalışmasıyla oluşturuldu. şimdi bir IBA resmi kokteyli", R.drawable.irishcoffee,"nedir yani");
/*
        Cocktail ginTonic = new Cocktail("gin tonic", "1.bir highball bardağını buzla doldurun. \n" +
                "2.buzun üzerine 50ml cin ve 100ml tonik dökün \n" +
                "3.hafifçe karıştırın ve bir limon dilimi ile süsleyin", "basit ve her zaman iyi cin tonik oranı zevkinize göre değişebilir", R.drawable.gintonic);

        Cocktail mojito = new Cocktail("mojito", "1.bir highball bardağına birkaç dal nane ve 2 çay kaşığı şeker koyun. \n" +
                "2.20 ml limon suyu ekleyin ve nane dallarını karıştırın.\n" +
                "3.bardağı kırılmış buzla doldurun.\n" +
                "4.45 ml beyaz rom dökün ve üzerine soda ekleyin.\n" +
                "5.bir tutam nane yaprağı ve limon dilimi ile süsleyin.", "en popüler rom bazlı kokteyllerden biri bu, 16. yüzyılda küba'da icat edilmiş bir IBA resmi kokteylidir.", R.drawable.mojito);

        Cocktail kamikaze = new Cocktail("kamikaze", "1.bir shakeri buz küpleriyle doldurun\n" +
                "2.30ml votka 30ml triple sec ve 30ml limon suyu ekleyin\n" +
                "3.iyice çalkalayın ve bir kokteyl bardağına süzün\n" +
                "4.garnitür olarak limon dilimi ile seervis ediniz.", "Bu popüler IBA resmi kokteyli, orijinal kamikaze shooter oyununun bir varyasyonudur.", R.drawable.kamikaze);

        Cocktail gimlet = new Cocktail("gimlet", "1.bir karıştırma bardağını buz küpleriyle doldurun.\n" +
                "2.60ml cin ve 15ml limon suyu ekleyin.\n" +
                "3.isteğe bağlı olarak 15ml şeker şurubu ekleyin.\n" +
                "4.karıştırın ve soğutulmuş bir kokteyl bardağına süzün.\n" +
                "5.Bitmiş kokteyli misket limonu kabuğu ile süsleyin.", "20. yüzyılın başından beri uzun bir geçmişi olan klasik bir cin bazlı kokteyl. Bu tarif, içecekleri karıştırmanın güzel sanatlarından (1958) alınmıştır," +
                " ancak cin ve kirecin oranı, modern versiyonların sıklıkla atladığı şeker şurubunun dahil edilmesinin yanı sıra şimdi tartışılmaktadır. bazı varyasyonlar, taze limon suyu yerine tatlı \"Gül limon suyu\" kullanılmasını önerir." +
                " \"votka gimlet\" adı verilen popüler bir varyasyonda cin yerine votka bulunur. ayrıca, daiquiri gimlete çok benzer, romu baz olarak kullanır.", R.drawable.gimlet);

        Cocktail americano = new Cocktail("americano", "1.bir bardağı buzla doldurun.\n" +
                "2.buzun üzerine 30 ml kampari ve 30 ml kırmızı vermounth dökün\n" +
                "3.30ml soda ekleyin\n" +
                "4.portakal dilimi ile süsleyin", "Bu klasik kokteyl, 1860'larda yaratılan bir kokteylin bir varyasyonudur, orijinal olarak milano-torino olarak biliniyordu çünkü campari milan'dan ve cinzano torino'dan gelmektedir.", R.drawable.americano);

        Cocktail sexOnTheBeach = new Cocktail("sex on the beach", "1.bir bardağı buz küpleri ile doldurun.\n" +
                "2.40 ml votka 20 ml şeftali likörü 40 ml portakal suyu ve 40 ml kızılcık suyu dökün.\n" +
                "3.hafifçe karıştırın ve bir portakal dilimi ile süsleyin", "Bu basit ve popüler IBA resmi kokteylinin birçok çeşidi var \"Modern sex on the beach\" portakal suyu yerine ananas suyu içeriyor"
                , R.drawable.sexonthebeach);

        Cocktail lemonDrop = new Cocktail("lemon drop", "1.bir shakerı buz küpleriyle doldurun.\n+" +
                "2.50ml votka 25ml limon suyu ve 1 çay kaşığı şeker şurubu ekleyin.\n" +
                "3.iyice çalkalayın ve soğutulmuş bir kokteyl bardağına süzün.\n" +
                "4.limon dilimi ile süsleyiniz.", "Lemon Drop Martini klasik kokteyllerden biridir. Sert olmasına rağmen tatlı bir kokteyl olduğu için sosyal içicilerin tercih ettiği bir kokteyldir."
                , R.drawable.lemondrop);

*/
        AdapterArrayList.add(margarita);
        AdapterArrayList.add(irishCoffee);
        /*AdapterArrayList.add(ginTonic);
        AdapterArrayList.add(mojito);
        AdapterArrayList.add(kamikaze);
        AdapterArrayList.add(gimlet);
        AdapterArrayList.add(americano);
        AdapterArrayList.add(sexOnTheBeach);
        AdapterArrayList.add(lemonDrop);
        /* AdapterArrayList.add(example1);
        AdapterArrayList.add(example);
        AdapterArrayList.add(example1);
        AdapterArrayList.add(example);
        AdapterArrayList.add(example1);
        AdapterArrayList.add(example);
        AdapterArrayList.add(example1);
        AdapterArrayList.add(example);
        AdapterArrayList.add(example1);
 */





        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CocktailAdapter cocktailAdapter = new CocktailAdapter(AdapterArrayList);
        binding.recyclerView.setAdapter(cocktailAdapter);

        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
    }


    }
