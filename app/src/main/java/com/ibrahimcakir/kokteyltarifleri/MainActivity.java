package com.ibrahimcakir.kokteyltarifleri;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ibrahimcakir.kokteyltarifleri.Adapter.CocktailAdapter;
import com.ibrahimcakir.kokteyltarifleri.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    ArrayList adapterArrayList = new ArrayList<Cocktail>();
    ArrayList arrayList;
    private String lastFilter = "";
    private boolean isFilteredButton1 = false;
    private boolean isFilteredButton2 = false;
    private boolean isFilteredButton3 = false;
    private boolean isFilteredButton4 = false;

    private ActivityMainBinding binding;
    CharSequence charSequence;
    ArrayList filteredCocktailListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Cocktail margarita = new Cocktail("margarita", "1.Kokteyl bardaklarının ağız kısmına limon sürüp tuza bulayın.\n" +
                " 2.Shaker'da tekila, portakal likörü, limon suyu ve buz parçalarını iyice çalkalayın.\n" +
                "3.buz küpleri ile dolu bir shakera 50ml tekila ve 20ml cointreau veya triple sec dökün.\n" +
                "4.15 ml limon suyu ekleyin.\n" +
                "5.iyice çalkalayın ve bir margarita bardağına süzün",
                "margarita bir klasiktir ve Amerika Birleşik Devletleri'ndeki en popüler tekila bazlı kokteyldir.", R.drawable.margarita,
                new ArrayList<>(Arrays.asList(new Ingredients("50ml Tekila"), new Ingredients("30ml Cointreau"), new Ingredients("yarım lime"), new Ingredients("2 gr tuz"), new Ingredients("100 gr buz"))), false, false, false, true);

        Cocktail irishCoffee = new Cocktail("irish coffee", "1.Öncelikle kadehi sıcak suyla doldurup önden ısıtıyoruz.\n" +
                "2.kadehe 300ml filtre kahve koyun.\n" +
                "3.50ml viski ekleyin ve bir çay kaşığı şeker veya 5ml şeker şurubu ekleyin. şeker eriyene kadar karıştırın.\n" +
                "4.kremayı dikkatlice üstüne dökün", "Bu kokteylin efsanelerinden birine göre, orijinal tarifi Joseph Sheridan tarafından 1940 yılında" +
                " bir İrlanda havalimanına gelen bir grup yolcunun kahveye viski ekleyerek onları ısıtmaya çalışmasıyla oluşturuldu. şimdi bir IBA resmi kokteyli", R.drawable.irishcoffee, new ArrayList<>(Arrays.asList(new Ingredients("50ml viski"), new Ingredients("120ml kahve"), new Ingredients("50ml krema"), new Ingredients("1 çay kaşığı şeker"))), false, true, true, false);

        Cocktail ginTonic = new Cocktail("gin tonic", "1.bir highball bardağını buzla doldurun. \n" +
                "2.buzun üzerine 50ml cin ve 100ml tonik dökün \n" +
                "3.hafifçe karıştırın ve bir limon dilimi ile süsleyin", "basit ve her zaman iyi cin tonik oranı zevkinize göre değişebilir", R.drawable.gintonic, new ArrayList<>(Arrays.asList(new Ingredients("50ml cin"), new Ingredients("100ml tonik"), new Ingredients("süslemek için dilim limon"), new Ingredients("100gr buz"))), false, false, true, false);

        Cocktail mojito = new Cocktail("mojito", "1.bir highball bardağına birkaç dal nane ve 2 çay kaşığı şeker koyun. \n" +
                "2.20 ml limon suyu ekleyin ve nane dallarını karıştırın.\n" +
                "3.bardağı kırılmış buzla doldurun.\n" +
                "4.45 ml beyaz rom dökün ve üzerine soda ekleyin.\n" +
                "5.bir tutam nane yaprağı ve limon dilimi ile süsleyin.", "en popüler rom bazlı kokteyllerden biri bu, 16. yüzyılda küba'da icat edilmiş bir IBA resmi kokteylidir.", R.drawable.mojito, new ArrayList<>(Arrays.asList(new Ingredients("45ml beyaz rum"), new Ingredients("yarım limon"), new Ingredients("6 yaprak nane"), new Ingredients("2 kaşık şeker"), new Ingredients("50ml soda"), new Ingredients("100gr buz"))), false, false, true, false);

        Cocktail kamikaze = new Cocktail("kamikaze", "1.bir shakeri buz küpleriyle doldurun\n" +
                "2.30ml votka 30ml triple sec ve 30ml limon suyu ekleyin\n" +
                "3.iyice çalkalayın ve bir kokteyl bardağına süzün\n" +
                "4.garnitür olarak limon dilimi ile seervis ediniz.", "Bu popüler IBA resmi kokteyli, orijinal kamikaze shooter oyununun bir varyasyonudur.", R.drawable.kamikaze, new ArrayList<>(Arrays.asList(new Ingredients("30ml vodka"), new Ingredients("30ml triple sec veya cointreau"), new Ingredients("yarım limon"), new Ingredients("100gr buz"), new Ingredients("süslemek için dilim limon"))), true, false, false, true);

        Cocktail gimlet = new Cocktail("gimlet", "1.bir karıştırma bardağını buz küpleriyle doldurun.\n" +
                "2.60ml cin ve 15ml limon suyu ekleyin.\n" +
                "3.isteğe bağlı olarak 15ml şeker şurubu ekleyin.\n" +
                "4.karıştırın ve soğutulmuş bir kokteyl bardağına süzün.\n" +
                "5.Bitmiş kokteyli misket limonu kabuğu ile süsleyin.", "20. yüzyılın başından beri uzun bir geçmişi olan klasik bir cin bazlı kokteyl. Bu tarif, içecekleri karıştırmanın güzel sanatlarından (1958) alınmıştır," +
                " ancak cin ve kirecin oranı, modern versiyonların sıklıkla atladığı şeker şurubunun dahil edilmesinin yanı sıra şimdi tartışılmaktadır. bazı varyasyonlar, taze limon suyu yerine tatlı \"Gül limon suyu\" kullanılmasını önerir." +
                " \"votka gimlet\" adı verilen popüler bir varyasyonda cin yerine votka bulunur. ayrıca, daiquiri gimlete çok benzer, romu baz olarak kullanır.", R.drawable.gimlet, new ArrayList<>(Arrays.asList(new Ingredients("60ml cin veya vodka"), new Ingredients("yarım limon"), new Ingredients("opsiyonel olarak 15ml şeker şurubu"), new Ingredients("süslemek için dilim limon"), new Ingredients("50gr buz"))), true, false, true, true);

        Cocktail americano = new Cocktail("americano", "1.bir bardağı buzla doldurun.\n" +
                "2.buzun üzerine 30 ml kampari ve 30 ml kırmızı vermounth dökün\n" +
                "3.30ml soda ekleyin\n" +
                "4.portakal dilimi ile süsleyin", "Bu klasik kokteyl, 1860'larda yaratılan bir kokteylin bir varyasyonudur, orijinal olarak milano-torino olarak biliniyordu çünkü campari milan'dan ve cinzano torino'dan gelmektedir.", R.drawable.amaricano, new ArrayList<>(Arrays.asList(new Ingredients("30ml campari"), new Ingredients("30ml kırmızı vermot"), new Ingredients("30ml soda"), new Ingredients("1 dilim portakal"), new Ingredients("100gr buz"))), false, false, true, false);

        Cocktail sexOnTheBeach = new Cocktail("sex on the beach", "1.bir bardağı buz küpleri ile doldurun.\n" +
                "2.40 ml votka 20 ml şeftali likörü 40 ml portakal suyu ve 40 ml kızılcık suyu dökün.\n" +
                "3.hafifçe karıştırın ve bir portakal dilimi ile süsleyin", "Bu basit ve popüler IBA resmi kokteylinin birçok çeşidi var \"Modern sex on the beach\" portakal suyu yerine ananas suyu içeriyor"
                , R.drawable.sexonthebeach, new ArrayList<>(Arrays.asList(new Ingredients("40ml vodka"), new Ingredients("20ml şeftalili schnapps"), new Ingredients("40ml portakal suyu"), new Ingredients("40gr kızılcık suyu"), new Ingredients("süslemek için dilim portakal"), new Ingredients("100gr buz"))), true, false, true, true);

        Cocktail lemonDrop = new Cocktail("lemon drop", "1.bir shakerı buz küpleriyle doldurun.\n+" +
                "2.50ml votka 25ml limon suyu ve 1 çay kaşığı şeker şurubu ekleyin.\n" +
                "3.iyice çalkalayın ve soğutulmuş bir kokteyl bardağına süzün.\n" +
                "4.limon dilimi ile süsleyiniz.", "Lemon Drop Martini klasik kokteyllerden biridir. Sert olmasına rağmen tatlı bir kokteyl olduğu için sosyal içicilerin tercih ettiği bir kokteyldir."
                , R.drawable.lemondrop, new ArrayList<>(Arrays.asList(new Ingredients("50ml vodka"), new Ingredients("yarım limon"), new Ingredients("1 kaşık şeker şurubu"), new Ingredients("süslemek için dilim limon"))), true, false, true, true);

        adapterArrayList.add(margarita);
        adapterArrayList.add(irishCoffee);
        adapterArrayList.add(ginTonic);
        adapterArrayList.add(mojito);
        adapterArrayList.add(kamikaze);
        adapterArrayList.add(gimlet);
        adapterArrayList.add(americano);
        adapterArrayList.add(sexOnTheBeach);
        adapterArrayList.add(lemonDrop);
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
        CocktailAdapter cocktailAdapter = new CocktailAdapter(adapterArrayList);
        binding.recyclerView.setAdapter(cocktailAdapter);
        GridLayoutManager mLayoutManager = new GridLayoutManager((this), 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        final SearchView[] searchView = {(SearchView) menuItem.getActionView()};
        /* searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b)
                {
                    //Collapse the action item.
                    R.id.action_search.collapseActionView();
                    //Clear the filter/search query.
                    myFilterFunction("");
                }
            }
        });
            }*/

        searchView[0].setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList filteredCocktailListData = new ArrayList<Cocktail>();

                if (TextUtils.isEmpty(s)) {
                    // Arama sorgusu boş ise, filtrelenmiş verileri kontrol et
                    if (!filteredCocktailListData.isEmpty()) {
                        // Filtrelenmiş veriler varsa, aynı filtrelenmiş verileri kullan
                        // Örnek olarak, filteredCocktailListData, önceden filtrelenmiş verileri içeren bir liste
                        // Eğer önceden filtreleme yapılmamışsa, bu kısmı atlayacak
                    } else {
                        // Filtrelenmiş veriler yoksa, tüm verileri içeren orijinal listeyi kullan
                        filteredCocktailListData = new ArrayList<>(adapterArrayList);
                    }
                } else {
                    // Arama sorgusu dolu ise, yeni filtreleme işlemini gerçekleştir
                    for (Object cocktailData : adapterArrayList) {
                        if (((Cocktail) cocktailData).name.contains(s)) {
                            filteredCocktailListData.add(cocktailData);
                        }
                    }
                }

                binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                CocktailAdapter cocktailAdapter = new CocktailAdapter(filteredCocktailListData);
                binding.recyclerView.setAdapter(cocktailAdapter);
                GridLayoutManager mLayoutManager = new GridLayoutManager((MainActivity.this), 2);
                binding.recyclerView.setLayoutManager(mLayoutManager);
                return false;
            }
        });

        return true;

    }


    public void onButton1Clicked(View view) {
        String filterKeyword = "meyve aromalılar";

        if (!isFilteredButton1) {
            ArrayList<Cocktail> filteredCocktailListData = new ArrayList<>();

            for (Object cocktailData : adapterArrayList) {
                Cocktail cocktail = (Cocktail) cocktailData;
                if (cocktail.isFruitFlavored) {
                    filteredCocktailListData.add(cocktail);
                }
            }
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(filteredCocktailListData);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton1 = true;
        } else {
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(adapterArrayList);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton1 = false;
        }

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
    }

    public void onButton2Clicked(View view) {
        String filterKeyword = "espresso bazlılar";

        if (!isFilteredButton2) {
            ArrayList<Cocktail> filteredCocktailListData = new ArrayList<>();

            for (Object cocktailData : adapterArrayList) {
                Cocktail cocktail = (Cocktail) cocktailData;
                if (cocktail.isEspressoFlavored) {
                    filteredCocktailListData.add(cocktail);
                }
            }

            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(filteredCocktailListData);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton2 = true;
        } else {
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(adapterArrayList);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton2 = false;
        }

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
    }

    public void onButton3Clicked(View view) {
        String filterKeyword = "hafif alkollüler";

        if (!isFilteredButton3) {
            ArrayList<Cocktail> filteredCocktailListData = new ArrayList<>();

            for (Object cocktailData : adapterArrayList) {
                Cocktail cocktail = (Cocktail) cocktailData;
                if (cocktail.lightAlcohols) {
                    filteredCocktailListData.add(cocktail);
                }
            }

            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(filteredCocktailListData);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton3 = true;
        } else {
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(adapterArrayList);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton3 = false;
        }

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
    }

    public void onButton4Clicked(View view) {
        String filterKeyword = "sert alkollüler";

        if (!isFilteredButton4) {
            ArrayList<Cocktail> filteredCocktailListData = new ArrayList<>();

            for (Object cocktailData : adapterArrayList) {
                Cocktail cocktail = (Cocktail) cocktailData;
                if (cocktail.strongAlcohols) {
                    filteredCocktailListData.add(cocktail);
                }
            }

            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(filteredCocktailListData);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton4 = true;
        } else {
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            CocktailAdapter cocktailAdapter = new CocktailAdapter(adapterArrayList);
            binding.recyclerView.setAdapter(cocktailAdapter);

            isFilteredButton4 = false;
        }

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
    }
}