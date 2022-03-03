/* Bruna Scapin Silva - brunascapins@gmail.com
 Questão 01) A mediana de uma lista de números é basicamente o elemento que se encontra no meio da lista
 após a ordenação. Dada uma lista de números com um número ímpar de elementos, desenvolva um algoritmo
 que encontre a mediana.
 Exemplo:
 Entrada:
 arr = [9, 2, 1, 4, 6]
 Saída:
 4 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Questao01 {

    public static void main(String[] args) {
        // Criação de um ArrayList para conter todos os elementos da lista.
        ArrayList<Integer> listaUsuario = criarListaNumeros();

        // Criação da variável que irá conter a mediana.
        int mediana = encontrarMediana(listaUsuario);

        System.out.println("A mediana da lista é: " + mediana);
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

            // O if previne que seja criada uma lista com quantidade de números pares.
            if (listaMetodo.size()%2 == 0 && !verificadorOperacao.equals("y")) {
                System.out.println("listas com quantidades de números ímpares não são aceitas, " +
                        "Informe mais um número!");
                verificadorOperacao = "y";
            }
            posicaoItem++;
        }

        Collections.sort(listaMetodo);
        return listaMetodo;
    }

    // Método para encontrar a mediana de uma lista.
    static Integer encontrarMediana(ArrayList<Integer> lista) {
        int indice = lista.size()/2;
        if (indice == 0){
            indice = 1;
        }
        return lista.get(indice);

    }
}
