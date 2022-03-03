/* Bruna Scapin Silva - brunascapins@gmail.com
 Questão 03) Um texto precisa ser encriptado usando o seguinte esquema. Primeiro, os espaços são
 removidos do texto. Então, os caracteres são escritos em um grid. */

import java.util.Scanner;

public class Questao03 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String fraseUsuario;

        System.out.println("Informe a frase que gostaria de ser criptografada: ");
        fraseUsuario = leitor.nextLine();

        String frase2 = encriptarFrase(fraseUsuario);
        System.out.println(frase2);
    }

    // Método para criar uma lista a partir de números digitados pelo usuário.
    static String encriptarFrase(String frase) {
        // Todos os espaços são retirados da String.
        frase = frase.replace(" ", "");
        double raizTamanhoFrase = Math.sqrt(frase.length());
        // É salvo o tamanho do grid para a String.
        int tamanhoGrid = (int)Math.ceil(raizTamanhoFrase);

        // Utilizando o método split e a expressão regular foi criado um vetor, com cada elemento sendo o
        // conjunto de caracteres do tamanho do grid.
        String[] vetorCompleto = frase.split("(?<=\\G.{" + tamanhoGrid + "})");

        int tamanhoUltimaLinha = frase.length() % tamanhoGrid;
        int tamanhoVetorCompleto = vetorCompleto.length;

        // Com o intuito de todos os elementos do vetor vetorCompleto terem o mesmo tamanho, foi adicionado
        // espaços em branco no seu último elemento.
        if (tamanhoUltimaLinha != tamanhoGrid) {
            int espacosFaltantes = tamanhoGrid - tamanhoUltimaLinha;
            for (int i = 0; i < espacosFaltantes; i++){
                vetorCompleto[tamanhoVetorCompleto -1] = vetorCompleto[tamanhoVetorCompleto -1].concat(" ");
            }
        }

        // Foi criada uma StringBuilder para finalizar a mensagem codificada.
        StringBuilder mensagem = new StringBuilder();
        char aux;

        // O laço de repetição foi criado para iterar em todos os elementos do vetor vetorCompleto,
        // dessa forma transformando as colunas em palavras e codificando a frase inicial.
        for (int i = 0; i < tamanhoGrid; i++){
            for (String elemento : vetorCompleto) {
                aux = elemento.charAt(i);
                if (!(aux == ' ')){
                    mensagem.append(aux);
                }
            }
            mensagem.append(" ");
        }
        return mensagem.toString();
    }

}
