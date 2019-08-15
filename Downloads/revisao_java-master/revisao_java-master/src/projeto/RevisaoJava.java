package projeto;

import java.util.Random;

/*
   autor: Jonas Dhein
*/

public class RevisaoJava {

    //método de inicialização da classe
    public static void main(String[] args) {
        
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        
        pessoa1.setCodigo(1);
        pessoa1.setNome("Juca");
        pessoa1.setValorConta(500);
        
        pessoa2.setCodigo(2);
        pessoa2.setNome("João");
        
        System.out.println(pessoa1);
        System.out.println(pessoa2);
        
        /* Definir um valorConta para cada pessoa.
           Criar um método dentro da classe Pessoa que diminui e um que aumenta
           o valor da conta.
        Ex: Transferir parte do valor de uma conta para a outra
        Ao final, imprimir o saldo das duas pessoas
        PLUS: Validar se a pessoa tem saldo para essa transferencia
        */
        
        System.out.println("Olá Mundo");
        int resultado = Funcoes.somarNumeros(1, 2);
        System.out.println("Resultado = " + resultado);
        
        //criamos uma instância de Funcoes
        Funcoes func = new Funcoes();
        resultado = func.subtrairNumeros(4, 1);
        System.out.println("Resultado = " + resultado);
        
        imprimirMensagem("TESTE 1");
        imprimirMensagem("TESTE 2");
        imprimirMensagem("TESTE 3");
        
        for(int i = 0; i <10; i++){
            System.out.println("valor de i = " + i);
        }
        
        int x = 15;
        while( x < 18 ){
            System.out.println("Sem permissão!!!");
            x++;
        }
        
        int[] numeros = {1,2,3};
        System.out.println("ENCHANCED FOR");
        for(int var : numeros){
            System.out.println(var);
        }
        
        System.out.println("FOR COMUM");
        for(int var = 0; var < numeros.length; var++){
            System.out.println(numeros[var]);
        }
        
        int[] numeros_array = {2,2,3,4,45,555};
        int res_soma = Funcoes.somarNumeros(numeros_array);
        System.out.println("RESULTADO DA SOMA = " + res_soma);
        
        int res_mul = Funcoes.multiplicaNumeros(numeros_array);
        System.out.println("RESULTADO DA MULTIPLICAÇÃO = " + res_mul);
        
        double res_div = Funcoes.divideNumeros(numeros_array);
        System.out.println("RESULTADO DA DIVISAO = " + res_div);
        
        int res_sub = Funcoes.subtraiNumeros(numeros_array);
        System.out.println("RESULTADO DA SUBTRACAO = " + res_sub);
        
        System.out.println();//linha em branco
        System.out.println();//linha em branco
        System.out.println();//linha em branco
        String sorteio = Funcoes.sortearNumeros(6, 60);
        System.out.println("SORTEIO = " + sorteio);
        
    }
    
    public static void imprimirMensagem(String par1){
        System.out.println(par1);
    }
    
}
