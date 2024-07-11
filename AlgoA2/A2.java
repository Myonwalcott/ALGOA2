abstract class PCComponent {
    protected String name;
    protected double cost;

    public PCComponent(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}

// Subclasses for different types of PC components
class CPU extends PCComponent {
    public CPU(String name, double cost) {
        super(name, cost);
    }
}

class GPU extends PCComponent {
    public GPU(String name, double cost) {
        super(name, cost);
    }
}

class RAM extends PCComponent {
    public RAM(String name, double cost) {
        super(name, cost);
    }
}

class Storage extends PCComponent {
    public Storage(String name, double cost) {
        super(name, cost);
    }
}

// Class for the PC setup
class PCSetup {
    private PCComponent[] components;
    private int caseSize; // 0 - Small, 1 - Medium, 2 - Large
    private boolean hasRGB;
    private boolean hasLiquidCooling;

    private static final double[] CASE_PREMIUM = { 0, 50, 100 };
    private static final double RGB_COST = 30;
    private static final double LIQUID_COOLING_COST = 100;

    public PCSetup(PCComponent[] components, int caseSize, boolean hasRGB, boolean hasLiquidCooling) {
        this.components = components;
        this.caseSize = caseSize;
        this.hasRGB = hasRGB;
        this.hasLiquidCooling = hasLiquidCooling;
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        // Calculate cost of components
        for (PCComponent component : components) {
            totalCost += component.getCost();
        }

        // Add case size premium
        totalCost += CASE_PREMIUM[caseSize];

        // Add extra features costs
        if (hasRGB) {
            totalCost += RGB_COST;
        }
        if (hasLiquidCooling) {
            totalCost += LIQUID_COOLING_COST;
        }

        return totalCost;
    }
}

public class A2 {
    public static void main(String[] args) {
        // Example setup 1: Gaming PC
        CPU cpu = new CPU("Intel Core i7-11700K", 550);
        GPU gpu = new GPU("NVIDIA GeForce RTX 3080", 1100);
        RAM ram = new RAM("Corsair Vengeance RGB Pro 32GB", 300);
        Storage storage = new Storage("Samsung 970 EVO Plus 1TB SSD", 222);

        PCComponent[] components1 = { cpu, gpu, ram, storage };
        PCSetup setup1 = new PCSetup(components1, 2, true, true);

        // Example setup 2: Workstation PC
        CPU cpu2 = new CPU("AMD Ryzen 9 5900X", 450);
        GPU gpu2 = new GPU("NVIDIA Quadro RTX 4000", 1200);
        RAM ram2 = new RAM("G.Skill Ripjaws V Series 64GB", 300);
        Storage storage2 = new Storage("Western Digital Black SN850 2TB SSD", 300);

        PCComponent[] components2 = { cpu2, gpu2, ram2, storage2 };
        PCSetup setup2 = new PCSetup(components2, 1, false, false);

        // Example setup 3: Cafe PC
        CPU cpu3 = new CPU("3rd Gen Intel Xeon", 1200);
        GPU gpu3 = new GPU("NVIDIA GeForce RTX 4070", 769.99);
        RAM ram3 = new RAM("Kingston FURY Beast RGB 32GB", 289.99);
        Storage storage3 = new Storage("Western Digital 22TB WD RED Pro NAS", 619.99);

        PCComponent[] components3 = { cpu, gpu, ram, storage };
        PCSetup setup3 = new PCSetup(components3, 2, true, true);


        // Calculate and display total cost for each setup
        System.out.println("Setup 1 - Gaming PC:");
        System.out.println("Total Cost: $" + setup1.calculateTotalCost());
        System.out.println();

        System.out.println("Setup 2 - Workstation PC:");
        System.out.println("Total Cost: $" + setup2.calculateTotalCost());
        System.out.println();

        System.out.println("Setup 3 - Cafe PC:");
        System.out.println("Total Cost: $" + setup3.calculateTotalCost());
    }
}
