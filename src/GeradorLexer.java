import jflex.exceptions.SilentExit;

import javax.swing.*;

import static jflex.Main.generate;

public class GeradorLexer {

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
        String [] rotas = new String[1];
        rotas[0] = "/home/60003373/faculdade/compiladores/atividade/compiler/src/Lexer.flex";
        try{
            execute(rotas);
        } catch (SilentExit ex){
            JOptionPane.showMessageDialog(null, "Erro leitura do arquivo: " + rotas[0]);
        }
    }

    private static void execute(String[] rotas) throws SilentExit {
        generate(rotas);
    }

}
