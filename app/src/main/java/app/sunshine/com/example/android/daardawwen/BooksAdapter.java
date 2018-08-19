package app.sunshine.com.example.android.daardawwen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MovieHolder> {
    /*
    الميثود onCreateViewHolder  ويتم استدعائها اثناء إنشاء الـ ViewHolder  وترجع لنا بـ ViewHolder

الميثود onBindViewHolder  ويتم استدعائها عند عمل Bind او ملىء او ربط الـ ViewHolder

الـ getItemCount تقوم بحساب عدد الصفوف فى الـ Recycler فقط
*/

    Context context;
    List<Book> bookslist;
    final private ListItemClickListener mOnClickListener;


    public BooksAdapter(Context context, List<Book> bookslist, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.bookslist = bookslist;

        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);


        MovieHolder holder =new MovieHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

//        Movie movie =movieslist.get(position);
//        holder.movie_title.setText(movie.title);
//        holder.movie_Rate.setText("("+movie.vote_average+" / 10)");
//        holder.movie_desc.setText(movie.overview);

//        String poster="http://image.tmdb.org/t/p/w342/"+movie.poster_path;
//        Picasso.with(context).load(poster).into(holder.poster);

        holder.bind(bookslist.get(position), mOnClickListener);

    }

    @Override
    public int getItemCount() {
        return bookslist.size();
    }
    public void updateMovies(ArrayList<Book> books_list) {
        this.bookslist= books_list;
        this.notifyDataSetChanged();
    }

    class MovieHolder extends RecyclerView.ViewHolder  {

        TextView bookTitle ;
        ImageView poster;

        public MovieHolder(View itemView) {
            super(itemView);

            bookTitle =itemView.findViewById(R.id.movietitleTV);
            poster=itemView.findViewById(R.id.movieposteIMG);


        }

        public void bind(final Book item, final ListItemClickListener listener) {
            bookTitle.setText(item.title);
            poster.setImageResource(item.poster_path);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onListItemClick(item);
                }
            });
        }

//        @Override
//        public void onClick(View view) {
//            Movie movie = getAdapterPosition();
//            mOnClickListener.onListItemClick(clickedPosition);
//        }
    }

    public interface ListItemClickListener {
        void onListItemClick(Book movieitem);
    }
}
