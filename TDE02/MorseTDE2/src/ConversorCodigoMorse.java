import java.util.HashMap;

class ConversorCodigoMorse {
    HashMap<Character, String> mapaMorse = new HashMap<>();

    // Inicializa o mapeamento de caracteres para código Morse
    public ConversorCodigoMorse() {
        mapaMorse.put('A', ".-");
        mapaMorse.put('B', "-...");
        mapaMorse.put('C', "-.-.");
        mapaMorse.put('D', "-..");
        mapaMorse.put('E', ".");
        mapaMorse.put('F', "..-.");
        mapaMorse.put('G', "--.");
        mapaMorse.put('H', "....");
        mapaMorse.put('I', "..");
        mapaMorse.put('J', ".---");
        mapaMorse.put('K', "-.-");
        mapaMorse.put('L', ".-..");
        mapaMorse.put('M', "--");
        mapaMorse.put('N', "-.");
        mapaMorse.put('O', "---");
        mapaMorse.put('P', ".--.");
        mapaMorse.put('Q', "--.-");
        mapaMorse.put('R', ".-.");
        mapaMorse.put('S', "...");
        mapaMorse.put('T', "-");
        mapaMorse.put('U', "..-");
        mapaMorse.put('V', "...-");
        mapaMorse.put('W', ".--");
        mapaMorse.put('X', "-..-");
        mapaMorse.put('Y', "-.--");
        mapaMorse.put('Z', "--..");
    }

    // Método para obter o código Morse de um caractere
    public String obterCodigoMorse(char c) {
        return mapaMorse.getOrDefault(c, "Caractere inválido");
    }
}