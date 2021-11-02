package com.java.spr;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import oracle.net.aso.c;

public class AgentDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String deleteAgent(int agentid) {
		String cmd = "delete from Agent where agentid=?";
		jdbcTemplate.update(cmd,new Object[] {agentid});
		return "Record Deleted...";
	}

	public String updateAgent(Agent agent) {
		String cmd = "Update Agent set Name=?,City=?, Gender=?, Maritalstatus=?,"
				+ " Premium=? Where Agentid=?";
		
		jdbcTemplate.update(cmd,new Object[] { 
				 agent.getName(),agent.getCity(),agent.getGender(),agent.getMaritalstatus(),
				 agent.getPremium(),agent.getAgentid()
			});
		return "Record Updated...";
	}
	public String addAgent(Agent agent) {
		String cmd = "insert into Agent(agentid,name,city,gender,maritalstatus,premium)  "
				+ " values(?,?,?,?,?,?)";
		jdbcTemplate.update(cmd,new Object[] {agent.getAgentid(), 
				agent.getName(),agent.getCity(),agent.getGender(),agent.getMaritalstatus(),
				 agent.getPremium()
			});
		return "Record Inserted...";
	}
	public Agent searchAgent(int agentid) {
		String sql = "select * from Agent where agentid=?";
	    return jdbcTemplate.query(sql,new Object[] {agentid}, new ResultSetExtractor<Agent>() {
	        @Override
	        public Agent extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Agent agent = new Agent();
		            agent.setAgentid(rs.getInt("agentid"));
		            agent.setName(rs.getString("name"));
		            agent.setCity(rs.getString("city"));
		            agent.setGender(rs.getString("gender"));
		            agent.setMaritalstatus(rs.getInt("maritalstatus"));
		            agent.setPremium(rs.getDouble("premium"));
		            return agent;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public Agent[] showAgent() {
		String cmd = "select * from Agent";
		List<Agent> agentList = null;
		
		agentList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent agent= new Agent();
				agent.setAgentid(rs.getInt("agentid"));
	            agent.setName(rs.getString("name"));
	            agent.setCity(rs.getString("city"));
	            agent.setGender(rs.getString("gender"));
	            agent.setMaritalstatus(rs.getInt("maritalstatus"));
	            agent.setPremium(rs.getDouble("premium"));
	            return agent;
			}
			
		});
		return agentList.toArray(new Agent[agentList.size()]);
	}
}

