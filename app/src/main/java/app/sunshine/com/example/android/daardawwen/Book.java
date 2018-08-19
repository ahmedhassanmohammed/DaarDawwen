package app.sunshine.com.example.android.daardawwen;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    public String UID;
    public int poster_path;
//    public String overview;
//    public String release_date;
//    public String id;
    public String title;
//    public String popularity;


    public Book(int poster_path,
                String title
                )

    {
        this.poster_path = poster_path;
//        this.overview = overview;
//        this.release_date = release_date;
//        this.id = id;
        this.title = title;
//        this.popularity = popularity;
    }

    protected Book(Parcel in) {
        UID = in.readString();
        poster_path = in.readInt();
//        overview = in.readString();
//        release_date = in.readString();
//        id = in.readString();
        title = in.readString();
//        popularity = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(UID);
        parcel.writeInt(poster_path);
//        parcel.writeString(overview);
//        parcel.writeString(release_date);
//        parcel.writeString(id);
        parcel.writeString(title);
//        parcel.writeString(popularity);
    }
}
