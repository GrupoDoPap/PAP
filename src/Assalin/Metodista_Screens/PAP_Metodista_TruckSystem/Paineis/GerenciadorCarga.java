package Metodista_Screens.PAP_Metodista_TruckSystem.Paineis;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Veiculo;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Viagem;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class GerenciadorCarga {

    private final Stack<Pedido> pilhaPedidos = new Stack<>();
    private double alturaDisponivel, larguraDisponivel, profundidadeDisponivel;

    private boolean analisarCima(Caixa box, Veiculo car) {
        if (box.getAltura() <= alturaDisponivel) {
            alturaDisponivel = alturaDisponivel - box.getAltura();
            return true;
        } else {
            alturaDisponivel = car.getAltura();
            return false;
        }
    }

    private boolean analisarDireita(Caixa box, Veiculo car) {
        if (box.getLargura() <= larguraDisponivel) {
            larguraDisponivel = larguraDisponivel - box.getLargura();
            return true;
        } else {
            larguraDisponivel = car.getLargura();
            return false;
        }
    }

    private boolean analisarFrente(Caixa box, Veiculo car) {
        if (box.getProfundidade() <= profundidadeDisponivel) {
            profundidadeDisponivel = profundidadeDisponivel - box.getProfundidade();
            return true;
        } else {
            profundidadeDisponivel = car.getProfundidade();
            return false;
        }
    }

    public boolean verificarEspacoDisponivel(ArrayList<Pedido> listaPedido, Veiculo car) {
        alturaDisponivel = car.getAltura();
        larguraDisponivel = car.getLargura();
        profundidadeDisponivel = car.getProfundidade();
        for (Pedido ped : listaPedido) {
            for (Caixa caixa : ped.ListarCaixas()) {
                if (this.analisarCima(caixa, car) == true) {
                } else if (this.analisarDireita(caixa, car) == true) {
                } else if (this.analisarFrente(caixa, car) == true) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void organizarCarga(Viagem viagem) {

        alturaDisponivel = viagem.getVeiculo().getAltura();
        larguraDisponivel = viagem.getVeiculo().getLargura();
        profundidadeDisponivel = viagem.getVeiculo().getProfundidade();

        int p = 1, c = 1;

        JOptionPane.showMessageDialog(null, "Iniciando a organização das caixas no caminhão",
                "Organização da Carga", JOptionPane.INFORMATION_MESSAGE);

        for (Pedido ped : viagem.getPilhaPedidos()) {
            JOptionPane.showMessageDialog(null, "Organizando as caixas do pedido " + p,
                    "Organização da Carga", JOptionPane.INFORMATION_MESSAGE);
            for (Caixa caixa : ped.ListarCaixas()) {

                //verifica se é a primeira caixa
                if (p == 1 && c == 1) {
                    JOptionPane.showMessageDialog(null, "Esta é a primeira caixa a ser colocada no caminhão."
                            + "\n Posicione-a no canto inferior esquerdo do veículo.",
                            "Organização da Carga", JOptionPane.INFORMATION_MESSAGE);
                    alturaDisponivel = alturaDisponivel - caixa.getAltura();
                    c++;
                } else if (this.analisarCima(caixa, viagem.getVeiculo()) == true) {
                    JOptionPane.showMessageDialog(null, "Posicione a caixa " + c + " do pedido " + p + " em cima da anterior",
                            "Posicionamento", JOptionPane.INFORMATION_MESSAGE);
                    c++;
                } else if (this.analisarDireita(caixa, viagem.getVeiculo()) == true) {
                    JOptionPane.showMessageDialog(null, "Posicione a caixa " + c + " do pedido " + p + " à direita da anterior",
                            "Posicionamento", JOptionPane.INFORMATION_MESSAGE);
                    c++;
                } else if (this.analisarFrente(caixa, viagem.getVeiculo()) == true) {
                    JOptionPane.showMessageDialog(null, "Posicione a caixa " + c + " do pedido " + p + " à frente das caixas anteriores."
                            + "\n A caixa deve ser posicionada no canto inferior direito do caminhão",
                            "Posicionamento", JOptionPane.INFORMATION_MESSAGE);
                    c++;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro",
                            "Posicionamento", JOptionPane.INFORMATION_MESSAGE);
                    c++;
                }
            }
            p++;
            c = 1;
        }
        JOptionPane.showMessageDialog(null, "Todas as caixas foram posicionadas."
                + "\n O caminhão está organizado.",
                "Posicionamento", JOptionPane.INFORMATION_MESSAGE);
    }

    //verifica a distancia de dois pedidos e a posicao deles na ordem de posicionamento no caminhão
    private boolean verificarDistancia(ArrayList<Pedido> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Pedido pedidoLonge = lista.get(i - 1);
            Pedido pedidoPerto = lista.get(i);

            //se o pedido que entraria primeiro no caminhão tiver uma distancia de entrega maior do que o outro, inverte as posições e retorna falso
            if (pedidoPerto.getCliente().getDistanciaFilial() > pedidoLonge.getCliente().getDistanciaFilial()) {
                lista.set(i, pedidoLonge);
                lista.set(i - 1, pedidoPerto);
                return false;
            }
        }
        return true;
    }

    public Stack<Pedido> arrumarPedidos(ArrayList<Pedido> lista) {
        while (verificarDistancia(lista) == false) {
            verificarDistancia(lista);
        }

        int i = 1;
        String ordem = "A ordem de montagem correta é:\n";

        for (Pedido p : lista) {
            ordem += i + ") Código pedido:  " + p.getCodigo()
                    + "      Nome do cliente: " + p.getCliente().getNome()
                    + "      Quantidade de caixas: " + p.ListarCaixas().size()
                    + "      Distância da filial: " + p.getCliente().getDistanciaFilial() + " km.\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, ordem);
        pilhaPedidos.addAll(lista);

        return pilhaPedidos;
    }
}
