package dao;


import java.util.ArrayList;
import dbconnector.DBConnector;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO implements DAOInterface
{
    private DBConnector dbc = new DBConnector();
    
    public DAO(DataSource ds)
    {
        dbc.setDataSource(ds);
    }
    
    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> users = new ArrayList();
        
        try
        {
            dbc.open();
            
            String sql = "select * from user, team_member where user.user_id = team_member.user_id and team_member.team_id = " + team_id;
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                User u = new User(userid, username, userpassword, admin);
                
                users.add(u);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return users;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList();
        
        try
        {
            dbc.open();
            
            String sql = "select * from team";
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int teamid = resultset.getInt("team_id");
                String teamname = resultset.getString("teamname");

                Team t = new Team(teamid, teamname);
                
                teams.add(t);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return teams;
    }

    @Override
    public Team getTeam(int id)
    {
        try
        {
            dbc.open();
            
            String sql = "select * from team where team_id = " + id;
            ResultSet resultset = dbc.query(sql);

            if(resultset.next())
            {
                int teamid = resultset.getInt("team_id");
                String teamname = resultset.getString("teamname");

                return new Team(teamid, teamname);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Team getTeam(String name) {
        try
        {
            dbc.open();
            
            String sql = "select * from team where teamname = '" + name + "'";
            ResultSet resultset = dbc.query(sql);

            if(resultset.next())
            {
                int teamid = resultset.getInt("team_id");
                String teamname = resultset.getString("teamname");

                return new Team(teamid, teamname);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;        
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList();
        
        try
        {
            dbc.open();
            
            String sql = "select * from user";
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                User u = new User(userid, username, userpassword, admin);
                
                users.add(u);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return users;
    }

    @Override
    public User getUser(int id) {
        try
        {
            dbc.open();
            
            String sql = "select * from user where user_id = " + id;
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                return new User(userid, username, userpassword, admin);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public User getUser(String name) {
        try
        {
            dbc.open();
            
            String sql = "select * from user where username = " + name;
            ResultSet resultset = dbc.query(sql);

            while(resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                return new User(userid, username, userpassword, admin);
            }
            
            dbc.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
}
