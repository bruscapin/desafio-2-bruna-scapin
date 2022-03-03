/* Bruna Scapin Silva - brunascapins@gmail.com
 Questão 02) Dado um vetor de inteiros n e um inteiro qualquer x. Construa um algoritmo que determine o número
 de elementos pares do vetor que tem uma diferença igual ao valor de x..
 Exemplo:
 Entrada:
 n = [1, 5, 3, 4, 2]
 Saída:
 3 */

import java.util.ArrayList;
import java.util.Scanner;

public class Questao02 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Criação de um ArrayList para conter todos os elementos da lista.
        ArrayList<Integer> listaUsuario = criarListaNumeros();
        int numeroComparacao;

        System.out.println("Informe o número que deseja comparar com a lista");
        numeroComparacao = leitor.nextInt();

        int numeroDiferencas = encontrarDiferencas(listaUsuario, numeroComparacao);
        System.out.println("O número de pares do vetor que tem diferença igual a " + numeroComparacao +
                " é : " + numeroDiferencas);
    }

    // Método para criar uma lista a partir de números digitados pelo usuário.
    static ArrayList<Integer> criarListaNumeros() {
        Scanner leitor = new Scanner(System.in);

        ArrayList<Integer> listaMetodo = new ArrayList<>();
        int posicaoItem = 1;
        String verificadorOperacao = "y";

        // Um laço foi feito para adicionar quantos elementos no ArrayList o usuário desejar.
        while (verificadorOperacao.equals("y")){
            System.out.println("Informe o número " + posicaoItem + " da lista");
            listaMetodo.add(leitor.nextInt());
            System.out.println("Digite y para adicionar mais número na lista, ou n para sair");
            verificadorOperacao = leitor.next();
            posicaoItem++;
        }

        return listaMetodo;
    }

    // Método para encontrar a quantidade de diferencas dos elementos.
    static Integer encontrarDiferencas(ArrayList<Integer> lista, int numeroComparacao) {
        int contadorDiferencas = 0;

        for (int primeiroElemento : lista) {
            for (int segundoElemento : lista) {
                int diferenca = primeiroElemento - segundoElemento;
                if (diferenca == numeroComparacao){
                    contadorDiferencas++;
                }
            }
        }

        return contadorDiferencas;
    }
}
