import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TextEditorTest {
    @Test
    void testCountVowels() {
        TextEditor textEditor = new TextEditor();
        textEditor.jta.setText("Hello, World!");
        int result = textEditor.countVowels();
        assertEquals(3, result);
    }

    @Test
    void testCountSpecialSymbols() {
        TextEditor textEditor = new TextEditor();
        textEditor.jta.setText("Hello, $%^&* World!");
        int result = textEditor.countSpecialSymbols();
        assertEquals(7, result);
    }
}
