package testUtils;

//Kształt.class
 abstract class Ksztalt {
    public String nazwa;
    public Integer wysokość;
    public Integer szerokość;
    public abstract Integer obliczPole();
    public abstract Integer obliczObwód();

    protected Ksztalt() {};
    protected Ksztalt(String nazwa, Integer wysokość,
                       Integer szerokość) {
        this.nazwa = nazwa;
        this.wysokość = wysokość;
        this.szerokość = szerokość;
    }
}
//Prostokąt.class
class Prostokąt extends Ksztalt{
    public Prostokąt(Integer wysokość, Integer szerokość) {
        super("Prostokąt", wysokość, szerokość);
    }

    @Override
    public Integer obliczPole() {
        return (this.wysokość *this.wysokość);
    }

    @Override
    public Integer obliczObwód() {
        return 2*(this.wysokość +this.szerokość);
    }
}
//Kwadrat.class
class Kwadrat extends Prostokąt {
    public Kwadrat(Integer długośćBoku) {
        super(długośćBoku,długośćBoku);
        this.nazwa= "Kwadrat";
    }
}
//TrójkątProstokątny.class
class TrójkątProstokątny extends Ksztalt {
    private Integer podstawa;
    private Integer przekątna;

    public TrójkątProstokątny(Integer podstawa, Integer przekątna,
                               Integer wysokość) {
        this.podstawa= podstawa;
        this.nazwa= "Trójkąt";
        this.przekątna = przekątna;
        this.wysokość =wysokość;
    }

    @Override
    public Integer obliczPole() {
        return (podstawa* wysokość)/2;
    }

    @Override
    public Integer obliczObwód() {
        return (podstawa+wysokość+przekątna);
    }

    public Integer getPodstawa() {
        return podstawa;
    }

    public Integer getPrzekątna() {
        return przekątna;
    }
}

//TestInheritance.java
public class TestInheritance {

    public static void main(String[] args) {
        //Naturalne przypisanie referencji obiektu Prostokąt
        Prostokąt prostokąt = new Prostokąt(5,11);
        //Dziedziczenie 1 rzędowe, tutaj również relacja IS-A
        Prostokąt kwadrat2 = new Kwadrat(8);
        //Mechanizm ISA drugorzędowy
        Ksztalt trójkątP = new TrójkątProstokątny(10,3,2);
        Ksztalt kwadrat = new Kwadrat(5);
        // =>  Kwadrat nieKwadrat = new Prostokąt(11,12); to nie zadziała gdyż prostokąt nie jest kwadratem
        System.out.println("Pole kwadratu(Kształt) o boku 5: "+ kwadrat.obliczPole());
        System.out.println("Obwód kwadratu2(Prostokąt) o boku 8: " + kwadrat2.obliczObwód());
        System.out.println("Obwód prostokąta(Prostokąt) o boku 11 oraz 5: " + prostokąt.obliczObwód());
        System.out.println("Pole kwadratu2(Prostokąt) o boku 8: " + kwadrat2.obliczPole());
        //dla trójkąta prostokątnego :
        System.out.println("Obwód trójkątaP(Kształt) o podstawie 10|przekątnej 3| wysokości 2|: " + trójkątP.obliczObwód());
        System.out.println("Pole trójkątaP(Kształt) o podstawie 10|przekątnej 3| wysokości 2|: " + trójkątP.obliczPole());
    }
}
