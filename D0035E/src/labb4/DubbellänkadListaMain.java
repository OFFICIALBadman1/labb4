package labb4;

import java.util.NoSuchElementException;

/*
 * Håkan Jonsson, LTU
 */
public class DubbellänkadListaMain {

    public static void slumptest() {
        DubbellänkadLista<Integer> lista = new DubbellänkadLista<Integer>();
        int ANTAL_OPERATIONER = 16;
        System.out.println("*************************************************");
        System.out.println(
                "Testar totalt " + ANTAL_OPERATIONER
                        + " slumpmässiga tillägg/borttag ...");
        lista.läggTillFörst(3);
        lista.läggTillFörst(2);
        lista.läggTillFörst(1);
        System.out.println("3 anrop till läggTillFörst lägger först till 3,\n"
                + "2 och 1 till en tom lista, vilket skapar startlistan "
                + lista);

        System.out.println("-----------------");

        for (int i = 4; i <= ANTAL_OPERATIONER; i++) {
            if (Math.random() < 0.5) {
                // Lägg till ...
                if (Math.random() < 0.5) {
                    // ... först!
                    lista.läggTillFörst(i);
                    System.out.print("läggTillFörst(" + i + ")");
                } else {
                    // ... sist!
                    lista.läggTillSist(i);
                    System.out.print("läggTillSist(" + i + ")");
                }
            } else {
                // Ta bort ...
                if (lista.längd() == 0) {
                    System.out
                            .print("Kan ej ta bort pga tom lista (inget fel)");
                } else {
                    if (Math.random() < 0.5) {
                        // ... först!
                        System.out.print("taBortFörsta()");
                        lista.taBortFörsta();
                    } else {
                        // ... sist!
                        System.out.print("taBortSista()");
                        lista.taBortSista();
                    }
                }
            }
            System.out.println(" => " + lista);
            System.out.println("-----------------");
        }

        System.out.println("... OK");
    }

    private static void läggTillFörstTaBortFörsta() {
        DubbellänkadLista<String> lista = new DubbellänkadLista<String>();

        assert lista.längd() == 0;
        lista.läggTillFörst("X");
        assert lista.längd() == 1;
        lista.läggTillFörst("X");

        assert lista.längd() == 2;

        lista.taBortFörsta();
        assert lista.längd() == 1;
        lista.taBortFörsta();
        assert lista.längd() == 0;
    }

    private static void läggTillFörstTaBortSista() {
        DubbellänkadLista<String> lista = new DubbellänkadLista<String>();

        assert lista.längd() == 0;
        lista.läggTillFörst("X");
        assert lista.längd() == 1;
        lista.läggTillFörst("X");

        assert lista.längd() == 2;

        lista.taBortSista();
        assert lista.längd() == 1;
        lista.taBortSista();
        assert lista.längd() == 0;
    }

    private static void läggTillSistTaBortFörsta() {
        DubbellänkadLista<String> lista = new DubbellänkadLista<String>();

        assert lista.längd() == 0;
        lista.läggTillSist("X");
        assert lista.längd() == 1;
        lista.läggTillSist("X");

        assert lista.längd() == 2;

        lista.taBortFörsta();
        assert lista.längd() == 1;
        lista.taBortFörsta();
        assert lista.längd() == 0;
    }

    private static void läggTillSistTaBortSista() {
        DubbellänkadLista<String> lista = new DubbellänkadLista<String>();

        assert lista.längd() == 0;
        lista.läggTillSist("X");
        assert lista.längd() == 1;
        lista.läggTillSist("X");

        assert lista.längd() == 2;

        lista.taBortSista();
        assert lista.längd() == 1;
        lista.taBortSista();
        assert lista.längd() == 0;
    }

    public static void längdtest() {
        System.out.println("*************************************************");
        System.out.println("Testar att längden ändras som den ska ...");

        läggTillFörstTaBortFörsta();
        läggTillFörstTaBortSista();
        läggTillSistTaBortFörsta();
        läggTillSistTaBortSista();

        System.out.println("... OK");
    }

    public static void undantagstest() {

        System.out.println("*************************************************");
        System.out.println("Testar att undantag kastas som de ska ...");

        DubbellänkadLista<Character> lista = new DubbellänkadLista<Character>();

        try {
            lista.taBortFörsta();
            System.out.println("... FEL: Lyckas ta bort ur tom lista");
            System.exit(1);
        } catch (NoSuchElementException e) {
            // OK
        } catch (Throwable e) {
            throw new RuntimeException("Fel undantag kastas! \n" + e);
        }

        try {
            lista.taBortSista();
            System.out.println("... FEL: Lyckas ta bort ur tom lista");
            System.exit(1);
        } catch (NoSuchElementException e) {
            // OK
        } catch (Throwable e) {
            throw new RuntimeException("Fel undantag kastas! \n" + e);
        }

        System.out.println("... OK");
    }

    public static void nulltest() {
        System.out.println("*************************************************");
        System.out.println("Testar att null kan läggas till/tas bort ...");

        DubbellänkadLista<Object> lista = new DubbellänkadLista<Object>();

        assert lista.längd() == 0;
        lista.läggTillFörst(null);
        assert lista.längd() == 1;
        lista.läggTillFörst(null);
        assert lista.längd() == 2;

        lista = new DubbellänkadLista<Object>();

        assert lista.längd() == 0;
        lista.läggTillFörst(null);
        assert lista.längd() == 1;
        lista.läggTillSist(null);
        assert lista.längd() == 2;

        lista = new DubbellänkadLista<Object>();

        assert lista.längd() == 0;
        lista.läggTillSist(null);
        assert lista.längd() == 1;
        lista.läggTillSist(null);
        assert lista.längd() == 2;

        lista = new DubbellänkadLista<Object>();

        assert lista.längd() == 0;
        lista.läggTillSist(null);
        assert lista.längd() == 1;
        lista.läggTillFörst(null);
        assert lista.längd() == 2;

        System.out.println("... OK");
    }

    public static void tillfråntest() {
        System.out.println("*************************************************");
        System.out.println("Testar att tillagt även är vad som tas bort ...");

        DubbellänkadLista<Double> lista = new DubbellänkadLista<Double>();

        lista.läggTillFörst(1.0);
        assert lista.längd() == 1;
        double d = lista.taBortFörsta();
        assert d == 1.0;
        assert lista.längd() == 0;

        lista.läggTillFörst(2.0);
        assert lista.längd() == 1;
        d = lista.taBortSista();
        assert d == 2.0;
        assert lista.längd() == 0;

        lista.läggTillSist(3.0);
        assert lista.längd() == 1;
        d = lista.taBortFörsta();
        assert d == 3.0;
        assert lista.längd() == 0;

        lista.läggTillSist(4.0);
        assert lista.längd() == 1;
        d = lista.taBortSista();
        assert d == 4.0;
        assert lista.längd() == 0;

        System.out.println("... OK");
    }

    public static void main(String[] args) {
        // Kommentera bort de tester du inte vill göra (kör ett test i taget)
        undantagstest();
        längdtest();
        nulltest();
        tillfråntest();
        slumptest();
    }
}
