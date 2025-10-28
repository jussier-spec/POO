//immportar biblioteca
import java.util.ArrayList;
import java.util.Scanner;

//classe principal
public class EntregaDeGás{
    public static void main(String[] args) {
        //cria um objeto e ler dados digitados pelo usuario
        Scanner sc = new Scanner(System.in);
        //cria uma lista dinamica de pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();
        //atribui o preço do gás a preçoGas
        double precoGas = 120.00;
        //cria a vaiavel opcao
        int opcao;
    //Repete o processo até a condição do while ser atingida
    do {
        //Mortro as opções para o usuario
        System.out.println("\t\n\n Sistema de Entrega de Gás ");
        System.out.println("1 - Fazer pedido");
        System.out.println("2 - Confirmar entrega ");
        System.out.println("3 - Ver pedidos confirmados ");
        System.out.println("4 - Ver pedidos entregues ");
        System.out.println("0 - Sair ");
        System.out.println("Escolha uma opção");
        //atibui a opção escolhida na variavel opcao
        opcao = sc.nextInt();
        //ler linhas
        sc.nextLine();
        //dar opções do usuario escolher
        switch (opcao){
            case 1:

                System.out.println("\n Fazer pedido ");

                System.out.println("Informe o endereço da entrega: ");
                //atribui um endeeço 
                String endereco = sc.nextLine();
            
                System.out.println("informe a quantidade de botijão: ");
                //atribui uma quantidade
                int qtd = sc.nextInt();
                //ler a linha de quantidade
                sc.nextLine();
                //Cria um novo objeto p do tipo pedido que recebe o enderço a quantidade e o preço do gas
                Pedido p = new Pedido(endereco, qtd, precoGas);
                
                System.out.print("\n Resumo do pedido: ");
                //Mostro o resumo do pedido
                System.out.print(p);

                System.out.print("Deseja alterar o endereço? (s/n): ");
                //Ler a opção e atribui a alterar
                String alterar = sc.nextLine();
                //compara se a opção escolhida foi "s" independente de ser maiuscula ou menuscula
                if(alterar.equalsIgnoreCase     ("s")){

                    System.out.println("Novo endereço: ");
                    //novo endereço
                    endereco = sc.nextLine();
                    //aatribui o endereço da entrega ao objeto p
                    p.setEnderecoEntrega(endereco);

                    System.out.print("\n Endereço Atualizado!");
                    
                    System.out.print(p);
                }
                System.out.println("Confirmar pedido? (s/n)" );
                //Ler a opção e atribui a confirmar
                String confirmado = sc.nextLine();
                //compara se a opção escolhida foi "s" independente de ser maiuscula ou menuscula
                if(confirmado.equalsIgnoreCase   ("s")){

                    System.out.println("Digite o número do cartão de crédito: ");
                    //Ler os dado do cartão e atribui a cartao
                    String cartao = sc.nextLine();
                    //aatribui o numero do cartão ao objeto p
                    p.confirmarPedido(cartao);
                    //Adiciona o objeto p dentro do pedido
                    pedidos.add(p);

                    System.out.println("\n Pedito confirmado com sucesso!");
                    //mostra o codigo do pedido
                    System.out.println("Código do pedido: " + p.getCodigo());
                
                }else{
                    System.out.println("Pedido cancelado. ");
                }
                //para caso
                break;
            case 2:
                System.out.print("Informe o código do pedido para confirmar entrega: ");
                //Atribui o codigo do pedido
                int cod = sc.nextInt();
                //Ler a linha 
                sc.nextLine();
                //Atribui falso a encontrado
                boolean encontrado = false;
                //percorre os pedidos
                for (Pedido pedido : pedidos) {
                    System.out.println("\n");
                    //Compara o codigo do pedido com o cod digitado
                    if (pedido.getCodigo() == cod) {
                        //chama o metodo entregarPedido() do objeto pedido
                        pedido.entregarPedido();

                        System.out.println("Entrega confirmada para o pedido #" + cod);
                        //Atribui verdadeiro a encontrado
                        encontrado = true;
                        //para caso
                        break;
                    }
                }
                //compara se encontrado é verdadeiro ou falso
                if (!encontrado) {
                    System.out.println("Pedido não localizado.");
                }
                //para caso
                break;
            case 3:
                System.out.println("\t\n PEDIDOS CONFIRMADOS ");
                //percorre os pedidos
                for (Pedido pedido : pedidos) {
                    System.out.println("\n");
                    //mostra os pedido confirmado
                    if (pedido.getStatus().equalsIgnoreCase("confirmado")) {
                        System.out.print(pedido);
                    }
                }
                //para caso
                break;
            case 4:
                System.out.println("\n=== PEDIDOS ENTREGUES === ");
                //percorre os pedidos
                for (Pedido pedido : pedidos) {
                    System.out.println("\n");
                    //mostra os pedidos entregues
                    if (pedido.getStatus().equalsIgnoreCase("entregue")) {
                        System.out.println("\n");
                        System.out.print(pedido);
                    }
                }
                //para caso
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                //para caso
                break;
            //mostra as opções invalidas
            default:
                System.out.println("Opção invalida! ");
            }
    //enquanto opcao diferente de 0 repete
    }while(opcao != 0);

        sc.close();
    }
}
/*
Funcionalidades implementadas:

✅ Criação de pedidos com data e hora automáticas
✅ Alteração de endereço antes da confirmação
✅ Cálculo automático de total e hora prevista de entrega
✅ Geração automática de código do pedido
✅ Pagamento por cartão de crédito
✅ Atualização de status (“confirmado” e “entregue”)
✅ Consulta de pedidos confirmados e entregues
*/