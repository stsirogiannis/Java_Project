module gr.unipi.core.project3 {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;

    exports gr.unipi.core;
    exports gr.unipi.gui;

    opens gr.unipi.core to javafx.base;
}