package provider;

import db.DbConnection;
import entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonProvider {

    public ArrayList<Person> getCandidates()throws SQLException, ClassNotFoundException {
        DbConnection connection = new DbConnection();
        ArrayList<Person> candidates = new ArrayList<>();
        ResultSet results =  connection.getData("SELECT * FROM candidatosA00369008");

        while(results.next()){
            int id = results.getInt("id");
            String president = results.getString("president");
            String vicepresident = results.getString("vicepresident");
            String presidentImage = results.getString("presidentImage");
            String vicepresidentImage = results.getString("vicepresidentImage");
            String groupImage = results.getString("groupImage");
            int votes = results.getInt("amountVotes");
            Person candidate = new Person(id,president,vicepresident,presidentImage,vicepresidentImage,groupImage,votes);
            candidates.add(candidate);
        }
        connection.close();
        return candidates;
    }
    public void updateTotalVotes(Person candidate) throws SQLException, ClassNotFoundException {
        DbConnection connection = new DbConnection();

        String sql = "SELECT * FROM candidatosA00369008 WHERE id = $ID";
        sql = sql.replace("$ID",Integer.toString(candidate.getId()));
        ResultSet results =  connection.getData(sql);
        Person can = new Person();
        while(results.next()){
            can.setAmountVotes(results.getInt("votes"));
        }
        sql="UPDATE candidatosA003699008 SET votes = $TOTAL WHERE id = $ID";
        sql= sql.replace("$ID",Integer.toString(candidate.getId()));
        sql = sql.replace("$TOTAL",Integer.toString(can.getAmountVotes()+1));
        connection.runQuery(sql);
        connection.close();
    }
}