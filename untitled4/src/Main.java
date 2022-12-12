public class Main {
    static double[][] tabl = new double[10][3];
    static double Qm = 0;                //общая вероятность прошлых

    public static void main(String[] args) {
        double z1 = 0.355;              //меняем под себя
        double z2 = 0.03;
        double z3 = 0.01;
        double z4 = 0.1;
        double z5 = 0.28;
        double z6 = 0.073;
        double z7 = 0.034;
        double z8 = 0.046;
        double z9 = 0.018;
        double z10 = 0.054;

        addInTable(z1, 0);                      //меняем под свою последовательность
        addInTable(z5, 1);
        addInTable(z4, 2);
        addInTable(z6, 3);
        addInTable(z10, 4);
        addInTable(z8, 5);
        addInTable(z7, 6);
        addInTable(z2, 7);
        addInTable(z9, 8);
        addInTable(z3, 9);

        tabl[0][2] = om(tabl[0][1], tabl[0][0]);
        tabl[1][2] = om(tabl[1][1], tabl[1][0]);
        tabl[2][2] = om(tabl[2][1], tabl[2][0]);
        tabl[3][2] = om(tabl[3][1], tabl[3][0]);
        tabl[4][2] = om(tabl[4][1], tabl[4][0]);
        tabl[5][2] = om(tabl[5][1], tabl[5][0]);
        tabl[6][2] = om(tabl[6][1], tabl[6][0]);
        tabl[7][2] = om(tabl[7][1], tabl[7][0]);
        tabl[8][2] = om(tabl[8][1], tabl[8][0]);
        tabl[9][2] = om(tabl[9][1], tabl[9][0]);

        System.out.println("Код Гилберта Мура");
        for (int i = 0; i < tabl.length; i++) {
            for (int j = 0; j < tabl[i].length; j++) {
                System.out.print(round(tabl[i][j], 10) + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Ручками посчитай L = [-log2 Pm] + 1");
        System.out.println("Далее переведи сигму Om (3 столбик) в двоичный код и выдели поссчитанную длину");
        System.out.println("Считай L среднее (Ответ будет в бит)");
        System.out.println("Считай этропию H = Pm log2 Pm + ...");
        System.out.println("r = L - H");
    }

    public static double om(double Qm, double Pm){
        return Qm + (Pm / 2);
    }

    public static void addInTable(double z, int i){
        tabl[i][0] = z;
        tabl[i][1] = Qm;
        Qm += z;
    }

    public static double round(double value, int places){
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}