package menu.view.output;

public interface Printer {

    void println();

    void printMessage(Output output);

    void printfMessage(Output output, Object... args);
}