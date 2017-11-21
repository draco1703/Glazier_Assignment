package dao;

import java.util.ArrayList;
import entity.Team;
import entity.User;

public interface DAOInterface
{
    public ArrayList<User> getTeamMembers(int team_id);
    public ArrayList<Team> getTeams();
    public Team getTeam(int id);
    public Team getTeam(String teamname);
    public ArrayList<User> getUsers();
    public User getUser(int id);
    public User getUser(String username);
}