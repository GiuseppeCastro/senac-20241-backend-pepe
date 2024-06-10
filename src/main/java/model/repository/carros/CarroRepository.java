package model.repository.carros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.carros.Carro;
import model.entity.carros.Montadora;
import model.repository.Banco;
import model.repository.BaseRepository;
import model.seletor.carros.CarroSeletor;

public class CarroRepository implements BaseRepository<Carro> {

    private MontadoraRepository montadoraRepository = new MontadoraRepository();

    @Override
    public Carro consultarPorId(int id) {
        Connection conn = Banco.getConnection();
        String query = "SELECT * FROM Carro WHERE id = ?";
        Carro carro = null;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    carro = new Carro();
                    carro.setId(resultado.getInt("id"));
                    carro.setModelo(resultado.getString("modelo"));
                    carro.setPlaca(resultado.getString("placa"));
                    int montadoraId = resultado.getInt("montadora_id");       
                    carro.setAno(resultado.getInt("ano"));
                    carro.setValor(resultado.getDouble("valor"));
                    
                    // Buscando montadora
                    Montadora montadora = consultarMontadoraPorId(montadoraId);
                    carro.setMontadora(montadora);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao consultar carro com o id: " + id);
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            Banco.closeConnection(conn);
        }

        return carro;
    }

    @Override
    public ArrayList<Carro> consultarTodos() {
        ArrayList<Carro> carros = new ArrayList<>();
        Connection conn = Banco.getConnection();
        String query = "SELECT * FROM Carro";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Carro carro = new Carro();
                carro.setId(resultado.getInt("id"));
                carro.setModelo(resultado.getString("modelo"));
                carro.setPlaca(resultado.getString("placa"));
                carro.setAno(resultado.getInt("ano"));
                carro.setValor(resultado.getDouble("valor"));

                // Buscando montadora
                int montadoraId = resultado.getInt("montadora_id");
                Montadora montadora = consultarMontadoraPorId(montadoraId);
                carro.setMontadora(montadora);

                carros.add(carro);
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao consultar todos os carros");
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            Banco.closeConnection(conn);
        }

        return carros;
    }

    public ArrayList<Carro> consultarPorSeletor(CarroSeletor seletor) {
        ArrayList<Carro> carros = new ArrayList<>();
        Connection conn = Banco.getConnection();
        StringBuilder query = new StringBuilder("SELECT * FROM Carro WHERE 1=1");

        if (seletor.getModelo() != null && !seletor.getModelo().trim().isEmpty()) {
            query.append(" AND modelo LIKE ?");
        }
        if (seletor.getNomeMarca() != null && !seletor.getNomeMarca().trim().isEmpty()) {
            query.append(" AND montadora_id IN (SELECT id FROM Montadora WHERE nome LIKE ?)");
        }
        if (seletor.getAnoInicial() != null) {
            query.append(" AND ano >= ?");
        }
        if (seletor.getAnoFinal() != null) {
            query.append(" AND ano <= ?");
        }

        try (PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;

            if (seletor.getModelo() != null && !seletor.getModelo().trim().isEmpty()) {
                stmt.setString(paramIndex++, "%" + seletor.getModelo() + "%");
            }
            if (seletor.getNomeMarca() != null && !seletor.getNomeMarca().trim().isEmpty()) {
                stmt.setString(paramIndex++, "%" + seletor.getNomeMarca() + "%");
            }
            if (seletor.getAnoInicial() != null) {
                stmt.setInt(paramIndex++, seletor.getAnoInicial());
            }
            if (seletor.getAnoFinal() != null) {
                stmt.setInt(paramIndex++, seletor.getAnoFinal());
            }

            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    Carro carro = new Carro();
                    carro.setId(resultado.getInt("id"));
                    carro.setModelo(resultado.getString("modelo"));
                    carro.setPlaca(resultado.getString("placa"));
                    carro.setAno(resultado.getInt("ano"));
                    carro.setValor(resultado.getDouble("valor"));

                    // Buscando montadora
                    int montadoraId = resultado.getInt("montadora_id");
                    Montadora montadora = consultarMontadoraPorId(montadoraId);
                    carro.setMontadora(montadora);

                    carros.add(carro);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao consultar carros com filtros");
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            Banco.closeConnection(conn);
        }

        return carros;
    }
    
    private Montadora consultarMontadoraPorId(int id) {
        return montadoraRepository.consultarPorId(id);
    }

    @Override
    public Carro salvar(Carro novaEntidade) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean excluir(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean alterar(Carro entidade) {
        // TODO Auto-generated method stub
        return false;
    }

   
}
