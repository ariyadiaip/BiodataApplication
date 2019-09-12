package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    int no;
    String name, tgl_lahir, jenkel, alamat;

    public Student() { }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.no);
        dest.writeString(this.name);
        dest.writeString(this.tgl_lahir);
        dest.writeString(this.jenkel);
        dest.writeString(this.alamat);
    }

    protected Student(Parcel in) {
        this.no = in.readInt();
        this.name = in.readString();
        this.tgl_lahir = in.readString();
        this.jenkel = in.readString();
        this.alamat = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
