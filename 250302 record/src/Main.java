import record.Level;
import record.RecordSample;
import record.RecordSample2;

public class Main {
    public static void main(String[] args) {


        RecordSample2 허곰 = new RecordSample2(1, "허곰");

        System.out.println("허곰 = " + 허곰);

        RecordSample 허곰1 = new RecordSample(1, "허곰");
        RecordSample 허곰2 = new RecordSample(1, "허곰");

        System.out.println(허곰1.equals(허곰2));

        Level myVar = Level.LOW;
        System.out.println("myVar = " + myVar);

        switch (myVar) {
            case LOW:
                System.out.println("LOW LEVEL");
                break;
            case MEDIUM:
                System.out.println("MEDIUM LEVEL");
                break;
            case HIGH:
                System.out.println("HIGH LEVEL");
                break;
            default:
                break;

        }

        for (Level level : Level.values()) {
            System.out.println("level = " + level);
        }
    }
}