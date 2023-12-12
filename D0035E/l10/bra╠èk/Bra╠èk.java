package l10.bråk;

/*
 * Håkan Jonsson, LTU
 *
 * Exempel på en icke muterbar klass Bråk för att representera bråk 
 * med heltal i täljare och nämnare. 
 */
public class Bråk {

    private int täljare;
    private int nämnare;

    public Bråk(int täljare, int nämnare) {
        if (nämnare == 0) {
            throw new RuntimeException("Nämnaren är 0.");
        }
        if (nämnare < 0) { // Säkerställer att endast täljaren är negativ
            this.täljare = -täljare;
            this.nämnare = -nämnare;
        } else {
            this.täljare = täljare;
            this.nämnare = nämnare;
        }

        int gcd = (int) gcd(this.täljare, this.nämnare); // Förenkla
        this.täljare = this.täljare / gcd;
        this.nämnare = this.nämnare / gcd;
    }

    private static long gcd(long a, long b) { // största gemensamma delaren
        return b == 0 ? Math.max(a, -a) : gcd(b, a % b);
    }

    public Bråk clone() {
        return new Bråk(this.täljare, this.nämnare);
    }

    public int täljare() {
        return this.täljare;
    }

    public int nämnare() {
        return this.nämnare;
    }

    public Bråk invertera() {
        if (this.täljare == 0) {
            throw new RuntimeException("Täljaren är 0. Kan inte invertera.");
        }
        return new Bråk(this.nämnare, this.täljare);
    }

    public Bråk negera() {
        return new Bråk(-this.täljare, this.nämnare);
    }

    public Bråk addera(Bråk bråk) {
        return new Bråk(
                this.täljare * bråk.nämnare + this.nämnare * bråk.täljare,
                this.nämnare * bråk.nämnare);
    }

    public Bråk multiplicera(Bråk bråk) {
        return new Bråk(this.täljare * bråk.täljare,
                this.nämnare * bråk.nämnare);
    }

    public String toString() {
        return "" + this.täljare
                + (this.nämnare != 1 ? "/" + this.nämnare : "");
    }

    public static void main(String[] args) {
        System.out.println(new Bråk(-1, 2).addera(new Bråk(3, -4)));
        System.out.println(new Bråk(20, 30).multiplicera(new Bråk(-1, 2)));

        System.out.println("***");

        System.out.println(new Bråk(20, 30));
        System.out.println(new Bråk(-20, 30));
        System.out.println(new Bråk(20, -30));
        System.out.println(new Bråk(-20, -30));

        System.out.println("***");

        System.out.println(new Bråk(45, 10).negera());
        System.out.println(new Bråk(20, 30).invertera());

    }
}

