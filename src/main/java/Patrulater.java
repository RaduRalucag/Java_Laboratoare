class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, double unghi1) {
        super(latura1, latura2, latura1, latura2, unghi1, 180 - unghi1, unghi1, 180 - unghi1);
    }

    public double arie() {
        double result;
        result = latura1 * latura2 * Math.sin(Math.toRadians(unghi1));
        return result;
    }
}

class Romb extends Paralelogram {
    private double diag1, diag2;
    public Romb(int latura1, double unghi1, double diag1, double diag2) {
        super(latura1, latura1, unghi1);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public double arie(){
        double result;
        result = (diag1 * diag2) / 2;
        return result;
    }
}

class Dreptunghi extends Paralelogram {
    public Dreptunghi(int lungime, int latime){
        super(lungime, latime, 90);
    }

    @Override
    public double arie() {
        double result;
        result = latura1 * latura2;
        return result;
    }
}

class Patrat extends Dreptunghi{
    public Patrat(int latura){
        super(latura, latura);
    }

    @Override
    public double arie() {
        double result;
        result = latura1 * latura1;
        return result;
    }
}

class PatrulaterRunner {
    public static void main(String[] args) {
        Paralelogram p = new Paralelogram(2, 3, 60);
        System.out.println(p.arie());
        Romb r = new Romb(2, 60, 3, 4);
        System.out.println(r.arie());
        Dreptunghi d = new Dreptunghi(2, 3);
        System.out.println(d.arie());
        Patrat p2 = new Patrat(2);
        System.out.println(p2.arie());
    }
}