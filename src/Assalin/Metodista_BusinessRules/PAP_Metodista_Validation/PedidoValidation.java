package Metodista_BusinessRules.PAP_Metodista_Validation;

import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Caixa;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Pedido;
import Metodista_BusinessObjects.PAP_Metodista_BusinessObjects.Veiculo;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoPedido;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoPedidoCaixa;
import Metodista_DataAccess.PAP_Metodista_Dao.DaoVeiculo;
import Metodista_Screens.PAP_Metodista_TruckSystem.Paineis.GerenciadorCarga;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoValidation {

    private final DaoPedido dp = new DaoPedido();
    private final DaoPedidoCaixa dpc = new DaoPedidoCaixa();
    private final GerenciadorCarga gc = new GerenciadorCarga();
    private final DaoVeiculo dv = new DaoVeiculo();
    private Veiculo car = null;
    private final ArrayList<Pedido> arp = new ArrayList<>();

    public int insertPedido(Pedido pedido) {

        double pesoTotal = 0;
        arp.add(pedido);
        car = dv.buscarVeiculoPorDescricao("Accelo 1016 - Vermelho - CMQ 5672");

        for (Caixa box : pedido.ListarCaixas()) {
            pesoTotal += box.getPeso();
        }

        if (pesoTotal <= car.getCapacidade() == true
                && gc.verificarEspacoDisponivel(arp, car) == true
                && pedido.getCliente().getClassificacao().equals("INATIVO") == false) {

            dp.save(pedido);
            pedido.setCodigo(dp.ultimoID());
            this.armazenarCaixasPedido(pedido);

            return dp.ultimoID();
        } else {
            JOptionPane.showMessageDialog(null, "Pedido muito grande.\n Remova algumas caixas.");
            return 3 / 0;
        }
    }

    public void armazenarCaixasPedido(Pedido pedido) {
        int cx1 = 0, cx2 = 0, cx3 = 0, cx4 = 0;

        for (Caixa box : pedido.ListarCaixas()) {
            if (box.getCod() == 1) {
                cx1++;
            } else if (box.getCod() == 2) {
                cx2++;
            } else if (box.getCod() == 3) {
                cx3++;
            } else if (box.getCod() == 4) {
                cx4++;
            } else {
                JOptionPane.showMessageDialog(null, "Código de caixa inválida");
            }
        }

        if (cx1 > 0) {
            dpc.saveCaixasPedido(pedido.getCodigo(), 1, cx1);
        }

        if (cx2 > 0) {
            dpc.saveCaixasPedido(pedido.getCodigo(), 2, cx2);
        }

        if (cx3 > 0) {
            dpc.saveCaixasPedido(pedido.getCodigo(), 3, cx3);
        }

        if (cx4 > 0) {
            dpc.saveCaixasPedido(pedido.getCodigo(), 4, cx4);

        }
    }
}
