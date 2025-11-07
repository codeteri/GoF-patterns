package Builder;

// Product class
class Computer {
    private String cpu;
    private String memory;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "CPU: " + cpu + "\nMemory: " + memory + "\nStorage: " + storage;
    }
}

// Builder interface
interface IComputerBuilder {
    void buildCPU(String cpu);
    void buildMemory(String memory);
    void buildStorage(String storage);
    Computer getResult();
}

// Concrete Builder
class DesktopComputerBuilder implements IComputerBuilder {
    private Computer computer;

    public DesktopComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String cpu) {
        computer.setCPU(cpu);
    }

    @Override
    public void buildMemory(String memory) {
        computer.setMemory(memory);
    }

    @Override
    public void buildStorage(String storage) {
        computer.setStorage(storage);
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
class ComputerAssembler {
    public Computer assembleComputer(IComputerBuilder builder) {
        builder.buildCPU("Intel i7");
        builder.buildMemory("16GB");
        builder.buildStorage("512GB SSD");
        return builder.getResult();
    }
}

// Main class to run the example
public class Main {
    public static void main(String[] args) {
        DesktopComputerBuilder desktopBuilder = new DesktopComputerBuilder();
        ComputerAssembler assembler = new ComputerAssembler();
        Computer desktop = assembler.assembleComputer(desktopBuilder);

        System.out.println("Desktop Computer Specs:");
        System.out.println(desktop);
    }
}