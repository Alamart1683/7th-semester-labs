package com.labs.labs.controller;
import com.labs.labs.dao.JournalViewJdbc;
import com.labs.labs.model.JournalView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalViewController {

    private final JournalViewJdbc journalViewJdbc;

    public JournalViewController(JournalViewJdbc journalViewJdbc) {
        this.journalViewJdbc = journalViewJdbc;
    }

    @GetMapping("/journalview/all")
    public List<JournalView> getAll() {
        try {
            List<JournalView> journalViewList = journalViewJdbc.getAll();
            return journalViewList;
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return null;
        }
    }

    @GetMapping("/journalview/get/ByGroup/{study_group_id}")
    public List<JournalView> getByGroup(@PathVariable int study_group_id) {
        try {
            List<JournalView> journalViewList = journalViewJdbc.getByGroup(study_group_id);
            return journalViewList;
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return null;
        }
    }


}
