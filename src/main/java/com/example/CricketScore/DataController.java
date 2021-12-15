package com.example.CricketScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@RestController
public class DataController {

    @Autowired
    DataService service;

    @GetMapping("/players")
    public List<String> getInfo(){
        List<String> players = new ArrayList<>();
        Connection con = service.provideConncection();
        String query = "select * from playerinfo";
        ResultSet res = null;
        try {
            Statement s = con.createStatement();
            res = s.executeQuery(query);
            while (res.next()){
                players.add(res.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @GetMapping("/score")
    public List<CurrPlayerInfo> getCurrScore(){
        Connection con = service.provideConncection();
        int totalScore=0;
        int totalOut = 0;
        List<CurrPlayerInfo> currplayer = new ArrayList<>();
        String query = "select * from scores";
        ResultSet rs = null;
        try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                totalScore+=rs.getInt("score");
                if(Boolean.parseBoolean(rs.getString("wicket")))
                    totalOut+=1;
                else
                {
                    currplayer.add(new CurrPlayerInfo(rs.getString("name"),rs.getInt("score"),rs.getInt("ball"),"Current Player"));
                }
            }
            currplayer.add((new CurrPlayerInfo("total",totalScore,totalOut,".")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return currplayer;
    }

    @GetMapping("/scoresheet/{playername}/out")
    public String playerOut(@PathVariable("playername") String name){
        Connection con = service.provideConncection();
        Statement st = con.createStatement();
        String query = "select * from scores where sname="+name;
        ResultSet set = st.executeQuery();
    }

    @GetMapping("/completescore")
    public List getTotalScore(){
        Connection con = service.provideConncection();
        String query = "select * from playerinfo  left outer join scores  on  name=sname";
        Map<String,String> inactivate = new HashMap<>();
        List<CurrPlayerInfo> currPlayer = new ArrayList<>();
        List totalScores = new ArrayList();
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                if(rs.getString("sname")==null)
                     inactivate.put(rs.getString("name"),"Did Not Bat");
                else
                {
                    currPlayer.add(new CurrPlayerInfo(rs.getString("name"),rs.getInt("score"),rs.getInt("ball"),rs.getString("wicket")));
                }
            }
            totalScores.addAll(currPlayer);
            //totalScores.addAll((Collection) inactivate);
            totalScores.add(inactivate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalScores;
    }


}
