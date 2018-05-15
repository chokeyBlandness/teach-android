package group.usst.teach_android.utils;

import java.util.Date;

public class Course {
        private Long id;
        private Long teacherId;
        private Date day;
        private int isAble;

    public Course() {
    }

    public Course( Date day, int isAble) {
        this.day = day;
        this.isAble = isAble;
    }

    public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getTeacherId() {
                return teacherId;
        }

        public void setTeacherId(Long teacherId) {
                this.teacherId = teacherId;
        }

        public Date getDay() {
                return day;
        }

        public void setDay(Date day) {
                this.day = day;
        }

        public int getIsAble() {
                return isAble;
        }

        public void setIsAble(int isAble) {
                this.isAble = isAble;
        }
}
