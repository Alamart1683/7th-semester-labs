package com.labs.labs.model;

public class JournalView {
    private int student_id;
    private int study_plan_id;
    private boolean in_time;
    private int count;
    private String mark_name;
    private String type;
    private int study_group_id;

    public JournalView(int student_id, int study_plan_id, boolean in_time, int count, String mark_name, String type, int study_group_id){
        this.student_id = student_id;
        this.study_plan_id = study_plan_id;
        this.in_time = in_time;
        this.count = count;
        this.mark_name = mark_name;
        this.type = type;
        this.study_group_id = study_group_id;
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public int getStudyPlanId() {
        return study_plan_id;
    }

    public void setStudyPlanId(int student_id) {
        this.student_id = study_plan_id;
    }

    public boolean getInTime() {
        return in_time;
    }

    public void setInTime(boolean in_time) {
        this.in_time = in_time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMarkName() {
        return mark_name;
    }

    public void setMarkName(String mark_name) {
        this.mark_name = mark_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStudyGroupId() {
        return study_group_id;
    }

    public void setStudyGroupId(int study_group_id) {
        this.study_group_id = study_group_id;
    }

}

