class Army {

    public static void createArmy() {
        final Unit unitJohn = new Unit("John");
        final Unit unitMax = new Unit("Max");
        final Unit unitAlex = new Unit("Alex");
        final Unit unitRon = new Unit("Ron");
        final Unit unitHarry = new Unit("Harry");

        final Knight knightAndrew = new Knight("Andrew");
        final Knight knightTom = new Knight("Tom");
        final Knight knightNikolas = new Knight("Nikolas");

        final General generalTony = new General("Tony");

        final Doctor doctorAlice = new Doctor("Alice");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}