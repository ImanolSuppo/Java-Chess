package ar.edu.utn.frc.tup.lciii.DataBase;

import ar.edu.utn.frc.tup.lciii.*;
import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ar.edu.utn.frc.tup.lciii.DataBase.ChessDataBase.*;

public class ChessDataBaseDao {
    private Connection cnn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Board board;
    private TeamColor tm ;
    private Player playerOne;
    private Player playerTwo;

    public int insertJuego(int id_jugador_1, int id_jugador_2) { //vamos a poner todos los datos del sql a una lista y eso mismo va a retornar
        String sql = "insert into juegos(id_jugador_1,id_jugador_2) values (?,?)";

        int registro = 0;

        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.ps.setInt(1,id_jugador_1);
            this.ps.setInt(2,id_jugador_2);
            registro = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.ps);
                close(this.cnn);
            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public int insertBoards(Game game, int id_juego) { //vamos a poner todos los datos del sql a una lista y eso mismo va a retornar
        String sql = "insert into tiles(id_juego,tileX,tileY, namePart, typePart) values (?,?,?,?,?)";

        int registro = 0;

        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);

            for (int i=1;i<9;i++){
                for (int j=1;j<9;j++){
                    this.ps.setInt(1,id_juego);
                    this.ps.setInt(2,j);
                    this.ps.setInt(3,i);
                    this.ps.setString(4,game.getBoard().getBoard().get(registro).getName());
                    this.ps.setString(5,game.getBoard().getBoard().get(registro).getTypePart().toString());
                    registro += this.ps.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.ps);
                close(this.cnn);
            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }
    public int updateBoards(Game game, int id_juego, int id_tile) {
        String sql = "update tiles set tileX = ?, tileY = ?, namePart = ?, typePart = ? where id_juego = ? and id_tile = ?";

        int registro = 0;

        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);

            for (int i=1;i<9;i++){
                for (int j=1;j<9;j++){
                    this.ps.setInt(1,j);
                    this.ps.setInt(2,i);
                    this.ps.setString(3,game.getBoard().getBoard().get(registro).getName());
                    this.ps.setString(4,game.getBoard().getBoard().get(registro).getTypePart().toString());
                    this.ps.setInt(5,id_juego);
                    this.ps.setInt(6,id_tile);
                    registro += this.ps.executeUpdate();
                    id_tile++;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.ps);
                close(this.cnn);
            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }
    public int insertPlayers(Player player) {
        String sql = "insert into jugadores(nombre) values (?)";

        int registro = 0;

        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);

            this.ps.setString(1,player.getName());
            registro += this.ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.ps);
                close(this.cnn);
            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }
    public int inserthistoricalMovements(Game game, int id_juego) {
        String sql = "insert into historicalMovements(historicalMovement,id_juego) values (?,?)";

        int registro = 0;

        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);

            for (int i=0; i<game.getHistoricalMovements().size();i++){
                    this.ps.setString(1,game.getHistoricalMovements().get(i));
                    this.ps.setInt(2,id_juego);
                    registro += this.ps.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.ps);
                close(this.cnn);
            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registro;
    }

    public Game selectGame(int id_juego, List<String> historicalMovements) { //vamos a poner todos los datos del sql a una lista y eso mismo va a retornar
        String sql = "select j1.nombre as PlayerOne, j2.nombre as PlayerTwo, tileX, tileY, namePart, typePart from tiles t inner join juegos j on t.id_juego = j.id_juego inner join jugadores j1 on j1.id_jugador = j.id_jugador_1 inner join jugadores j2 on j2.id_jugador = j.id_jugador_2  where t.id_juego = " + id_juego;
        int cont = 0;
        historicalMovements = new ArrayList<>();
        playerOne = new Player();
        playerTwo = new Player();
        Game game = new Game();
        board = new Board();
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();


            while (this.rs.next()) {//recorre todos los registros
                String playerOneS = this.rs.getString("PlayerOne");
                String playerTwoS = this.rs.getString("PlayerTwo");

                int tileX = this.rs.getInt("tileX");
                int tileY = this.rs.getInt("tileY");
                String namePart = this.rs.getString("namePart");
                String typePart = this.rs.getString("typePart");

                this.board.getBoard().get(cont).setTileX(tileX);
                this.board.getBoard().get(cont).setTileY(tileY);
                this.board.getBoard().get(cont).setName(namePart);
                this.board.getBoard().get(cont).setTypePart(TypeParts.parse(typePart));
                this.board.getBoard().get(cont).setTypePart(TypeParts.parse(typePart));
                cont ++;

                playerOne.setName(playerOneS);
                playerTwo.setName(playerTwoS);
                playerOne.setTeamColor(tm.WHITE);
                playerTwo.setTeamColor(tm.BLACK);

                //TODO EZE
                game = new Game(playerOne,playerTwo,board,historicalMovements);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return game;
    }

    public void selectShowGames() {
        String sql = "select id_juego, j1.nombre PlayerOne, j2.nombre PlayerTwo from juegos j inner join jugadores j1 on j1.id_jugador = j.id_jugador_1 inner join jugadores j2 on j2.id_jugador = j.id_jugador_2 " ;
        int cont = 1;
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();


            while (this.rs.next()) {//recorre todos los registros
                int id_juego = this.rs.getInt("id_juego");
                String playerOneS = this.rs.getString("PlayerOne");
                String playerTwoS = this.rs.getString("PlayerTwo");
                System.out.println(id_juego +"- Juego de: " + playerOneS + " Y " + playerTwoS);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public int selectIdPlayers(Player player) {
        String sql = "select id_jugador from jugadores where nombre = '" + player.getName() + "'";
        int id_juego = 0;
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                id_juego = this.rs.getInt("id_jugador");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id_juego;
    }
    public int selectIdTile(int id_juego) {
        String sql = "select id_tile from tiles where id_juego = " + id_juego +"  limit 1";
        int id_tile = 0;
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                id_tile = this.rs.getInt("id_tile");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id_tile;
    }
    public List<String> selectHistoricalMovements(int id_juego) {
        String sql = "select * from historicalMovements where id_juego = " + id_juego;
        int contador = 1;
        List<String> historicalMovement = new ArrayList<>();
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                String historicalMovementS = this.rs.getString("historicalMovement");
                historicalMovement.add(historicalMovementS);
                contador++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return historicalMovement;
    }
    public int selectIdJuego(Player playerOne, Player playerTwo) {
        String sql = "select j.id_juego from juegos j inner join jugadores j1 on j.id_jugador_1 = j1.id_jugador inner join jugadores j2 on j.id_jugador_2 = j2.id_jugador where j1.nombre ='"+ playerOne.getName() + "'  and j2.nombre = '" + playerTwo.getName() +"'";
        int id_juego = 0;
        try {
            this.cnn = getConexion();
            this.ps = this.cnn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();


            while (this.rs.next()) {//recorre todos los registros
                id_juego = this.rs.getInt("id_juego");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cnn);

            } catch (SQLException ex) {
                Logger.getLogger(ChessDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id_juego;
    }
}