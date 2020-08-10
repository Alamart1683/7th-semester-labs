package com.labs.labs.dao;
import com.labs.labs.model.JournalView;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JournalViewJdbc {

    private final JdbcTemplate jdbcTemplate;

    public JournalViewJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<JournalView> getAll() {
        List<JournalView> journalViewList = jdbcTemplate.query("select STUDY_PLAN_ID, STUDENT_ID, " +
                "IN_TIME, COUNT, m.NAME as mark_name, e.TYPE, t.study_group_id " +
                "from journal j inner join STUDY_PLAN s on j.STUDY_PLAN_ID=s.ID " +
                "inner join EXAM_TYPE e on s.EXAM_TYPE_ID=e.ID " +
                "inner join MARK m on j.MARK_ID=m.ID " +
                "inner join STUDENT t on j.STUDENT_ID=t.ID", this::mapJournalView);
        return journalViewList;
    }

    public List<JournalView> getByGroup(int study_group_id) {
        List<JournalView> journalViewList = jdbcTemplate.query("select STUDY_PLAN_ID, STUDENT_ID, " +
                "IN_TIME, COUNT, m.NAME as mark_name, e.TYPE, t.study_group_id " +
                "from journal j inner join STUDY_PLAN s on j.STUDY_PLAN_ID=s.ID " +
                "inner join EXAM_TYPE e on s.EXAM_TYPE_ID=e.ID " +
                "inner join MARK m on j.MARK_ID=m.ID " +
                "inner join STUDENT t on j.STUDENT_ID=t.ID where t.study_group_id = " + study_group_id, this::mapJournalView);
        return journalViewList;
    }

    private JournalView mapJournalView(ResultSet rs, int i) throws SQLException {
        JournalView journal = new JournalView(
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getString("mark_name"),
                rs.getString("type"),
                rs.getInt("study_group_id")
        );
        return journal;
    }

}

