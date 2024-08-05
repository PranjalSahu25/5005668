package BuilderPattern;
public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        Computer basicComputer = new Computer.Builder("AMD Ryzen 3", "8GB")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
        System.out.println("Basic Computer: " + basicComputer);
    }
}
