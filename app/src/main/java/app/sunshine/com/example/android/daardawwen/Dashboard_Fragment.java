package app.sunshine.com.example.android.daardawwen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Dashboard_Fragment extends Fragment implements BooksAdapter.ListItemClickListener {
    int posters[] = {R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal,
            R.mipmap.g4, R.mipmap.lazal};

    String Titles[] = {"الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",
            "الجريمة 4", "لا زال حيا",};

    List<Book> books = new ArrayList<Book>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        for (int i = 0; i < posters.length; i++) {
            Book book = new Book(posters[i], Titles[i]);
            books.add(book);
        }

        RecyclerView recyclerView1 = view.findViewById(R.id.recycler1);
        RecyclerView recyclerView2 = view.findViewById(R.id.recycler2);
        RecyclerView recyclerView3 = view.findViewById(R.id.recycler3);
        RecyclerView recyclerView4 = view.findViewById(R.id.recycler4);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));

        BooksAdapter adapter = new BooksAdapter(getActivity(), books, this);
        recyclerView1.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);
        recyclerView3.setAdapter(adapter);
        recyclerView4.setAdapter(adapter);


        return view;
    }


    @Override
    public void onListItemClick(Book movieitem) {
//        Details_Fragment details_fragment = new Details_Fragment();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.DashboardFrag, details_fragment, "").commit();

        Intent intent =new Intent(getActivity() , Details.class);
        startActivity(intent);

    }
}
