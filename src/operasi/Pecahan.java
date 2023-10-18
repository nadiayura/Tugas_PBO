package operasi;

public class Pecahan {
    private int pembilang;
    private int penyebut;

    public Pecahan(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public Pecahan tambah(Pecahan other) {
        int newPembilang = (this.pembilang * other.penyebut) + (other.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * other.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan kurang(Pecahan other) {
        int newPembilang = (this.pembilang * other.penyebut) - (other.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * other.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan kali(Pecahan other) {
        int newPembilang = this.pembilang * other.pembilang;
        int newPenyebut = this.penyebut * other.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan bagi(Pecahan other) {
        int newPembilang = this.pembilang * other.penyebut;
        int newPenyebut = this.penyebut * other.pembilang;
        return new Pecahan(newPembilang, newPenyebut);
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }
}
