package operasi;

public class Matriks {
    public Pecahan[][] data;
    private int baris;
    private int kolom;

    public Matriks(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        data = new Pecahan[baris][kolom];
    }

    public void tambah(Matriks other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Matriks tidak dapat dijumlahkan. Ukuran berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].tambah(other.data[i][j]);
            }
        }
    }

    public void kurang(Matriks other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Matriks tidak dapat dikurangkan. Ukuran berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].kurang(other.data[i][j]);
            }
        }
    }

    public Matriks dot(Matriks other) {
        if (this.kolom != other.baris) {
            System.out.println("Matriks tidak dapat di-dot. Ukuran tidak sesuai.");
            return null;
        }

        Matriks result = new Matriks(this.baris, other.kolom);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < other.kolom; j++) {
                Pecahan sum = new Pecahan(0, 1);
                for (int k = 0; k < this.kolom; k++) {
                    sum = sum.tambah(this.data[i][k].kali(other.data[k][j]));
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }

    public Matriks transpose() {
        Matriks result = new Matriks(this.kolom, this.baris);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }

        return result;
    }

    public Matriks inverse() {
        if (this.baris != this.kolom) {
            System.out.println("Matriks tidak dapat diinvers. Bukan matriks persegi.");
            return null;
        }

        int n = this.baris;
        Matriks augmentedMatriks = new Matriks(n, 2 * n);

        // Membuat matriks augmented yang berisi matriks asli dan matriks identitas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatriks.data[i][j] = this.data[i][j];
                augmentedMatriks.data[i][j + n] = (i == j) ? new Pecahan(1, 1) : new Pecahan(0, 1);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                result.append(data[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
