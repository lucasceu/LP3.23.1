package lista_01;

/*
 * Jogo Batalha naval
*/

//Importa os pacotes que serão usados no programa
import java.util.Scanner;

//Classe Main
public class BatalhaNaval{
    //Metodo main
    public static void main(String[] args){
        char[][] player1 = new char[5][5]; //Declara o tabuleiro do jogador1
        char[][] player2 = new char[5][5]; //Declara o tabuleiro do jogador2
        char[][] player1Localization = new char[5][5]; //Declara o tabuleiro de localização do jogador1
        char[][] player2Localization = new char[5][5]; //Declara o tabuleiro de localização do jogador2
        int counter, value; //Contador define qual jogador deve jogar e value define se algum jogador ganhou

        System.out.printf("Welcome to BattleShip!!!\n\n"); //Imprime uma menssagem de boas vindas

        player1 = startHouses(player1); //Inicia todas as casas do tabuleiro do jogador1 com '-'
        System.out.printf("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.\n"); //Imprime menssagem
        player1 = getData(player1); //Obtem as posições dos navios do jogador1
        System.out.printf("\n"); //Pula linha
        printBoard(player1); //Imprime o tabuleiro do jogador1
        System.out.printf("\n"); //Pula linha

        //Essa parte faz as mesmas coisas que a parte de cima faz porém com o jogador2
        player2 = startHouses(player2);
        System.out.printf("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.\n");
        player2 = getData(player2);
        System.out.printf("\n");
        printBoard(player2);
        System.out.printf("\n");

        player1Localization = startHouses(player1Localization); //inicia o tabuleiro de localização do jogador1 com '-'
        player2Localization = startHouses(player2Localization); //inicia o tabuleiro de localização do jogador2 com '-'

        //Laço de repetição para o jogo ocorrer até um jogador ganhar
        while(true){ //Laço infinito
            counter = 1; //Inicia contador com um para ser a vez do jogador1

            value = plays(counter, player2Localization, player2); //Chama a função plays que serve para o jogador fazer a jogada

            //Se a função plays retornar 6 significa que jogador1 ganhou
            if(value == 6){
                return;
            }

            counter++; //Adiciona 1 ao contador para ser a vez do jogadro 2

            value = plays(counter, player1Localization, player1); //Vez do jogador2 fazer a jogada

            //Se a função retorna 6 significa que o jogadro 2 ganhou
            if(value == 6){
                return;
            }
        }
    }//Fim do metodo main

    //Metodo getDatal(obtem os dados dos jogadrores)
    public static char[][] getData(char[][] array){
        int i, j; //Posições dko tabuleiro
        Scanner input = new Scanner(System.in); //Cria um objeto do tipo Scanner para obter informações do teclado

        //Repete 5 vezes para o jogador incerir 5 navios
        for(int counter = 0; counter < 5;){
            System.out.printf("Enter ship %d location:\n", counter);
            i = input.nextInt();
            j = input.nextInt();

            if(checkPlay(array, i, j) == 0){ //Faz umma checagem para saber se a entrada é valida 
                System.out.printf("Invalid coordinates. Choose different coordinates.\n\n");

                continue;
            }else if(checkPlay(array, i, j) == 1){ //Faz uma checagem para saber se a coordenada ja foi usada
                System.out.printf("You have already used this location. choose different\n\n");

                continue;
            }

            counter++; //Adiciona 1 ao contador
            array[i][j] = '@'; //Atribui o caractere '@' para marcar o local do navio
        }

        return array; //Retorna o array com as informações
    }//Fim do metodo getData

    //Metodo startHouses(inicia as casas do tabuleiro com '-')
    public static char[][] startHouses(char[][] array){
        //Repete 5 vezes
        for(int i = 0; i < 5; i++){
            //Repete 5 vezes
            for(int j = 0; j < 5; j++){
                array[i][j] = '-'; //Atribui o caractere '-' a coordenada i j
            }
        }

        return array; //Retorna o array inicializado
    }//Fim do metodo startHouses

