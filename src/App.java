import codigo.Tokens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends JFrame {
    private JPanel painel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton analisarButton;

    public App() {
        add(painel);
        setTitle("Compiler");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        analisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        analysis();
                    }catch(IOException ioe){
                        System.out.println(ioe.getMessage());
                    }
            }
        });
    }

    public void analysis() throws IOException{
        File arquivo = new File("fonte.smm");
        PrintWriter writer;
        try{
            writer = new PrintWriter(arquivo);
            writer.print(textArea1.getText());
            writer.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,  null,  ex);
        }
        Reader reader= new BufferedReader(new FileReader("fonte.smm"));
        Lexer lexer = new  Lexer(reader);
        String resultado =  "";
        while(true){
            Tokens token = lexer.yylex();
            System.out.println(token+"\n");
            if (token==null){
                resultado += "<EOF>";
                textArea2.setText(resultado);
                return;
            }
            switch(token){
                case ERROR:
                    resultado += "Símbolo não Reconhecido.\n";
                    break;
                case IDENTIFICADOR:
                    resultado += "Token: " + token +  " " + lexer.lexema + "\n";
                    break;
                case SOMA:
                    resultado += "Token: " + token + " +\n";
                    break;
                case IGUAL:
                    resultado += "Token: " + token + " ==\n";
                    break;
                case ATRIBUICAO:
                    resultado += "Token: " + token + " =\n";
                    break;
                case PONTO_E_VIRGULA:
                    resultado += "Token: " + token + " ;\n";
                    break;
                case ABRE_PARENTESES:
                    resultado += "Token: " + token + " (\n";
                    break;
                case FECHA_PARENTESES:
                    resultado += "Token: " + token + " )\n";
                    break;
                case ABRE_CHAVES:
                    resultado += "Token: " + token + " {\n";
                    break;
                case FECHA_CHAVES:
                    resultado += "Token: " + token + " }\n";
                    break;
                case DIFERENTE:
                    resultado += "Token: " + token + " !=\n";
                    break;
                case MENOR_QUE:
                    resultado += "Token: " + token + " <\n";
                    break;
                case MAIOR_QUE:
                    resultado += "Token: " + token + " >\n";
                    break;
                case MENOR_IGUAL_QUE:
                    resultado += "Token: " + token + " <=\n";
                    break;
                case MAIOR_IGUAL_QUE:
                    resultado += "Token: " + token + " >=\n";
                    break;
                case SUBTRACAO:
                    resultado += "Token: " + token + " -\n";
                    break;
                case MULTIPLICACAO:
                    resultado += "Token: " + token + " *\n";
                    break;
                case DIVISAO:
                    resultado += "Token: " + token + " /\n";
                    break;
                case SOBRA_DIVISAO:
                    resultado += "Token: " + token + " %\n";
                    break;
                case SIMBOLOS_ESPECIAIS:
                    resultado += "Token: " + token +  " " + lexer.lexema + "\n";
                    break;
                case PONTO:
                    resultado += "Token: " + token + " .\n";
                    break;
                case DOIS_PONTOS:
                    resultado += "Token: " + token + " :\n";
                    break;
                case ASPAS_DUPLAS:
                    resultado += "Token: " + token + " \\\"\n";
                    break;
                case ABRE_BRACKETS:
                    resultado += "Token: " + token + " [\n";
                    break;
                case FECHA_BRACKETS:
                    resultado += "Token: " + token + " ]\n";
                    break;
                default:
                    resultado += "Token: " + token +  " " + lexer.lexema + "\n";
            }
        }
    }

    public static void main(String[] args){
        App app = new App();
        app.setVisible(true);
    }


}