    //Metodo printBoard(imprime o tabuleiro)
    public static void printBoard(char[][] player){
        System.out.printf("NAVAL BATTLE\n\n");
        System.out.printf("   0   1   2   3   4\n");

        //Percorre todas as coordenadas e imprime cada uma
        for(int i = 0; i < 5; i++){
            System.out.printf("%d", i);

            for(int j = 0; j < 5; j++){
                System.out.printf("  %c ", player[i][j]); //Imprime coordenada
            }

            System.out.printf("\n");
        }
    }//Fim do metodo printBoard

    //Metodo checkPlay(faz checagem das jogadas)
    public static int checkPlay(char[][] player, int i, int j){
        //Retorna valores para sinalizar alguma jogada
        if(((i > 4) || (i < 0)) || ((j > 4) || (j < 0))){ //Retorna 0 caso a coordenada estaja fora do limite
            return 0;
        }else if((player[i][j] == '@')){ //Retorna 1 caso a coordenada tenha um '@'
            return 1;
        }else if(player[i][j] == 'O'){ //Retorna 2 caso a coordenada tenha um 'O'
            return 2;
        }else if(player[i][j] == 'X'){ //Retorna 3 caso a coordenada tenha um 'X'
            return 3;
        }

        return -1; //Retorna -1 caso nenhuma das opções se cumpra
    }//Fim do metodo checkPlay

    //Metodo checkVictory(checa se um jogador ganhou)
    public static boolean checkVictory(char[][] board){
        int counter = 0; //Inicia contador com 0

        //Percorre todo o array
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 'X'){ //Olha se a coordenada tem um 'X'
                    counter++; //Adiciona 1 no contador

                    if(counter == 5){ //Se o contador for igual a 5 significa que um jogadro ganhou
                        return true; //Retorna true
                    }
                }
            }
        }

        return false; //Retorna false se ninguem gahou
    }//Fim do metodo checkVictory

    //metodo game(contem a parte logica do jogo e algumas menssagens que vão aparecer durante a partida)
    public static int game(char[][] player, char playerLocalization[][], int i, int j, int check, int counter){
        if((check == 0)){ //Caso a variavel check seja 0 siginifica que um jogador uma coordenada invalida
            System.out.printf("Invalid coordinates. Choose different coordinates.\n");

            return 0; //Retorna 0 para sinalizar o erro
        }else if((check == 1) || (check == 2) || (check == 3)){ //Caso check seja 0 o jogador usou uma coordenada ja usada
            System.out.printf("You already fired on this spot. Choose different coordinates.\n");

            return 0; //Retorna 0 para sinalizar o erro
        }
        
        if(player[i][j] == '@'){ //Se o jogador acertar um navio, esse caractere será atribuido avariavel playerLocalization
            playerLocalization[i][j] = 'X';

            System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", counter, (counter % 2) + 1);
        }else if(player[i][j] == '-'){ //Se o jogadro errar um navio, a variavel playerLocalization recebe 'O'
            playerLocalization[i][j] = 'O';

            System.out.printf("PLAYER %d MISSED!\n", counter);
        }

        if(checkVictory(playerLocalization)){ //Checa se alguem ganhou
            System.out.printf("Player [%d] WINS! You sunk all of your opponent's ships!\n", counter);
                
            return 2; //Retorna 2 se alguem ganhou
        }

        return 1; //Retorna 1 caso nenhuma das opçoes se cumpra
    }//Fim do metodo game

    //Metodo plays(obtem as jogadas do jogador)
    public static int plays(int counter, char[][] playerLocalization, char[][] player){
        int stop = 0, i, j, check; //Variaveis de controle e coordenada
        Scanner input = new Scanner(System.in); //Objeto para obter entradas do teclado

        //Loop que acontece enquanto o jogador digita uma coordenada errada
        while(stop == 0){
            System.out.printf("Player %d, enter hit row/column:\n", counter);
            i = input.nextInt();
            j = input.nextInt();
            check = checkPlay(playerLocalization, i, j); //Checa se a jogada é valida
            stop = game(player, playerLocalization, i, j, check, counter); //Checa se o jogador digitou uma entrada valida
            printBoard(playerLocalization); //Imprime tabuleiro
        }

        //Se stop for igual a 2, significa que algum jogador ganhou
        if(stop == 2){
            input.close(); //Fecha o scanner

            return 6; //Retorna 6 para sinalizar a vitoria
        }

        return -1; //Retorna -1 caso contrario
    }//Fim do metodo plays
}//Fim da classe BN